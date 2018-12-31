package com.amplesoftech.dress2impressbackend.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.amplesoftech.dress2impressbackend.dao.EmployeeDAO;
import com.amplesoftech.dress2impressbackend.dto.Employee;

public class EmployeeTestCase {
private static AnnotationConfigApplicationContext context;
private static EmployeeDAO employeeDAO;
private Employee emp;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		employeeDAO = (EmployeeDAO)context.getBean("employeeDAO");
	}
	
	@Test
	public void testCRUDClothes() {
		
		/*// create operation
		emp = new Employee();		
		emp.setFirstName("Ajinkya");
		emp.setLastName("Rahane");;
		emp.setEmail("ar@gmail.com");
	    emp.setDob(java.sql.Date.valueOf("1988-11-20"));
	    emp.setEmpaddr("Mumbai");
	    emp.setSalary(20000);
	    emp.setDoj(java.sql.Date.valueOf("2018-12-26"));
	    emp.setContactNumber("9096212225");
	    emp.setPassword("123");
	    emp.setDepartment(5);;;
		emp.setEnabled(true);
		assertEquals("Something went wrong while inserting a new Employee!",
				true,employeeDAO.add(emp));		
		*/
		
		// reading and updating the category
		/*emp = employeeDAO.get(55);
		emp.setFirstName("Virat");
		assertEquals("Something went wrong while updating the existing record!",
				true,employeeDAO.update(emp));		
		
		assertEquals("Something went wrong while deleting the existing record!",
				true,employeeDAO.delete(emp));		
		*/
		// list
		/*assertEquals("Something went wrong while fetching the list of Clothes!",
				2,employeeDAO.list().size());		
				*/
		
		/*assertEquals("Something went wrong while fetching the list of Clothes!",
				1,employeeDAO.listActiveEmployee().size());*/
		
		assertEquals("Something went wrong while fetching the list of Clothes!",
				1,employeeDAO.listActiveEmployeeByCategory(4).size());
	}
	
	

}
