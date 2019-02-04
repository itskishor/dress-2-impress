package com.amplesoftech.dress2impressbackend.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "order_total")
	private double orderTotal;
	@ManyToOne
	@JsonIgnore
	private Address shipping;
	@ManyToOne
	@JsonIgnore
	private Address billing;
	@OneToMany(mappedBy="orderDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@Column(name = "order_count")
	private int orderCount;
	
	@Column (name = "no_of_days")
	private int noOfDays;
	
	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	@Column(name="issue_date")
	private String issueDate;
	
	@Column(name="return_date")
	private String returnDate;
	
	@Column(name="booking_date")
	private String bookingDate;
	
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Column(name = "deposite")
	private double deposite;
	
	@Column(name = "total_rent")
	private double totalRent;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	/*@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", user=" + user + ", orderTotal=" + orderTotal + ", shipping=" + shipping
				+ ", billing=" + billing + ", orderItems=" + orderItems + ", orderCount=" + orderCount + ", issueDate="
				+ issueDate.toString() + ",noOfDays="+ noOfDays +", returnDate=" + returnDate.toString() + ",bookingDate="+ bookingDate +", deposite=" + deposite + ", totalRent=" + totalRent
				+ "]";
	}
	*/

}
