package org.microservicio.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaludoResponse {
	
	private long id;
	
	private String tipoSaludo;
	
	private String saludo;
}
