package com.amplesoftech.dress2impress.model;

import java.io.Serializable;
import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.CartLine;
import com.amplesoftech.dress2impressbackend.dto.CreditCardDetails;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;
import com.amplesoftech.dress2impressbackend.dto.User;

public class CheckoutModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private Address shipping;
	private CreditCardDetails credit;
	public CreditCardDetails getCredit() {
		return credit;
	}
	public void setCredit(CreditCardDetails credit) {
		this.credit = credit;
	}
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;
	private double checkoutTotalRent;
	public double getCheckoutTotalRent() {
		return checkoutTotalRent;
	}
	public void setCheckoutTotalRent(double checkoutTotalRent) {
		this.checkoutTotalRent = checkoutTotalRent;
	}
	private double checkoutTotalDeposit;
	public double getCheckoutTotalDeposit() {
		return checkoutTotalDeposit;
	}
	public void setCheckoutTotalDeposit(double checkoutTotalDeposit) {
		this.checkoutTotalDeposit = checkoutTotalDeposit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getShipping() {
		return shipping;
	}
	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<CartLine> getCartLines() {
		return cartLines;
	}
	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public double getCheckoutTotal() {
		return checkoutTotal;
	}
	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}
	
}
