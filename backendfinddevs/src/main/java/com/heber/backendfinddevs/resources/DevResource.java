package com.heber.backendfinddevs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heber.backendfinddevs.domain.Dev;
import com.heber.backendfinddevs.services.DevService;

@RestController
@RequestMapping(value = "/devs")
public class DevResource {

	@Autowired
	private DevService devService;

	@GetMapping
	public ResponseEntity<List<Dev>> findAll() {
		List<Dev> devs = devService.findAll();
		return ResponseEntity.ok(devs);
	}
}
