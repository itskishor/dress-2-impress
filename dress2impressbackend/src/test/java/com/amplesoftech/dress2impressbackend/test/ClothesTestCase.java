package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

public class ClothesTestCase {
private static AnnotationConfigApplicationContext context;
	
	
	private static ClothesDAO clothesDAO;
	
	
	private Clothes clothes;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		clothesDAO = (ClothesDAO)context.getBean("clothesDAO");
	}
	
	@Test
	public void testCRUDClothes() {
		
		// create operation
		clothes = new Clothes();
				
		clothes.setName("Men Printed Formal Blue Shirt");
		clothes.setBrand("Peter England");
		clothes.setSize("XL");
		clothes.setDescription("Cotton Slim Fit, Full Sleeve");
		clothes.setUnitPrice(2000);
		clothes.setPricePerDay(200);
		clothes.setActive(true);
		clothes.setCategoryId(1);
		clothes.setSupplierId(1);
		assertEquals("Something went wrong while inserting a new Clothes!",
				true,clothesDAO.add(clothes));		
		
		
		// reading and updating the category
		clothes = clothesDAO.get(2);
		clothes.setName("Anarkali Kurta");
		assertEquals("Something went wrong while updating the existing record!",
				true,clothesDAO.update(clothes));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,clothesDAO.delete(clothes));		
		
		// list
		assertEquals("Something went wrong while fetching the list of Clothes!",
				5,clothesDAO.list().size());		
				
	}
			
	
	@Test
	public void testListActiveClothes() {
		assertEquals("Something went wrong while fetching the list of clothes!",
				3,clothesDAO.listActiveClothes().size());				
	} 
	
	
	@Test
	public void testListActiveClothesByCategory() {
		assertEquals("Something went wrong while fetching the list of clothes!",
				1,clothesDAO.listActiveClothesByCategory(2).size());
		assertEquals("Something went wrong while fetching the list of clothes!",
				1,clothesDAO.listActiveClothesByCategory(3).size());
	} 
	
	@Test
	public void testGetLatestActiveClothes() {
		assertEquals("Something went wrong while fetching the list of clothes!",
				3,clothesDAO.getLatestActiveClothes(3).size()); 
		
	} 
	

}
