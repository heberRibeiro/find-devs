package com.heber.backendfinddevs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.heber.backendfinddevs.domain.Dev;
import com.heber.backendfinddevs.repository.DevRepository;
import com.heber.backendfinddevs.resources.util.Convert;
import com.heber.backendfinddevs.resources.util.URL;
import com.heber.backendfinddevs.services.exception.ObjectNotAllowedException;

@Service
public class DevService {

	@Autowired
	private DevRepository devRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Dev> findAll() {
		return devRepository.findAll();
	}

	public Dev insert(Dev dev) {

		Dev obj = devRepository.findDevsByGithub_username(dev.getGithub_username());
		if (obj != null) {
			throw new ObjectNotAllowedException("GitHub UserName já inserio");
		}

		return devRepository.insert(dev);
	}

	public List<Dev> findByTechsAndLocation(String[] techs, GeoJsonPoint point, Double distance) {
		return devRepository.findByTechsAndLocation(techs, point, distance);
	}

	public List<Dev> findByTechsAndLocation_mongoRepository(String techs, Double longitude, Double latitude,
			Double max) {

		String techsDecode = URL.decodeParam(techs);
		List<String> techsList = Convert.StringToArrayList(techsDecode);

		Point point = new Point(longitude, latitude);
		Query query = new Query();
		Criteria criteriaLocation = Criteria.where("location").nearSphere(point).maxDistance(max)
				.andOperator(Criteria.where("techs").in(techsList));

		query.addCriteria(criteriaLocation);

		List<Dev> dev = mongoTemplate.find(query, Dev.class);

		return dev;
	}

}
