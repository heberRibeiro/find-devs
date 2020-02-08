package com.heber.backendfinddevs.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.heber.backendfinddevs.domain.Dev;
import com.heber.backendfinddevs.dto.DevDTO;
import com.heber.backendfinddevs.services.DevService;

@RestController
@RequestMapping
public class DevResource {

	@Autowired
	private DevService devService;

	@Autowired
	private RestTemplate template;

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

		ResponseEntity<DevDTO> entity = template.getForEntity(url.toUri(), DevDTO.class);

		Dev dev = new Dev(null, entity.getBody().getName(), entity.getBody().getGithub_username(),
				entity.getBody().getBio(), entity.getBody().getAvatar_url(), devDto.getTechs().trim().split(",|;|-"),
				devDto.getLongitude(), devDto.getLatitude());

		dev = devService.insert(dev);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dev.getId()).toUri();

		return ResponseEntity.created(uri).body(dev);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<List<Dev>> findByTechs(@RequestParam(value = "techs") String techs) {
		String[] techsList = techs.trim().split(",|;|-");

		List<Dev> devs = devService.findByTechs(techsList);

		return ResponseEntity.ok().body(devs);
	}

}
