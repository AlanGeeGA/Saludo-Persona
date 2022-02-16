package org.microservicio.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class CreateSaludoRequest {
	
	private String tipoSaludo;
	
	private String saludo;
}
