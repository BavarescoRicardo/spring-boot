package com.ricardotcc.spring;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ricardotcc.spring.model.Role;
import com.ricardotcc.spring.service.LoginServicesImpl;


@SpringBootApplication
public class Application {

public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean
	// CommandLineRunner run(LoginServicesImpl loginServicos){
	// 	return args -> {
	// 		loginServicos.salvarRole(new Role(null, "ROLE_USER"));
	// 		loginServicos.salvarRole(new Role(null, "ROLE_ADMIN"));
	// 		loginServicos.salvarRole(new Role(null, "ROLE_SUPERADMIN"));

	//  		loginServicos.adicionarRole("ricardo", "ROLE_ADMIN");
	// 		loginServicos.adicionarRole("tolkien", "ROLE_ADMIN");
	// 	};
	// }

}