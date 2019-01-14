package com.amplesoftech.dress2impressbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amplesoftech.dress2impressbackend.dao.CartLineDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.CartLine;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.User;

public class CartLineTestCase {
	


	private static AnnotationConfigApplicationContext context;
	
	
	
	private static CartLineDAO cartLineDAO;
	private static ClothesDAO clothesDAO;
	private static UserDAO userDAO;
	
	
	//private  Cart cart=null;
	//private  Clothes clothes=null;
	//private  User user=null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amplesoftech.dress2impressbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		clothesDAO = (ClothesDAO)context.getBean("clothesDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("km2@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the clothes 
		Clothes clothes = clothesDAO.get(12);
		 
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setPricePerDay(clothes.getPricePerDay());
		cartLine.setClothesCount(cartLine.getClothesCount() + 1);
		cartLine.setIssueDate(java.sql.Date.valueOf("2018-12-20"));
		cartLine.setNoOfDays(2);
		cartLine.setReturnDate(java.sql.Date.valueOf("2018-12-23"));
		cartLine.setAvailable(true);
		cartLine.setDeposite((clothes.getUnitPrice()/2)* cartLine.getClothesCount());
		cartLine.setTotalPrice((clothes.getPricePerDay() * cartLine.getClothesCount()* cartLine.getNoOfDays())+cartLine.getDeposite());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setClothes(clothes);
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotalPrice());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Failed to update the cart!",true, cartLineDAO.updateCart(cart));
		//double oldTotal = cartLine.getTotalPrice();		
	}
	
	
	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("km@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndClothes(cart.getId(), 2);
		
		cartLine.setClothesCount(cartLine.getClothesCount()+2);
		cartLine.setNoOfDays(3);
		
		double oldTotal = cartLine.getTotalPrice();		
		
		cartLine.setTotalPrice(cartLine.getClothes().getPricePerDay()*cartLine.getClothesCount()*cartLine.getNoOfDays()+cartLine.getDeposite());
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotalPrice() - oldTotal);
		assertEquals("Failed to update the cart!",true, cartLineDAO.updateCart(cart));	
	}

}
