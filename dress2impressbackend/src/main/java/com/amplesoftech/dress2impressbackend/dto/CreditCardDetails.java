package com.amplesoftech.dress2impressbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditcarddetails")
public class CreditCardDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	//private fields
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
	//@NotBlank(message = "Please Enter Card number!")
		private String name;
	
	//@NotBlank(message = "Please Enter Card number!")
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "expiry_month")
	//@NotBlank(message = "Please Enter Expiry Month!")
	private int expiryMonth;
	@Column(name = "expiry_year")
	//@NotBlank(message = "Please enter your Expiry Year!")
	private int expiryYear;
	//@NotBlank(message = "Please enter your CVV Number!")
	@Column(name = "cvv_number")
	private String cvvNumber;
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	@Override
	public String toString() {
		return "CreditCardDetails [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", expiryMonth="
				+ expiryMonth + ", expiryYear=" + expiryYear + ", cvvNumber=" + cvvNumber + "]";
	}
		

}
