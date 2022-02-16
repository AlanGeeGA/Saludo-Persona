package org.microservicio.response;

import org.microservicio.entity.Saludo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaludoResponse {
	
	private long id;
	
	private String tipoSaludo;
	
	private String saludo;
	
	public SaludoResponse(Saludo saludo) {
		this.id = saludo.getId();
		this.tipoSaludo = saludo.getTipoSaludo();
		this.saludo = saludo.getSaludo();
	}
}
