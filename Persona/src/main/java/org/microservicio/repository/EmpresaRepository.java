package org.microservicio.repository;

import org.microservicio.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByNombreEmpresa(String nombreEmpresa);
}
