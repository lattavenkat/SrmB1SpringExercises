package com.org.spring.onetoone;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnetooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
	}

    @Bean
    public CommandLineRunner mappingDemo(UserRepository userRepository,
                                         AddressRepository addressRepository) {
        return args -> {

            Users user = new Users("murali", "murali@yahoo.com", "muralipass");

            Address address = new Address("Block 2", "chennai", "tamil nadu",
                    "600038", "india");

            address.setUser(user);
            user.setAddress(address);
            userRepository.save(user);
        };
    }
}
