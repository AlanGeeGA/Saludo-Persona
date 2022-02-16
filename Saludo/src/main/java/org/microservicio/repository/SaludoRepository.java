package org.microservicio.repository;

import org.microservicio.entity.Saludo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaludoRepository extends JpaRepository<Saludo, Long>{
	
	Saludo findByTipoSaludo(String tipoSaludo);
}
