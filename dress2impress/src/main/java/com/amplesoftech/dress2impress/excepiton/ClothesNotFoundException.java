package com.amplesoftech.dress2impress.excepiton;

import java.io.Serializable;

public class ClothesNotFoundException extends Exception implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ClothesNotFoundException() {
		this("Dress is not available!");
	}
	
	public ClothesNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}

}
