package com.amplesoftech.dress2impressbackend.dao;


import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean update(User user);
	// user related operation
	User getByEmail(String email);
	User get(int id);
	public boolean getByEmail1(String email) ;

	//boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean updateAddress(Address address);
	boolean addAddress(Address address);
	//alternatives
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	List<User> listByRole(String role);
	/*
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);*/
	
	public boolean alreadyExists(String email);
}