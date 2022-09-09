package com.aglcropsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglcropsystem.exceptions.AuthenticationFailureException;
import com.aglcropsystem.exceptions.DealerNotFoundException;

import com.aglcropsystem.models.Dealer;
import com.aglcropsystem.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	public DealerRepository dealerRepo;

	@Override
	public Dealer addDealer(Dealer dealer) {
		return dealerRepo.save(dealer);
	}

	@Override
	public Dealer dealerLogin(String username, String password) {
		Dealer dealer = dealerRepo.findByUsernameAndPassword(username, password);

		if (dealer == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		return dealer;
	}

	@Override
	public List<Dealer> getAllDealers() {
		return dealerRepo.findAll();
	}

	@Override
	public Dealer getDealerById(String dealerId) {
		Optional<Dealer> optionalDealer = dealerRepo.findById(dealerId);

		if (optionalDealer == null) {
			throw new DealerNotFoundException("Customer not exising with id: " + dealerId);
		}

		Dealer dealer = optionalDealer.get();

		return dealer;
	}


	@Override
	public Dealer updateDealer(Dealer dealer) {
		Optional<Dealer> optionalDealer = dealerRepo.findById(dealer.getDealerId());

		if (optionalDealer == null) {
			throw new DealerNotFoundException("Dealer not exising with id: " + dealer.getDealerId());
		}

		Dealer updatedDealer = dealerRepo.save(dealer);

		return updatedDealer;
	}
	
	
	@Override
	public String  deleteDealer(String dealerId) {
		 if(dealerRepo.existsById(dealerId)) {
			 dealerRepo.deleteById(dealerId);
			return " Dealer deleted successfully with Id"+dealerId;
		 }
		 
		 throw new DealerNotFoundException("Dealer   not exising with id: " + dealerId);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	

//	@Override
//	public void deleteDealer(String dealerId) {
//		Optional<Dealer> optionalDealer = dealerRepo.findById(dealerId);
//
//		if (optionalDealer == null) {
//			throw new DealerNotFoundException("Dealer not exising with id: " + dealerId);
//		}
//
//		Dealer dealer = optionalDealer.get();
//
//		dealerRepo.delete(dealer);
//
//	}
	
	
		 

 }
	
	
	
}