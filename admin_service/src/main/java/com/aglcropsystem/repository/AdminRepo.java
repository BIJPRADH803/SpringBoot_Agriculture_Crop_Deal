package com.aglcropsystem.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.aglcropsystem.models.Admin;


@Repository

public interface AdminRepo extends MongoRepository<Admin, Integer> {

//public Admin findByUsernameAndPassword(String name, String password);
	

}