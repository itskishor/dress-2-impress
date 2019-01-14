package com.amplesoftech.dress2impress.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amplesoftech.dress2impressbackend.dto.Clothes;

public class ClothesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Clothes.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Clothes clothes = (Clothes) target;
		if(clothes.getName().isEmpty())
		{
			errors.rejectValue("name",null,"Please Enter The Name");
			return;
		}
		if(clothes.getBrand().isEmpty())
		{
			errors.rejectValue("brand",null,"Please Enter The Brand");
			return;
		}
		if(clothes.getSize().isEmpty())
		{
			errors.rejectValue("size",null,"Please Enter The Size");
			return;
		}
		
		if(clothes.getDescription().isEmpty())
		{
			errors.rejectValue("description",null,"Please Enter The Description!");
			return;
		}
		if(clothes.getUnitPrice()<0)
		{
			errors.rejectValue("unitPrice",null,"Unit Price Should Not Be Less Than Zero!");
			return;
		}
		if(clothes.getPricePerDay()<0)
		{
			errors.rejectValue("pricePerDay",null,"Price/Day Should Not Be Less Than Zero!");
			return;
		}
		
		if (clothes.getFile() == null || clothes.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if (!(clothes.getFile().getContentType().equals("image/jpeg")
				|| clothes.getFile().getContentType().equals("image/png"))
				|| clothes.getFile().getContentType().equals("image/gif")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}

	} 

}
