package com.aglcropsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglcropsystem.exceptions.AuthenticationFailureException;
import com.aglcropsystem.exceptions.FarmerNotFoundException;
import com.aglcropsystem.model.Farmer;
import com.aglcropsystem.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	public FarmerRepository farmerRepo;
	
	@Override
	public Farmer addFarmer(Farmer farmer) {
		
		return farmerRepo.save(farmer);
	}
	

	@Override
	public Farmer farmerLogin(String username, String password) {
	
		Farmer farmer = farmerRepo.findByUsernameAndPassword(username, password);

		if (farmer == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		return farmer;
	}
	

	@Override
	public List<Farmer> getAllFarmers() {
				return farmerRepo.findAll();
	}
	
	
	
	@Override
	public Farmer getFarmerById(String farmerId) {
		Optional<Farmer> optionalFarmer = farmerRepo.findById(farmerId);

		if (optionalFarmer == null) {
			throw new FarmerNotFoundException("Farmer not exising with id: " +farmerId);
		}

		Farmer farmer = optionalFarmer.get();

		return farmer;
	}
	
	
	
	@Override
	public Farmer updateFarmer(Farmer farmer) {
		Optional<Farmer> optionalFarmer = farmerRepo.findById(farmer.getFarmerId());

		if (optionalFarmer == null) {
			throw new FarmerNotFoundException("Farmer not exising with id: " + farmer.getFarmerId());
		}

		Farmer updatedFarmer = farmerRepo.save(farmer);

		return updatedFarmer;
	}
//
//	@Override
//	public void deleteFarmer(String farmerId) {
//		Optional<Farmer> optionalFarmer = farmerRepo.findById(farmerId);
//
//		if (optionalFarmer == null) {
//			throw new FarmerNotFoundException("Farmer not exising with id: " + farmerId);
//		}
//
//		Farmer farmer= optionalFarmer.get();
//
//		farmerRepo.delete(farmer);
//
//	}
	
	@Override
	public String  deleteFarmer(String farmerId) {
		 if(farmerRepo.existsById(farmerId)) {
			farmerRepo.deleteById(farmerId);
			return " Farmer deleted successfully with Id"+farmerId;
		 }
		 
		 throw new FarmerNotFoundException("Farmer not exising with id: " + farmerId);
		 

 }
}
