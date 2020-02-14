package com.heber.backendfinddevs.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dev")
public class Dev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String github_username;
	private String bio;
	private String avatar_url;
	private String[] techs;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;

	/**
	 * location is stored in GeoJSON format. { "type" : "Point", "coordinates" : [
	 * x, y ] }
	 */

	public Dev() {

	}

	public Dev(String id, String name, String github_username, String bio, String avatar_url, String[] techs,
			GeoJsonPoint location) {
		this.id = id;
		this.name = name;
		this.github_username = github_username;
		this.bio = bio;
		this.avatar_url = avatar_url;
		this.techs = techs;
		this.location = location;// new GeoJsonPoint(longitude, latitude);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGithub_username() {
		return github_username;
	}

	public void setGithub_username(String github_username) {
		this.github_username = github_username;
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

	public String[] getTechs() {
		return techs;
	}

	public void setTechs(String[] techs) {
		this.techs = techs;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
