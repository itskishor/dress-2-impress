package com.amplesoftech.dress2impress.controller; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impress.excepiton.ClothesNotFoundException;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.ContactusDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.Contactus;

@Controller
public class PageController {
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ClothesDAO clothesDAO;
	@Autowired
	private ContactusDAO contactUsDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Home");
	
	//passing the list of categories
	mv.addObject("categories", categoryDAO.listActiveCategory());
	mv.addObject("userClickHome",true);
	return mv;
	}
	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	@RequestMapping(value="/signin")
	public ModelAndView signin()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Sign In");
	mv.addObject("userClickSignin",true);
	return mv;
	}

	
	@RequestMapping(value="/cart")
	public ModelAndView cart()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Cart");
	mv.addObject("userClickCart",true);
	return mv;
	}
	 
	//methods to load all the clothes based on category
	@RequestMapping(value="/show/all/clothes")
	public ModelAndView showAllClothes()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","View Clothes");
	
	//passing the list of categories
	mv.addObject("categories",categoryDAO.listActiveCategory());
	mv.addObject("userClickViewClothes",true);
	return mv;
	}
	
	//methods to load contact us page
		@RequestMapping(value="/show/contactus")
		public ModelAndView showContactUs()
		{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContactUs",true);
		return mv;
		}
		
		@RequestMapping(value="/aboutus")
		public ModelAndView AboutUs()
		{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAboutUs",true);
		return mv;
		}

	@RequestMapping(value="/show/category/{id}/clothes")
	public ModelAndView showCategoryClothes(@PathVariable("id") int id)
	{
	ModelAndView mv=new ModelAndView("page");
	//categoryDAO to fetch a single category
	Category category=null;
	category=categoryDAO.get(id);
	mv.addObject("title",category.getName());
	//passing the list of categories
	mv.addObject("categories",categoryDAO.listActiveCategory());
	//passing the single category
	mv.addObject("category",category);
	mv.addObject("userClickCategoryClothes",true);
	return mv;
	}
	
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/clothes") 
	public ModelAndView showSingleClothes(@PathVariable int id) throws ClothesNotFoundException
	{
		
		ModelAndView mv = new ModelAndView("page");
			// update the view count
		Clothes clothes = clothesDAO.get(id);
		if(clothes == null) throw new ClothesNotFoundException();
		clothes.setViews(clothes.getViews() + 1);
		clothesDAO.update(clothes);
		//---------------------------
		
		mv.addObject("title", clothes.getName());
		mv.addObject("clothes", clothes);
		
		mv.addObject("userClickShowClothes", true);
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Employee");
	return mv;
	}
	
	@RequestMapping(value= "/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
	
// Contact Us Controller
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView manageAddQuery(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContactUs", true);

		Contactus contactus = new Contactus();

		mv.addObject("contactus", contactus);

		if (operation != null) {
			if (operation.equals("contactus")) {
				mv.addObject("message", "Query Sent Successfully!");
			} 
			else if(operation.equals("contactus")) {
				mv.addObject("message", "Query Sent Successfully!");
			} 
		}
		return mv;

	}
	// handling clothes submission
		@RequestMapping(value = "/contactus", method = RequestMethod.POST)
		public String handleAddQuerySubmission(@Valid @ModelAttribute("contactus") Contactus mcontactus, BindingResult results,
				Model model, HttpServletRequest request) {
			// handle image validation for new clothes
			/*if (mcontactus.getId() == 0) {
				new ClothesValidator().validate(mclothes, results);
			} else {
				if (!mclothes.getFile().getOriginalFilename().equals("")) {
					// FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
					new ClothesValidator().validate(mclothes, results);
				}
			}*/
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickContactUs", true);
				model.addAttribute("title", "Contact Us");
				model.addAttribute("message", "Validation Failed For Product Submission!");
				return "page";
			}
			// Create a new contact Us Record
				contactUsDAO.add(mcontactus);
			
			return "redirect:/contactus?operation=contactus";

		}

}
