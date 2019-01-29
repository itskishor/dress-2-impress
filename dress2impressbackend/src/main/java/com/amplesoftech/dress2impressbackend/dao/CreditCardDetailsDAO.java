package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.CreditCardDetails;

public interface CreditCardDetailsDAO 
{
	List<CreditCardDetails> list();
	CreditCardDetails get(int id);
	boolean add(CreditCardDetails creditCardDetails);
	boolean delete(CreditCardDetails creditCardDetails);

}
