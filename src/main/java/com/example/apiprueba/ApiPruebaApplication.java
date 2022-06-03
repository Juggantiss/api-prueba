package com.example.apiprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPruebaApplication.class, args);
	}

}
