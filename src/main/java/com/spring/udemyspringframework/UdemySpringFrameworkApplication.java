package com.spring.udemyspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.*")
@EntityScan("com.spring.*")
public class UdemySpringFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemySpringFrameworkApplication.class, args);
	}

}
