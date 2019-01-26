package com.amplesoftech.dress2impress.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.amplesoftech.dress2impressbackend.dto.DebitCardDetails;

public class CardValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return DebitCardDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		DebitCardDetails debitCardDetails = (DebitCardDetails) target;
		if(debitCardDetails.getName().isEmpty())
		{
			errors.rejectValue("name",null,"Please Enter The Card Holder Name");
			return;
		}
		if(debitCardDetails.getCardNumber().isEmpty())
		{
			errors.rejectValue("cardNumber",null,"Please Enter The card Number");
			return;
		}
		if(debitCardDetails.getExpiryMonth()>12 || debitCardDetails.getExpiryMonth()<0)
		{
			errors.rejectValue("expiryMonth",null,"Please Enter The Valid Expiry Month");
			return;
		}
		
		if(debitCardDetails.getCvvNumber().isEmpty())
		{
			errors.rejectValue("description",null,"Please Enter The Valid CVV Number!");
			return;
		}		

	} 

}
