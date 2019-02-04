package com.amplesoftech.dress2impressbackend.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Clothes clothes;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderDetail orderDetail;
	
	@Column (name = "no_of_days")
	private int noOfDays;
	
	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Column (name = "price_per_day")
	private double pricePerDay;
	
	@Column (name = "clothes_count")
	private int clothesCount;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	public double getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}

	@Column(name = "total_rent")
	private double totalRent;
	
	@Column(name="issue_date")
	private Date issueDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name = "deposite")
	private double deposite;

	public Date getIssueDate() {
		return issueDate;
	}

	
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getDeposite() {
		return deposite;
	}

	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getClothesCount() {
		return clothesCount;
	}

	public void setClothesCount(int clothesCount) {
		this.clothesCount = clothesCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", clothes=" + clothes + ", orderDetail=" + orderDetail + ", pricePerDay="
				+ pricePerDay + ", clothesCount=" + clothesCount + ", totalPrice=" + totalPrice + ", issueDate="
				+ issueDate + ", returnDate=" + returnDate + ",noOfDays="+noOfDays+",bookingDate="+ bookingDate +", deposite=" + deposite + "]";
	}

	
	
	

}