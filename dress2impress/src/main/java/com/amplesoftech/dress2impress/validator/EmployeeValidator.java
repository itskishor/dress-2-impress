package com.amplesoftech.dress2impress.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.User;

public class EmployeeValidator implements Validator{

	@Autowired
	private UserDAO userDAO;
	
		@Override
		public boolean supports(Class<?> clazz) {
			
			return User.class.equals(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
			User user = (User) target;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date date1 = null;
			try 
			{
				date1 = sdf.parse(user.getDob());
			} 
			catch (ParseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Date date2=new Date();
			if(date1.after(date2))
			{
				errors.rejectValue("dob",null,"Please Enter The Valid Date!");
				return;
			}
			
			/*if (userDAO.getByEmail("ac@gmail.com")!=null){
				System.out.println("ok");
			}*/
			
		}

}
