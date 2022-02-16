package org.microservicio.service;

import org.microservicio.entity.Saludo;
import org.microservicio.repository.SaludoRepository;
import org.microservicio.request.CreateSaludoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

	@Autowired // SaludoRepository saludoRepo = new SaludoRepository();
	private SaludoRepository saludoRepo;
	
	// AGREGAR UN SALUDO
	public Saludo agregarSaludo(CreateSaludoRequest request) {
		Saludo saludo = new Saludo(request);
		saludoRepo.save(saludo);
		return saludo;
	}
	
	// SALUDO POR TIPO
	public Saludo saludoPorTipo(String tipoSaludo) {
		return saludoRepo.findByTipoSaludo(tipoSaludo);
	}
}
