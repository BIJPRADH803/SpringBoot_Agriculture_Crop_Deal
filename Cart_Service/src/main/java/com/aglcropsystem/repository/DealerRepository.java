package com.aglcropsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aglcropsystem.model.Dealer;



@Repository
public interface DealerRepository extends MongoRepository<Dealer, String> {

	

}
