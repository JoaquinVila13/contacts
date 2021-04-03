package com.example.ng5api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Ng5ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ng5ApiApplication.class, args);
	}

}
