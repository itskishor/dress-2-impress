package com.amplesoftech.dress2impress.handler;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amplesoftech.dress2impress.model.CheckoutModel;
import com.amplesoftech.dress2impress.model.UserModel;
import com.amplesoftech.dress2impressbackend.dao.CartLineDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.CartLine;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;
import com.amplesoftech.dress2impressbackend.dto.OrderItem;
import com.amplesoftech.dress2impressbackend.dto.User;

@Component
public class CheckoutHandler  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final Logger logger = LoggerFactory.getLogger(CheckoutHandler.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ClothesDAO clothesDAO;

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	
	public CheckoutModel init(String name) throws Exception{

		User user = userDAO.getByEmail(name);
		CheckoutModel checkoutModel = null;	

		if(user!=null) {
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());
			
			double checkoutTotal = 0.0;
			double checkoutTotalDeposit=0.0;
			List<CartLine> cartLines = cartLineDAO.listAvailable(user.getCart().getId());

			if(cartLines.size() == 0 ) {
				throw new Exception("There are no clothes available for checkout now!");
			}
			
			for(CartLine cartLine: cartLines) {
				checkoutTotal += cartLine.getTotalPrice();
				checkoutTotalDeposit +=cartLine.getDeposite();
			}
			
			checkoutModel.setCartLines(cartLines);
				
			checkoutModel.setCheckoutTotalDeposit(checkoutTotalDeposit);
			checkoutModel.setCheckoutTotal(checkoutTotal);
			checkoutModel.setCheckoutTotalRent(checkoutTotal-checkoutTotalDeposit);
		}			
		
		return checkoutModel;
	}
	
	
	public List<Address> getShippingAddresses(CheckoutModel model) {
				
		List<Address> addresses = userDAO.listShippingAddresses(model.getUser().getId());
		
		if(addresses.size() == 0) {
			addresses = new ArrayList<>();
		}

		addresses.add(addresses.size(), userDAO.getBillingAddress(model.getUser().getId()));			
		
		return addresses;
		
	}
	
	public String saveAddressSelection(CheckoutModel checkoutModel, int shippingId) {

		String transitionValue = "success";
		
		//logger.info(String.valueOf(shippingId));
		
		Address shipping = userDAO.getAddress(shippingId);		
		
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
			
	
	public String saveAddress(CheckoutModel checkoutModel, Address shipping) {

		String transitionValue = "success";
		
		// set the user id
		// set shipping as true
		shipping.setUserId(checkoutModel.getUser().getId());
		shipping.setShipping(true);
		userDAO.addAddress(shipping);
		
		// set the shipping id to flowScope object
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
		

	public String saveOrder(CheckoutModel checkoutModel) {
		String transitionValue = "success";	
		
		// create a new order object
		OrderDetail orderDetail = new OrderDetail();
				
		// attach the user 
		orderDetail.setUser(checkoutModel.getUser());
				
		// attach the shipping address
		orderDetail.setShipping(checkoutModel.getShipping());
		
		// fetch the billing address
		Address billing = userDAO.getBillingAddress(checkoutModel.getUser().getId());		
		orderDetail.setBilling(billing);

		List<CartLine> cartLines = checkoutModel.getCartLines();
		OrderItem orderItem = null;
		
		double orderTotal = 0.0;
		int orderCount = 0;
		Clothes clothes = null;
		
		for(CartLine cartLine : cartLines) {
			
			orderItem = new OrderItem();
			
			orderItem.setPricePerDay(cartLine.getPricePerDay());
			orderItem.setClothes(cartLine.getClothes());
			orderItem.setClothesCount(cartLine.getClothesCount());
			orderItem.setIssueDate(cartLine.getIssueDate());
			orderItem.setReturnDate(cartLine.getReturnDate());
			orderItem.setTotalPrice(cartLine.getTotalPrice());
			orderItem.setTotalRent(cartLine.getPricePerDay()*cartLine.getClothesCount());
			orderItem.setDeposite(cartLine.getDeposite());
			
			orderItem.setOrderDetail(orderDetail);
			orderDetail.getOrderItems().add(orderItem);
			
			orderTotal += orderItem.getTotalPrice();
			orderCount++;
			
			// update the clothes
			// reduce the quantity of clothes
		clothes = cartLine.getClothes();
		clothes.setQuantity(clothes.getQuantity() - cartLine.getClothesCount());
		clothes.setRented(clothes.getRented()+ cartLine.getClothesCount());
		clothesDAO.update(clothes);
			
			// delete the cartLine
			cartLineDAO.remove(cartLine);
			

			
		}
		
		//orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);
		orderDetail.setIssueDate(orderItem.getIssueDate());
		orderDetail.setReturnDate(orderItem.getReturnDate());
		orderDetail.setDeposite(checkoutModel.getCheckoutTotalDeposit());
		orderDetail.setOrderTotal(checkoutModel.getCheckoutTotal());
		orderDetail.setTotalRent(checkoutModel.getCheckoutTotalRent());

		
		// save the order
		cartLineDAO.addOrderDetail(orderDetail);

		// set it to the orderDetails of checkoutModel
		checkoutModel.setOrderDetail(orderDetail);

		
		// update the cart
		Cart cart = checkoutModel.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - orderTotal);
		cart.setCartLines(cart.getCartLines() - orderCount);
		cartLineDAO.updateCart(cart);
		
		// update the cart if its in the session
		UserModel userModel = (UserModel) session.getAttribute("userModel");
		if(userModel!=null) {
			userModel.setCart(cart);
		}
		
				
		return transitionValue;		
	}
	public OrderDetail getOrderDetail(CheckoutModel checkoutModel) {
		return checkoutModel.getOrderDetail();
	}
	

}
