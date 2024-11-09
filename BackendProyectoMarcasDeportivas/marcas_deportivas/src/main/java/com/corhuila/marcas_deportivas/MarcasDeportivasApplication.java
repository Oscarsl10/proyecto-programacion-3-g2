package com.corhuila.marcas_deportivas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación SpringBootApplication configura el proyecto como una apliacación de spreenBoot, lo que le da permisos de buscar componentes,
// le da permisos de configuración y demás.
@SpringBootApplication
public class MarcasDeportivasApplication {

	// Clase main principal
	public static void main(String[] args) {
		SpringApplication.run(MarcasDeportivasApplication.class, args);
	}

}
