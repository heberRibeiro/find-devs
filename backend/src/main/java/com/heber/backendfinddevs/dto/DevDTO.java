package com.heber.backendfinddevs.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.heber.backendfinddevs.domain.Dev;

public class DevDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String bio;
	private String avatar_url;
	@JsonAlias({ "github_username", "login" }) // Defines one or more alternative names for a property during deserialization.
	private String github_username;
	private String techs;
	private Double longitude;
	private Double latitude;

	public DevDTO() {

	}

	public DevDTO(Dev dev) {
		github_username = dev.getGithub_username();
		techs = dev.getTechs().toString();
		longitude = dev.getLocation().getX();
		latitude = dev.getLocation().getY();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
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

	@Override
	public String toString() {
		return "DevDTO [name=" + name + ", bio=" + bio + ", avatar_url=" + avatar_url + ", github_username="
				+ github_username + ", techs=" + techs + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
}
