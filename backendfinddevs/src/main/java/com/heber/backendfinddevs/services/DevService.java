package com.heber.backendfinddevs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heber.backendfinddevs.domain.Dev;
import com.heber.backendfinddevs.repository.DevRepository;
import com.heber.backendfinddevs.services.exception.ObjectNotAllowedException;

@Service
public class DevService {

	@Autowired
	private DevRepository devRepository;

	public List<Dev> findAll() {
		return devRepository.findAll();
	}

	public Dev insert(Dev dev) {

		Dev obj = devRepository.findUsersBygithub_username(dev.getGithub_username());
		if (obj != null) {
			throw new ObjectNotAllowedException("GitHub UserName já inserio");
		}

		return devRepository.insert(dev);
	}
	
	public List<Dev> findByTechs(String[] techs) {
		return devRepository.findByTechs(techs);
	}

}
