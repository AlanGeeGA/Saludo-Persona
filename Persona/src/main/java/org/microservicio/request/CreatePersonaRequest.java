package org.microservicio.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonaRequest {
	
	private String nombre;
	
	private Integer edad;
	
	private String direccion;
	
	private String nombreEmpresa;
	
	private String direccionEmpresa;
}
