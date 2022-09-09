package com.aglcropsystem.services;

import java.util.List;

import com.aglcropsystem.models.Admin;

public interface AdminService {

	// Admin
	public List<Admin> findAll();

	public void saveAdmin(Admin admin);

	public void updateAdmin(Admin admin);

	public void deleteAdmin(int id);
	
	// public Admin adminLogin(String name, String password);

}