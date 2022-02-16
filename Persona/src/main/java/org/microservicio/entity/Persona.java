package org.microservicio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.microservicio.request.CreatePersonaRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "direccion")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	public Persona(CreatePersonaRequest request) {
		this.nombre = request.getNombre();
		this.edad = request.getEdad();
		this.direccion = request.getDireccion();
	}
}
