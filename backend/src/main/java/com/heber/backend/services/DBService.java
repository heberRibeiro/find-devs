package com.heber.backend.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import com.heber.backend.domain.Dev;
import com.heber.backend.repository.DevRepository;

@Service
public class DBService {

	@Autowired
	private DevRepository devRepository;

	public void dataInstatiation() {

		if (devRepository.count() == 0) {

			Dev thiagojacinto = new Dev(null, "Thiago Jacinto", "thiagojacinto",
					"Engineer, problem solver, data interested in.",
					"https://avatars1.githubusercontent.com/u/46906069?v=4",
					new String[] { "JavaScript", "React", "Bootstrap" }, new GeoJsonPoint(-34.8792867, -8.0575563));

			Dev chenrique13 = new Dev(null, "Carlos Pereira", "chenrique13", "Engenheiro da Computação.",
					"https://avatars2.githubusercontent.com/u/56885446?v=4",
					new String[] { "Java", "Spring Boot", "HTML", "CSS" }, new GeoJsonPoint(-34.8787289, -8.0544119));

			Dev wilsonvieira1994 = new Dev(null, "Wilson Vieira", "wilsonvieira1994", null,
					"https://avatars2.githubusercontent.com/u/58172436?v=4", new String[] { "Java", "HTML", "CSS" },
					new GeoJsonPoint(-34.8732786, -8.0527015));

			devRepository.saveAll(Arrays.asList(thiagojacinto, chenrique13, wilsonvieira1994));
		}
	}

}
