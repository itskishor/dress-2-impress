package com.amplesoftech.dress2impress.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amplesoftech.dress2impressbackend.dto.Category;

public class CategoryValidator implements Validator{


	@Override
	public boolean supports(Class<?> clazz) {
		
		return Category.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Category category = (Category) target;
		if(category.getName().isEmpty())
		{
			errors.rejectValue("name",null,"Please Enter The Category Name!");
			return;
		}
		if(category.getDescription().isEmpty())
		{
			errors.rejectValue("description",null,"Please Enter The Description!");
			return;
		}
	}

}
