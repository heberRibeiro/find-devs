package com.heber.backendfinddevs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.heber.backendfinddevs.domain.Dev;

@Repository
public interface DevRepository extends MongoRepository<Dev, String> {

	@Query("{ 'github_username' : ?0 }")
	Dev findUsersBygithub_username(String github_username);

}
