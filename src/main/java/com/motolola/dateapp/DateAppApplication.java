package com.motolola.dateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.motolola.dateapp")
public class DateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateAppApplication.class, args);
	}
}
