package com.amplesoftech.dress2impressbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SupplierClothes {

	private static final long serialVersionUID = 1L;
	
	// private fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String code;
	private String name;
	private String brand;
	private String size;
	@JsonIgnore
	private String description;
/*	@NotBlank(message = "Please enter unit price!")
*/	@Column(name = "unit_price")
	private double unitPrice;
/*	@NotBlank(message = "Please enter price per day!")
*/	@Column(name = "price_per_day")
	private double pricePerDay;
	private int quantity;
	@Column(name = "is_active")	
	private boolean active;
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name = "supplier_id")
	@JsonIgnore
	private int supplierId;	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

		// default constructor
		public SupplierClothes() {
			
			this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
			
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	@Override
	public String toString() {
		return "Clothes [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", size=" + size
				+ ", description=" + description + ", unitPrice=" + unitPrice + ", pricePerDay=" + pricePerDay
				+ ", quantity=" + quantity + ", active=" + active + ", categoryId=" + categoryId + ", supplierId="
				+ supplierId + "]";
	}
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}


	public Clothes get(int clothesId) {
		return null;
	}	
}
