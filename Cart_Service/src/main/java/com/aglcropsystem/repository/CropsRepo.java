package com.aglcropsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aglcropsystem.model.Crops;

@Repository
public interface CropsRepo extends MongoRepository<Crops , String> {
	
	
}