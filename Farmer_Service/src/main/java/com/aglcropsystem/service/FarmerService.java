package com.aglcropsystem.service;

import java.util.List;

import com.aglcropsystem.model.Farmer;

public interface FarmerService {

	

	 public Farmer addFarmer(Farmer farmer);

	 public Farmer farmerLogin(String username, String password);

	 public List<Farmer> getAllFarmers();

	 public Farmer getFarmerById(String farmerId);

	 public Farmer updateFarmer(Farmer farmer);

//	 public void  deleteFarmer(String farmerId);
	
	public  String  deleteFarmer(String farmerId);

}
