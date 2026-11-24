package com.build.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties
public class ShoppingCartBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartBackendApplication.class, args);
	}

}
