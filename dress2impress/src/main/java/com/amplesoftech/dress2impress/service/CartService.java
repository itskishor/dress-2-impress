package com.amplesoftech.dress2impress.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amplesoftech.dress2impress.model.UserModel;
import com.amplesoftech.dress2impressbackend.dao.CartLineDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Cart;
import com.amplesoftech.dress2impressbackend.dto.CartLine;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

@Service("cartService")
public class CartService 
{
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ClothesDAO clothesDAO;
	
	@Autowired
	private HttpSession session;
	//returns the entire cart of the user who logged in
	private Cart getCart() 
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
		
	
	//returns the entire cart line
	public List<CartLine> getCartLines() {
        Cart cart=this.getCart();
		return cartLineDAO.list(cart.getId());

	}
	
	/* to update the cart count */
	public String manageCartLine(int cartLineId, int count,int countdays,Date issuedate) {
		
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine==null)
		{
			return "result=error";
		}
		else {
			Clothes clothes = cartLine.getClothes();
			double oldTotal = cartLine.getTotalPrice();
			//checking if the clothes quantity is available
			if(clothes.getQuantity() < count) 
			 {
				return "result=unavailable";
			}	
			// update the cart line
			cartLine.setClothesCount(count);
			cartLine.setNoOfDays(countdays);
			cartLine.setIssueDate(issuedate);
            java.sql.Date returnDate = addDays(cartLine.getIssueDate(),cartLine.getNoOfDays());
			
			cartLine.setReturnDate(returnDate);
			cartLine.setTotalPrice(cartLine.getClothes().getPricePerDay() * count*countdays +cartLine.getDeposite());
			cartLineDAO.update(cartLine);
			
			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotalPrice() - oldTotal));
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
			
		}
		
	}

	public String deleteCartLine(int cartLineId) {
		CartLine cartLine = cartLineDAO.get(cartLineId);
		// deduct the cart
		if(cartLine==null)
		{
			return "result=error";
		}
		else {
		// update the cart
		Cart cart = this.getCart();	
		cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotalPrice());
		cart.setCartLines(cart.getCartLines() - 1);		
		cartLineDAO.updateCart(cart);
		
		// remove the cartLine
		cartLineDAO.remove(cartLine);
				
		return "result=deleted";
		}
	}


	public String addCartLine(int clothesId) {
		String response = null;
		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndClothes(cart.getId(),clothesId);
		if(cartLine==null)
		{
			Date date = new Date(System.currentTimeMillis());
			
			LocalDate localDate = date.toLocalDate();
			
			Date sqldate = Date.valueOf(localDate);
			// add a new cartLine if a new product is getting added
			cartLine = new CartLine();
			Clothes clothes =clothesDAO.get(clothesId);
			// transfer the product details to cartLine
			cartLine.setCartId(cart.getId());
			cartLine.setClothes(clothes);
			cartLine.setClothesCount(1);
			cartLine.setNoOfDays(1);
			cartLine.setIssueDate(sqldate);
			java.sql.Date returnDate = addDays(cartLine.getIssueDate(),cartLine.getNoOfDays());
			
			cartLine.setReturnDate(returnDate);
			cartLine.setPricePerDay(clothes.getPricePerDay());
			cartLine.setDeposite((clothes.getUnitPrice()/2) * cartLine.getClothesCount());
			cartLine.setTotalPrice((clothes.getPricePerDay() * cartLine.getClothesCount()* cartLine.getNoOfDays())+cartLine.getDeposite());
			cartLine.setAvailable(true);
			
			// insert a new cartLine
			cartLineDAO.add(cartLine);
			
			// update the cart
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotalPrice());
			
			cartLineDAO.updateCart(cart);

			response = "result=added";						
		} 
		else {
			// check if the cartLine has been already reached to maximum count
			if(cartLine.getClothesCount() < 3) 
			{
				// call the manageCartLine method to increase the count
				response = this.manageCartLine(cartLine.getId(), cartLine.getClothesCount() + 1,cartLine.getNoOfDays(), cartLine.getIssueDate());				
			}
						
			else 
			{				
				response = "result=maximum";				
			}						
		}		
		return response;
	}
	
	public Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }
}