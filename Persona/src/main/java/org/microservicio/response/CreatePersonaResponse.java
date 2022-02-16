package org.microservicio.response;

import org.microservicio.entity.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonaResponse {
	
	private String saludo;
	
	private long id;
	
	private String nombre;
	
	private int edad;
	
	private String direccion;
	
	private String nombreEmpresa;
	
	private String direccionEmpresa;
	
	public CreatePersonaResponse(Persona persona) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.edad = persona.getEdad();
		this.direccion = persona.getDireccion();
		this.nombreEmpresa = persona.getEmpresa().getNombreEmpresa();
		this.direccionEmpresa = persona.getEmpresa().getDireccionEmpresa();
	}
}
