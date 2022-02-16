package org.microservicio.controller;

import java.util.ArrayList;
import java.util.List;

import org.microservicio.entity.Persona;
import org.microservicio.request.CreatePersonaRequest;
import org.microservicio.response.CreatePersonaResponse;
import org.microservicio.response.PersonaResponse;
import org.microservicio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@PostMapping("/agregarPersona")
	public CreatePersonaResponse agregarPersona(@RequestBody CreatePersonaRequest request) {
		Persona persona = personaService.agregarPersona(request);
		CreatePersonaResponse personaResponse = new CreatePersonaResponse(persona);
		
		personaResponse.setSaludo(personaService.obtenerSaludo().getSaludo());
		
		return personaResponse;
	}
	
	@GetMapping("/getPersonas")
	public List<PersonaResponse> getPersonas() {
		List<Persona> personasList = personaService.getPersonas();
		List<PersonaResponse> personasReponseList = new ArrayList<>();
		
		personasList.stream().forEach(persona -> personasReponseList.add(new PersonaResponse(persona)));
		
		return personasReponseList;
	}
	
	@GetMapping("/getPersonaPorNombre/{nombre}")
	public PersonaResponse getPersonaPorNombre(@PathVariable String nombre) {
		return new PersonaResponse(personaService.getPersonaPorNombre(nombre));
	}
}
