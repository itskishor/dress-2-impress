package com.amplesoftech.dress2impress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.EmployeeDAO;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.Employee;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{

	@Autowired
	private ClothesDAO clothesDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/all/clothes")
	@ResponseBody
	public List<Clothes> getAllProducts() {
		
		return clothesDAO.listActiveClothes();
				
	}
	
	@RequestMapping("/admin/all/clothes")
	@ResponseBody
	public List<Clothes> getAllClothesListForAdmin() {		
		return clothesDAO.list();
				
	}
	
	@RequestMapping("/category/{id}/clothes")
	@ResponseBody
	public List<Clothes> getProductsByCategory(@PathVariable int id) {
		
		return clothesDAO.listActiveClothesByCategory(id);
				
	}
	
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Clothes> getMostViewedClothes() {		
		return clothesDAO.getClothesByParam("views", 5);				
	}
		
	@RequestMapping("/mp/clothes")
	@ResponseBody
	public List<Clothes> getMostRentedClothes() {		
		return clothesDAO.getClothesByParam("rented", 5);				
	}
	
	@RequestMapping("/admin/all/employee")
	@ResponseBody
	public List<Employee> getAllEmployeeListForAdmin() {		
		return employeeDAO.list();
				
	}

}
