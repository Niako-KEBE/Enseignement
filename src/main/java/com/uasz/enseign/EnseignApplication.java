package com.uasz.enseign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.uasz.enseign")
@ComponentScan(basePackages = "com.uasz.enseign.mappers") // Adjust the package name

public class EnseignApplication {
	public static void main(String[] args) {
		SpringApplication.run(EnseignApplication.class, args);
	}
}

