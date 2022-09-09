package com.aglcropsystem.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aglcropsystem.models.Dealer;
import com.aglcropsystem.repository.DealerRepository;

import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	

	@Autowired
	private DealerRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Dealer user=repository.findByUsername(username);
	       
	      return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}
