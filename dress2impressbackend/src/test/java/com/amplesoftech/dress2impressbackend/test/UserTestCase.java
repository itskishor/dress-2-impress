package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amplesoftech.dress2impressbackend.dao.UserDAO;
//import com.amplesoftech.dress2impressbackend.dto.Address;
//import com.amplesoftech.dress2impressbackend.dto.Cart;
//import com.amplesoftech.dress2impressbackend.dto.Employee;
//import com.amplesoftech.dress2impressbackend.dto.Address;
// com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	//private Cart cart = null;
	//private Address address = null;
	//private Employee employee = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Rohit");
		user.setLastName("Sharma");
		user.setEmail("rs@gmail.com");
		user.setContactNumber("1234512348");
		user.setRole("EMPLOYEE");
		user.setPassword("123");
		
		// add the user
	  assertEquals("Failed to add the user!", true, userDAO.addUser(user));
	/*  if(user.getRole().equals("EMPLOYEE"))
		{
		//create a employee Details table for user
		  employee=new Employee();
		  employee.setEmpaddr("Pune");
		  employee.setDepartment(4);
		  employee.setDob(java.sql.Date.valueOf("1988-11-20"));
		  employee.setDoj(java.sql.Date.valueOf("1990-12-22"));
		  employee.setSalary(3000);
		  employee.setUserId(user.getId());
		  // add the address
			assertEquals("Failed to add the employee!", true, userDAO.addEmployee(employee));
		  
		}
		
		address = new Address();
		address.setAddressLineOne("102/B Jadoo Society, Krissh Nagar");
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
			
			
		} 		*/
		
	}
	

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
	
	/*@Test
	public void testUpdateEmployee() {
		//fetch the user by its id
		user = userDAO.get(15);
		//get the emp of the user
		if(user.getRole().equals("EMPLOYEE"))
		{
		user.setFirstName("Mukesh");;
		assertEquals("Failed to update the Employee User!", true, userDAO.update(user));	
		}
	} */
	
	/*@Test
	public void testDeleteEmployee() {
		//fetch the user by its id
		user = userDAO.get(15);
		//get the emp of the user
		if(user.getRole().equals("EMPLOYEE"))
		{
		user.setEnabled(false);
		assertEquals("Failed to update the Employee User!", true, userDAO.update(user));	
		}
	} */

	/*@Test
	public void testGetAddress() {
		//fetch the user by its email
     user = userDAO.getByEmail("hr@gmail.com");
     
     assertEquals("Failed to fetch the list of address and size does not match!",2,
    		 userDAO.listShippingAddresses(user).size());
     
     assertEquals("Failed to fetch the billing address and size does not match!","Mumbai",
    		 userDAO.getBillingAddress(user).getCity());
		
	}*/
	
	/*@Test
	public void testGetEmployee() {
		//fetch the user by its email
     user = userDAO.getByEmail("ar@gmail.com");
     
     assertEquals("Failed to fetch the list of address and size does not match!",2,
    		 userDAO.(user).size());
     
     assertEquals("Failed to fetch the employee details and size does not match!","Pune",
    		 userDAO.getEmployeeDetails(1).getEmpaddr());
		
	}*/
	
}