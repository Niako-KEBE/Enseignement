package com.uasz.enseign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.uasz.enseign.entities")
public class EnseignApplication implements CommandLineRunner {

	public static void main(String[] args)
	{
		SpringApplication.run(EnseignApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
