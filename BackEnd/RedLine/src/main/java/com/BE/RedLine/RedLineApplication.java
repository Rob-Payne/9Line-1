package com.BE.RedLine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RedLineApplication {
private String ExpectedURL = "http://localhost:3000";
	public static void main(String[] args) {
		SpringApplication.run(RedLineApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/requests")
						.allowedMethods("GET")
						.allowedOrigins(ExpectedURL)
				;
				registry.addMapping("/requests/{id}")
						.allowedMethods("GET","PATCH")
						.allowedOrigins(ExpectedURL)
				;
				registry.addMapping("/responder/{name}")
						.allowedMethods("GET")
						.allowedOrigins(ExpectedURL)
				;
				registry.addMapping("/nineline")
						.allowedMethods("POST")
						.allowedOrigins(ExpectedURL)
				;
			}
		};
	}
}
