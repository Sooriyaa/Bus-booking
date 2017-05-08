package com.usecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.usecase"})
@EntityScan("com.usecase")
@EnableJpaRepositories("com.usecase")
public class UsecaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsecaseApplication.class, args);
	}
}
