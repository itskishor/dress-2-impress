package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Employee;

public interface EmployeeDAO {
	
		Employee get(int employeeId);
		List<Employee> list();	
		boolean add(Employee employee);
		boolean update(Employee employee);
		boolean delete(Employee employee);

		
		
		// business methods
		List<Employee> listActiveEmployee();	
		List<Employee> listActiveEmployeeByCategory(int department);

	}
