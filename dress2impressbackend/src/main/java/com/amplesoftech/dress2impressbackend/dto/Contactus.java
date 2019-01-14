package com.amplesoftech.dress2impressbackend.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Contactus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//private fields
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
	@NotBlank(message = "Please enter name!")
		private String name;
	@NotBlank(message = "Please enter email number!")
		private String email;
	@NotBlank(message = "Please enter contact Number!")
	private String contactNumber;
	@NotBlank(message = "Please enter your Query!")
	private String query;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "Contactus [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", query=" + query + "]";
	}
	

}
