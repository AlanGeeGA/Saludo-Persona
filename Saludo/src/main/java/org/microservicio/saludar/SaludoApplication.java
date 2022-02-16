package org.microservicio.saludar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.microservicio.controller", "org.microservicio.service", "org.microservicio.exception"})
@EntityScan("org.microservicio.entity")
@EnableJpaRepositories("org.microservicio.repository")
public class SaludoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludoApplication.class, args);
	}

}
