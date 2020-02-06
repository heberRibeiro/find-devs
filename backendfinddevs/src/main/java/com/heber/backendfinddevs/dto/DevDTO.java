package com.heber.backendfinddevs.dto;

import java.io.Serializable;

import com.heber.backendfinddevs.domain.Dev;

public class DevDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String github_username;
	private String techs;
	private Double longitude;
	private Double latitude;

	public DevDTO() {

	}

	public DevDTO(Dev dev) {
		github_username = dev.getGithub_username();
		techs = dev.getTechs();
		longitude = dev.getLongitude();
		latitude = dev.getLatitude();
	}

	public String getGithub_username() {
		return github_username;
	}

	public void setGithub_username(String github_username) {
		this.github_username = github_username;
	}

	public String getTechs() {
		return techs;
	}

	public void setTechs(String techs) {
		this.techs = techs;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
