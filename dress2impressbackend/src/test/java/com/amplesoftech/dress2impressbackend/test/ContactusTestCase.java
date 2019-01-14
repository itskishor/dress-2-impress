package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.amplesoftech.dress2impressbackend.dao.ContactusDAO;
import com.amplesoftech.dress2impressbackend.dto.Contactus;

public class ContactusTestCase 
{
	private static AnnotationConfigApplicationContext context;

	private static ContactusDAO contactusDAO;

	private  Contactus contactus;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		contactusDAO  =(ContactusDAO) context.getBean("contactusDAO");
	}

	/*
	  @Test 
	  public void testAddCategory() {
	  
		  contactus  = new Contactus();
	  
		  contactus.setName("Abhinav");
		  contactus.setQuery("How Deposit is calculated?");
		  contactus.setEmail("at@gmail.com");
		  contactus.setContactNumber("9090998777");
	  
	  assertEquals("Successfully added a query inside the table!",true,contactusDAO.add(contactus));
	  
	  
	  }*/
	  
	  @Test public void testListContactus() {
		  
		  assertEquals("Successfully fetched the list of queries from the table!",1,contactusDAO.list().size());
		  
		  
		  }
	 

}
