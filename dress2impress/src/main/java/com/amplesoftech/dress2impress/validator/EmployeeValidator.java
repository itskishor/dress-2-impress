package com.amplesoftech.dress2impress.validator;

import java.sql.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.amplesoftech.dress2impressbackend.dto.Employee;

public class EmployeeValidator implements Validator{


	@Override
	public boolean supports(Class<?> clazz) {
		
		return Employee.class.equals(clazz);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object target, Errors errors) {

		Employee employee = (Employee) target;
		if(employee.getFirstName().isEmpty())
		{
			errors.rejectValue("firstName",null,"Please Enter The Fisrt Name!");
			return;
		}
		if(employee.getLastName().isEmpty())
		{
			errors.rejectValue("lastName",null,"Please Enter The Last Name!");
			return;
		}
		if(employee.getEmail().isEmpty())
		{
			errors.rejectValue("email",null,"Please Enter The Email");
			return;
		}
		;
		if(employee.getDoj().equals(new Date(0, 0, 0)))
		{
		
			errors.reject("dob",null,"Please Select The Date Of Birth");
			return;
		}
		if(employee.getEmpaddr().isEmpty())
		{
			errors.rejectValue("empaddr",null,"Please Enter The Address");
			return;
		}
		
		
		/*if(employee.getDoj())
		{
			errors.rejectValue("doj",null,"Please Select The Date Of Joining");
			return;
		}*/
		
		if(employee.getSalary()==0)
		{
			errors.rejectValue("salary",null,"Please Enter The Salary Amount!");
			return;
		}
		if(employee.getContactNumber().isEmpty())
		{
			errors.rejectValue("contactNumber",null,"Please Enter The Mobile Number!");
			return;
		}
		if(employee.getPassword().isEmpty())
		{
			errors.rejectValue("password",null,"Please Enter The PassWord!");
			return;
		}
		if(employee.getConfirmPassword().isEmpty())
		{
			errors.rejectValue("confirmPassword",null,"Please Confirm The PassWord!");
			return;
		}
		
		if(employee.getDepartment()==0)
		{
			errors.rejectValue("department",null,"Select The Department!");
			return;
		}
		
		if(!employee.getPassword().equals(employee.getConfirmPassword()))
		{
			errors.rejectValue("password",null,"Entered Password And Confirmed Password Doesn't Match!");
			return;
		}
			
	}

}
