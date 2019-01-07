package com.amplesoftech.dress2impressbackend.dao;


import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Employee;
import com.amplesoftech.dress2impressbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean update(User user);
	// user related operation
	User getByEmail(String email);
	User get(int id);

	//boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean updateAddress(Address address);
	boolean addAddress(Address address);
	boolean addEmployee(Employee employee);
	//alternatives
	Employee getEmployeeDetails(int userId);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	List<User> listByRole(String role);
	/*
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);*/
	boolean updateEmployee(Employee employee);
	Employee getEmployee(int empId);
}