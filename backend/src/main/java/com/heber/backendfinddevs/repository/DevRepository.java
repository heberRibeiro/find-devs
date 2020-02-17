package com.heber.backendfinddevs.repository;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.heber.backendfinddevs.domain.Dev;

@Repository
public interface DevRepository extends MongoRepository<Dev, String> {

	/*
	 * References:
	 * https://docs.mongodb.com/manual/reference/operator/query/in/#op._S_in
	 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo
	 * .repositories
	 * 
	 */

	@Query("{ 'github_username' : ?0 }")
	Dev findDevsByGithub_username(String github_username);
	
	// Find Devs by location and a tech's list.
	@Query("{$and : [ {'techs' : { $in : ?0 } },  {'location' : { $nearSphere : ?1, $maxDistance: ?2 } } ] }")
	List<Dev> findByTechsAndLocation(String[] techs, GeoJsonPoint point, Double distance);
}
