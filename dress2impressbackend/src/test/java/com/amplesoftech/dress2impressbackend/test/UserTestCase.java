package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Cart;
//import com.amplesoftech.dress2impressbackend.dto.Address;
// com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

	/*@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		// add the user
	  assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		// linked the address with the user
	   address.setUserId(user.getId());
	   
	   // add the address
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

		if(user.getRole().equals("USER"))
		{
			//create a cart for user
			cart = new Cart();
			// linked the cart with the user
			cart.setUser(user);
			// add the user
			assertEquals("Failed to add the user!", true, userDAO.addCart(cart));
			
			// add the shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			//link it with user
			address.setUserId(user.getId());
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
			
			
		} 		
		
	}
	
	*/
	/*
	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		if(user.getRole().equals("USER"))
		{
		
			//create a cart for user
			cart = new Cart();
			cart.setUser(user);
			// linked the cart with the user
			user.setCart(cart);
			
		}
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
					
		
	}
	*/
	

	// working for uni-directional

	/*@Test
	public void testAddAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("301/B Sande Society, Abhinav Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Banglore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("413310");
		address.setShipping(true);
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}*/
	
	/*@Test
	public void testUpdateCart() {
		user = userDAO.get(1);
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} */


	
	
	/*@Test
	public void testUpdateCart() {
		//fetch the user by its email
		user = userDAO.getByEmail("hr@gmail.com");
		//get the cart of the user
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	}*/ 
/*
	@Test
	public void testAddAddress() {
		
		//we need to add an user
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		// add the user
	  assertEquals("Failed to add the user!", true, userDAO.addUser(user));
	  
	//we need to add billing address

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		 // add the address
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		//we need to add shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		
		//attach the user to the address
				address.setUser(user);
				 // add the address
				assertEquals("Failed to add the shiping address!", true, userDAO.addAddress(address));
		
	  
	}
	 */
	@Test
	public void testGetAddress() {
		//fetch the user by its email
     user = userDAO.getByEmail("hr@gmail.com");
     
     assertEquals("Failed to fetch the list of address and size does not match!",2,
    		 userDAO.listShippingAddresses(user).size());
     
     assertEquals("Failed to fetch the billing address and size does not match!","Mumbai",
    		 userDAO.getBillingAddress(user).getCity());
		
	}
	
}