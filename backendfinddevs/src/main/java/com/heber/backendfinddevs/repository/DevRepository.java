package com.heber.backendfinddevs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.heber.backendfinddevs.domain.Dev;

@Repository
public interface DevRepository extends MongoRepository<Dev, String> {

	@Query("{ 'github_username' : ?0 }")
	Dev findUsersBygithub_username(String github_username);

	// https://docs.mongodb.com/manual/reference/operator/query/in/#op._S_in
	@Query("{ 'techs' : { $in : ?0 } }")
	List<Dev> findByTechs(String[] techs);
}
