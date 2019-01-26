package com.amplesoftech.dress2impress.excepiton;

import java.io.Serializable;

public class SupplierClothesNotFoundException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public SupplierClothesNotFoundException()
	{
		this("Dress is not available!");
	}
	
	public SupplierClothesNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}


}
