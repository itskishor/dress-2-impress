package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	  @Test public void testAddCategory() {
	  
	  category = new Category();
	  
	  category.setName("Men");
	  category.setDescription("This is some description for Men!");
	 // category.setImageURL("CAT_101.png");
	  
	  assertEquals("Successfully added a category inside the table!",true,
	  categoryDAO.add(category));
	  
	  
	  }
	 

	/* @Test
	public void testGetCategory() {

		category = categoryDAO.get(4);

		assertEquals("Successfully fetched a single category from the table!", "Men", category.getName());

	} */

	/* @Test
	public void testUpdateCategory() {

		category = categoryDAO.get(4);

		category.setName("Women");

		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));

	} */

	
	 /* @Test public void testDeleteCategory() {
	  
	 category = categoryDAO.get(4);
	 assertEquals("Successfully deleted a single category in the table!",true,
	 categoryDAO.delete(category)); 
	  }*/
	 
	
	  @Test public void testListCategory() {
	  
	  assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
	  
	  
	  }
	  
	 
	/*
	  @Test public void testCRUDCategory() {
	  
	  // add operation 
      category = new Category();
	  
	  category.setName("Men");
	  category.setDescription("This is some description for Men!");
	  //category.setImageURL("CAT_1.png");
	  
	  assertEquals("Successfully added a category inside the table!",true,
	  categoryDAO.add(category));
	  
	  
	  category = new Category();
	  
	  category.setName("Womens");
	  category.setDescription("This is some description for Women!");
	 // category.setImageURL("CAT_2.png");
	  
	  assertEquals("Successfully added a category inside the table!",true,
	  categoryDAO.add(category));
	  
	  
	  // fetching and updating the category
	  category = categoryDAO.get(2);
	  
	  category.setName("Women");
	  
	  assertEquals("Successfully updated a single category in the table!",true,
	  categoryDAO.update(category));
	  
	  
	  // delete the category
	  assertEquals("Successfully deleted a single category in the table!",true,
	  categoryDAO.delete(category));
	  
	  
	  //fetching the list
	  assertEquals("Successfully fetched the list of categories from the table!",1,
	  categoryDAO.list().size());
	  
	  
	  }*/
	 

}
