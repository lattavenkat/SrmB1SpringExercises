package com.org.spring.springrest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Springrest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springrest1Application.class, args);
	}

}
