package com.heber.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		return template;
	}
}
