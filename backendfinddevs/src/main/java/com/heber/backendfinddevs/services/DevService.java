package com.heber.backendfinddevs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heber.backendfinddevs.domain.Dev;
import com.heber.backendfinddevs.repository.DevRepository;

@Service
public class DevService {

	@Autowired
	private DevRepository devRepository;

	public List<Dev> findAll() {
		return devRepository.findAll();
	}
	
	public Dev insert(Dev dev) {
		return devRepository.insert(dev);
	}

}
