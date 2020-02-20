package com.heber.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.heber.backend.domain.Dev;
import com.heber.backend.repository.DevRepository;

/*** Classe de configuração para carga inicial de dados ***/

@Configuration
public class DataInstantiation implements CommandLineRunner {

	@Autowired
	private DevRepository devRepository;

	@Override
	public void run(String... args) throws Exception {

		devRepository.deleteAll();

		Dev joao = new Dev(null, "João da Silva", "joaosilva", "Desenvolvedor web", "", new String[] {"Java", "Vue.js"},
				new GeoJsonPoint(-34.8792867, -8.0575563));
		Dev maria = new Dev(null, "Maria da Silva", "mariasilva", "Desenvolvedora web", "", new String[] {"Java", "React", "React Native"},
				new GeoJsonPoint(-34.8787289, -8.0544119));
		Dev jose = new Dev(null, "José da Silva", "josesilva", "Desenvolvedor web", "", new String[] {"React"},
				new GeoJsonPoint(-34.8732786, -8.0527015));

		devRepository.saveAll(Arrays.asList(joao, maria, jose));
	}

}
