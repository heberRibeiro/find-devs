package com.heber.backend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.heber.backend.domain.Dev;
import com.heber.backend.dto.DevDTO;
import com.heber.backend.resources.util.Convert;
import com.heber.backend.resources.util.URL;
import com.heber.backend.services.DevService;

@RestController
@RequestMapping
public class DevResource {

	@Autowired
	private DevService devService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/devs")
	public ResponseEntity<List<Dev>> findAll() {
		List<Dev> devs = devService.findAll();
		return ResponseEntity.ok(devs);
	}

	@PostMapping(value = "/devs")
	public ResponseEntity<Dev> insert(@RequestBody DevDTO devDto) {
		/*
		 * From github_username, fetching the Dev's informations using GitHub's API --
		 * https://api.github.com/users/{github_username} --
		 */

		UriComponents url = UriComponentsBuilder.newInstance().scheme("https").host("api.github.com/users")
				.path(devDto.getGithub_username()).build();

		ResponseEntity<DevDTO> entity = restTemplate.getForEntity(url.toUri(), DevDTO.class);

		Dev dev = new Dev(null, entity.getBody().getName(), entity.getBody().getGithub_username(),
				entity.getBody().getBio(), entity.getBody().getAvatar_url(), Convert.StringToArray(devDto.getTechs()),
				new GeoJsonPoint(devDto.getLongitude(), devDto.getLatitude()));

		dev = devService.insert(dev);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dev.getId()).toUri();

		return ResponseEntity.created(uri).body(dev);
	}


	@GetMapping(value = "/search")
	public ResponseEntity<List<Dev>> findLocation(
			@RequestParam(value = "techs") String techs,
			@RequestParam(value = "longitude") Double longitude, 
			@RequestParam(value = "latitude") Double latitude,
			@RequestParam(value = "distance", defaultValue = "200") Double distance) {
		
		String techsDecode = URL.decodeParam(techs);
		String[] techsList = Convert.StringToArray(techsDecode);

		GeoJsonPoint point = new GeoJsonPoint(longitude, latitude);
		List<Dev> devs = devService.findByTechsAndLocation(techsList, point, distance);
		
		return ResponseEntity.ok().body(devs);
	}

	/*
	 * Search implementation using MongoTemplate
	 */
	@GetMapping(value = "/searchmongotemplate")
	public ResponseEntity<List<Dev>> findByLocation(
			@RequestParam(value = "techs") String techs, 
			@RequestParam(value = "longitude") Double longitude,
			@RequestParam(value = "latitude") Double latitude,
			@RequestParam(value = "distance", defaultValue = "200") Double max) {


		List<Dev> devs = devService.findByTechsAndLocation_mongoRepository(techs, longitude, latitude, max);
		
		return ResponseEntity.ok().body(devs);
	}

}
