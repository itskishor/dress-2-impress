package com.amplesoftech.dress2impressbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Category implements Serializable  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private fields
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
	@NotBlank(message = "Please enter category name!")
		private String name;
	@NotBlank(message = "Please enter the description!")
		private String description;
		@Column(name = "is_active")
		private boolean active = true;
	
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
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active + "]";
	}
	

}
