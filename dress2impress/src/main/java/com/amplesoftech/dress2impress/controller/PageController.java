package com.amplesoftech.dress2impress.controller; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.amplesoftech.dress2impress.excepiton.SupplierClothesNotFoundException;
import com.amplesoftech.dress2impress.validator.CardValidator;
import com.amplesoftech.dress2impress.validator.CategoryValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.ContactusDAO;
import com.amplesoftech.dress2impressbackend.dao.DebitCardDetailsDAO;
import com.amplesoftech.dress2impressbackend.dao.SupplierClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.Contactus;
import com.amplesoftech.dress2impressbackend.dto.DebitCardDetails;
import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;
import com.amplesoftech.dress2impressbackend.dto.User;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	HttpSession session;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private SupplierClothesDAO supplierClothesDAO;
	
	@Autowired
	private DebitCardDetailsDAO debitCardDetailsDAO ;
	
	@Autowired
	private ClothesDAO clothesDAO;
	@Autowired
	private ContactusDAO contactUsDAO;
	
	@Autowired
	private UserDAO userDAO;
	
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
	@ModelAttribute("popularcategories")
	public List<Category> modelPopularCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	/*@ModelAttribute("popularcategory")
	public Category getPopularCategory() {
		return new Category();
	}*/
	
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
	 
	//methods to load all the supplier clothes based on category
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
	
	@RequestMapping(value="/show/all/popularclothes")
	public ModelAndView showAllPopularClothes()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Most Popular");
	
	//passing the list of categories
	mv.addObject("popularcategories",categoryDAO.listActiveCategory());
	mv.addObject("userClickPopularClothes",true);
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
	
	@RequestMapping(value="/show/category/{id}/popularclothes")
	public ModelAndView showCategoryPopularClothes(@PathVariable("id") int id)
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
	mv.addObject("userClickCategoryPopularClothes",true);
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
	
	//Show single Supplier Clothes to Employee
	
	@RequestMapping(value = "/show/{id}/supplierclothes") 
	public ModelAndView showSingleSupplierClothes(@PathVariable int id) throws SupplierClothesNotFoundException
	{
		
		ModelAndView mv = new ModelAndView("page");
			// update the view count
		SupplierClothes supplierClothes = supplierClothesDAO.get(id);

		
		mv.addObject("title", supplierClothes.getName());
		mv.addObject("supplierClothes", supplierClothes);
		
		mv.addObject("userClickShowSupplierClothes", true);
		return mv;
		
	}

	
	//--------------Supplier Payment Management Control--------------------
	@RequestMapping(value = "/proceed/debitcarddetails", method = RequestMethod.GET)
	public ModelAndView showCardDetails(@RequestParam(name = "operation", required = false) String operation,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page");
		//int id=(int) session.getAttribute("clothId");
		
		mv.addObject("title", "Manage Payment");
		DebitCardDetails ndebitCardDetails = new DebitCardDetails();
		mv.addObject("debitcarddetail", ndebitCardDetails);
		mv.addObject("userClickProceedPayment", true);
		
		if (operation != null) {		
			if (operation.equals("mcarddetails")) {
				mv.addObject("message", "Payment Done Successfully!");
			}
		}
		return mv;

	}

	// Handling Card Details submission
	@RequestMapping(value = "/proceed/{id}/debitcarddetails", method = RequestMethod.POST)
	public String handleCardSubmission(@PathVariable("id") int id, @Valid @ModelAttribute("debitcarddetail") DebitCardDetails mcarddetails, BindingResult results,Model model, HttpServletRequest request)
	{
		
		// Handle card validation for new card
		if (mcarddetails.getId()==0) 
		{
			new CardValidator().validate(mcarddetails, results);
		} 
		session.setAttribute("clothId", id);
		SupplierClothes supplierClothes=supplierClothesDAO.get(id);
		supplierClothes.setQuantity(supplierClothes.getQuantity()-1);
		supplierClothesDAO.update(supplierClothes);
		
		// check if there is any error
		if (results.hasErrors()) {
			model.addAttribute("userClickSupplierPayment", true);
			model.addAttribute("title", "Manage Payment");
			model.addAttribute("message", "Validation Failed For Payment Submission!");
			return "page";
		}
		logger.info(mcarddetails.toString());
		//supplierClothes.setQuantity(supplierClothes.getQuantity()-1);
		// Create a new Card Record
		if (mcarddetails.getId() == 0) {
			// create the card if id is 0
			debitCardDetailsDAO.add(mcarddetails);
		}
		return "redirect:/proceed/debitcarddetails?operation=mcarddetails";

	}
	
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Employee");
	return mv;
	}
	
	@RequestMapping(value="/{id}/supplierpayment")
	public ModelAndView supplierPayment(@PathVariable("id") int id, HttpServletRequest request)
	{
	session=request.getSession();
	session.setAttribute("clothesId", id);
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Payment");
	mv.addObject("userClickSupplierPayment", true);
	DebitCardDetails ndebitCardDetails = new DebitCardDetails();
	mv.addObject("debitcarddetail", ndebitCardDetails);
	SupplierClothes supplierClothes=supplierClothesDAO.get(id);
	double payAmount=supplierClothes.getUnitPrice();
	request.setAttribute("clothId", id);
	request.setAttribute("payable", payAmount);
	request.setAttribute("ClothName", supplierClothes.getName());
	request.setAttribute("Description", supplierClothes.getDescription());
	request.setAttribute("Quantity",1);
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
	
	/*@RequestMapping(value= "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword() 
	{
		return "forgetPassword";
		
	}*/
	
	@RequestMapping(value= "/forgetPassword", method = RequestMethod.GET)
	public ModelAndView forgetPassword() 
	{
		ModelAndView mv = new ModelAndView("page");
		List<User> list=userDAO.listAllUser();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
		return new ModelAndView("forgetPassword","list",list);
	}
	
	@RequestMapping(value= "/getPassword/{contactNumber}")
	public ModelAndView getPassword(@PathVariable("contactNumber") String contactNumber) 
	{
		String pwd=userDAO.getPasswordByContactNumber(contactNumber);
		return new ModelAndView("forgetPassword","pwd",pwd);
	}
	 /*@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	  public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String email, HttpServletRequest request) {

	    // Lookup user in database by e-mail
	    String password = userDAO.getPasswordByEmail(email);
	    request.setAttribute("password", password);

	    if (!password.isEmpty()) {
	      modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
	    }
	    modelAndView.setViewName("forgotPassword");
	    return modelAndView;
	 }*/
	
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
	// handling Query submission
		@RequestMapping(value = "/contactus", method = RequestMethod.POST)
		public String handleAddQuerySubmission(@Valid @ModelAttribute("contactus") Contactus mcontactus, BindingResult results,
				Model model, HttpServletRequest request) {
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickContactUs", true);
				model.addAttribute("title", "Contact Us");
				model.addAttribute("message", "Validation Failed For Query Submission!");
				return "page";
			}
			// Create a new contact Us Record
				contactUsDAO.add(mcontactus);
			
			return "redirect:/contactus?operation=contactus";

		}
		
		/*@RequestMapping(value = "/getPassword", method = RequestMethod.POST)
		public String handleContactNumberSubmission(Model model, HttpServletRequest request) {
				// handle  validation for new category
				// check if there is any error
				String pwd=userDAO.getPasswordByContactNumber(request.getParameter("contactNumber"));
				model.addAttribute("pwd",pwd);
			return "redirect:/getPassword";

		}*/
		
	}
