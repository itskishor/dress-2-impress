package com.amplesoftech.dress2impress.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impress.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		if (result != null) {
			switch (result) {
			case "updated":
				mv.addObject("message", "Cart has been updated successfully!");
				break;
			case "added":
				mv.addObject("message", "Cart has been added successfully!");
				break;
			case "unavailable":
				mv.addObject("message", "Clothes quantity is not available!");					
				break;
			case "modified":
				mv.addObject("message", "Items inside cart has been modified!");
				break;
			case "deleted":
				mv.addObject("message", "Cart has been Removed successfully!");
				break;
			case "maximum":
				mv.addObject("message", "Maximum limit for the item has been reached!");
				break;
			case "error":
				mv.addObject("message", "Something Went Wrong!");
				break;
			}
		}
		
		else {
			String response = cartService.validateCartLine();
			if(response.equals("result=modified")) {
				mv.addObject("message", "Items inside cart has been modified!");
			}
		}
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;

	}

	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable int cartLineId, @RequestParam int count, @RequestParam int countdays, @RequestParam Date issuedate ) {
		String response = cartService.manageCartLine(cartLineId, count,countdays,issuedate);
		return "redirect:/cart/show?" + response;
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String removeCartLine(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/add/{clothesId}/clothes")
	public String addCartLine(@PathVariable int clothesId) {
		String response = cartService.addCartLine(clothesId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/validate")
	public String validateCart() {	
		String response = cartService.validateCartLine();
		if(!response.equals("result=success")) {
			return "redirect:/cart/show?"+response;
		}
		else 
		{
			return "redirect:/cart/checkout";
		}
	}
}
