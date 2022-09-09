package com.aglcropsystem.services;

import java.util.List;

import com.aglcropsystem.models.Dealer;

public interface DealerService {

	public Dealer addDealer(Dealer dealer);

	public Dealer dealerLogin(String username, String password);

	public List<Dealer> getAllDealers();

	public Dealer getDealerById(String dealerId);

	 public Dealer updateDealer(Dealer dealer);

	//public void deleteDealer(String dealerId);
	public String deleteDealer(String dealerId);
}
