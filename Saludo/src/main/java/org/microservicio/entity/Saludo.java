package org.microservicio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.microservicio.request.CreateSaludoRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "saludos")
public class Saludo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipo", unique = true)
	private String tipoSaludo;
	
	@Column(name = "saludo")
	private String saludo;
	
	public Saludo(CreateSaludoRequest request) {
		this.tipoSaludo = request.getTipoSaludo();
		this.saludo = request.getSaludo();
	}
	
}
