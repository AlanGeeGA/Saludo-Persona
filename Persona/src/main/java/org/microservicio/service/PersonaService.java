package org.microservicio.service;

import java.time.LocalDateTime;
import java.util.List;

import org.microservicio.entity.Empresa;
import org.microservicio.entity.Persona;
import org.microservicio.exception.SinPersonasException;
import org.microservicio.repository.EmpresaRepository;
import org.microservicio.repository.PersonaRepository;
import org.microservicio.request.CreatePersonaRequest;
import org.microservicio.response.SaludoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepo;
	
	@Autowired
	EmpresaRepository empresaRepo;
	
	public Persona agregarPersona(CreatePersonaRequest request) {
		Persona persona = new Persona(request);
		
		Empresa empresa = new Empresa();
		empresa.setNombreEmpresa(request.getNombreEmpresa());
		empresa.setDireccionEmpresa(request.getDireccionEmpresa());
		
		if (empresaRepo.findByNombreEmpresa(empresa.getNombreEmpresa()) == null) {
			empresaRepo.save(empresa);
		} else {
			empresa = empresaRepo.findByNombreEmpresa(empresa.getNombreEmpresa());
		}
		
		persona.setEmpresa(empresa);
		personaRepo.save(persona);
		
		return persona;
	}
	
	public List<Persona> getPersonas() {
		List<Persona> personas = personaRepo.findAll();
		if (personas.isEmpty()) {
			throw new SinPersonasException("No hay personas en la base de datos");
		}
		return personas;
	}
	
	public Persona getPersonaPorNombre(String nombre) {
		return personaRepo.findByNombre(nombre);
	}
	
	public SaludoResponse obtenerSaludo() {
		String url = "http://localhost:8080/api/saludos/saludoPorTipo/";
		String saludoTipo = "";
		
		int hora = LocalDateTime.now().getHour();
		if (hora > 4 && hora < 12) {
			saludoTipo = "mañana";
		} else if (hora >= 12 && hora < 19) {
			saludoTipo = "tarde";
		} else if (hora >= 19 && hora <= 4) {
			saludoTipo = "noche";
		}
		
		RestTemplate restTemplate = new RestTemplate();
		SaludoResponse saludoResponse = new SaludoResponse();
		saludoResponse = restTemplate.getForObject(url + saludoTipo, SaludoResponse.class);
		
		return saludoResponse;
	}
	
}
