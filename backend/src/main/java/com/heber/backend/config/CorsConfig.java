package com.heber.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	/*===== CORS CONFIGURATION =====*/
	
	/*
	 * In the development profile, the react frontend application runs locally on port 3000, 
	 * and it is on this host and port that CORS in that profile is enabled.
	 * When running in a container, the React frontend application can be accessed locally (Docker desktop), 
	 * or it can be accessed via the docker machine's ip (Docker toolbox). Therefore, CORS is enabled for both hosts.
	 * 
	 */

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD", "TRACE", "CONNECT")
				.allowedOrigins("http://localhost:3000", "http://192.168.99.100:3000")
				.allowedHeaders("Content-Type", "Accept")
				.exposedHeaders("Content-Length");
	}
}
