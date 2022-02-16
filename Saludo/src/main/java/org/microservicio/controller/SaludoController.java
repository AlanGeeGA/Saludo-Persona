package org.microservicio.controller;

import org.microservicio.entity.Saludo;
import org.microservicio.request.CreateSaludoRequest;
import org.microservicio.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/saludos")
public class SaludoController {
	
	@Autowired
	SaludoService saludoService;
	
	@PostMapping("/agregarSaludo")
	public Saludo agregarSaludo(@RequestBody CreateSaludoRequest request) {
		return saludoService.agregarSaludo(request);
	}
	
	@GetMapping("/saludoPorTipo/{tipoSaludo}")
	public Saludo saludoPorTipo(@PathVariable String tipoSaludo) {
		return saludoService.saludoPorTipo(tipoSaludo);
	}
}
