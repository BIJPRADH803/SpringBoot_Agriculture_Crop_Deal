package com.aglcropsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aglcropsystem.models.Dealer;


@Repository
public interface DealerRepository extends MongoRepository<Dealer, String> {

	public Dealer findByUsernameAndPassword(String username, String password);
	
	Dealer findByUsername(String username);

}
