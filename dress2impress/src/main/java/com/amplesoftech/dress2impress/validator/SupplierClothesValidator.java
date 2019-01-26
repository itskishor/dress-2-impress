package com.amplesoftech.dress2impress.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;

public class SupplierClothesValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return SupplierClothes.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SupplierClothes supplierClothes = (SupplierClothes) target;
		if(supplierClothes.getName().isEmpty())
		{
			errors.rejectValue("name",null,"Please Enter The Name");
			return;
		}
		if(supplierClothes.getBrand().isEmpty())
		{
			errors.rejectValue("brand",null,"Please Enter The Brand");
			return;
		}
		if(supplierClothes.getSize().isEmpty())
		{
			errors.rejectValue("size",null,"Please Enter The Size");
			return;
		}
		
		if(supplierClothes.getDescription().isEmpty())
		{
			errors.rejectValue("description",null,"Please Enter The Description!");
			return;
		}
		if(supplierClothes.getUnitPrice()<0)
		{
			errors.rejectValue("unitPrice",null,"Unit Price Should Not Be Less Than Zero!");
			return;
		}
		if (supplierClothes.getFile() == null || supplierClothes.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if (!(supplierClothes.getFile().getContentType().equals("image/jpeg")
				|| supplierClothes.getFile().getContentType().equals("image/png"))
				|| supplierClothes.getFile().getContentType().equals("image/gif")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}

	} 

}
