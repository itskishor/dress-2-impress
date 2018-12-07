package com.amplesoftech.dress2impress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{

	@Autowired
	private ClothesDAO clothesDAO;
	

	@RequestMapping("/admin/all/clothes")
	@ResponseBody
	public List<Clothes> getAllClothesList() {		
		return clothesDAO.list();
				
	}	
	
	
	@RequestMapping("/all/clothes")
	@ResponseBody
	public List<Clothes> getAllProducts() {
		
		return clothesDAO.listActiveClothes();
				
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

}
