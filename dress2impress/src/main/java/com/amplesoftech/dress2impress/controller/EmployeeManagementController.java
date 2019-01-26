package com.amplesoftech.dress2impress.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impress.util.FileUploadUtility;
import com.amplesoftech.dress2impress.validator.CardValidator;
import com.amplesoftech.dress2impress.validator.ClothesValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.DebitCardDetailsDAO;
import com.amplesoftech.dress2impressbackend.dao.OrderDetailsDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.DebitCardDetails;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;
import com.amplesoftech.dress2impressbackend.dto.User;

@Controller
@RequestMapping("/employeemanage")
public class EmployeeManagementController 
{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagementController.class);

	@Autowired
	private ClothesDAO clothesDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	private DebitCardDetailsDAO debitCardDetailsDAO;
    
	//--------------------Clothes Management Controller-------------
	
	
	@RequestMapping(value = "/clothes", method = RequestMethod.GET)
	public ModelAndView showmanageClothes(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Clothes");
		mv.addObject("userClickEmployeeManageClothes", true);

		Clothes nClothes = new Clothes();

		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nClothes.setSupplierId(1);
		nClothes.setActive(true);

		mv.addObject("clothes", nClothes);

		if (operation != null) {
			if (operation.equals("clothes")) {
				mv.addObject("message", "Clothes Inserted Successfully!");
			} else if (operation.equals("category")) {
				mv.addObject("message", "Category Inserted Successfully!");

			}
		}

		/*
		 * if(success != null) { if(success.equals("product")){ mv.addObject("message",
		 * "Product submitted successfully!"); } else if (success.equals("category")) {
		 * mv.addObject("message", "Category submitted successfully!"); } }
		 */
		return mv;

	}
	
	
	//------------------------Add Clothes-----------------------------------

	// handling clothes submission
	@RequestMapping(value = "/clothes", method = RequestMethod.POST)
	public String handleClothesSubmission(@Valid @ModelAttribute("clothes") Clothes mclothes, BindingResult results,
			Model model, HttpServletRequest request) {
		// handle image validation for new clothes
		if (mclothes.getId() == 0) {
			new ClothesValidator().validate(mclothes, results);
		} else {
			if (!mclothes.getFile().getOriginalFilename().equals("")) {
				// FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
				new ClothesValidator().validate(mclothes, results);
			}
		}
		// check if there is any error
		if (results.hasErrors()) {
			model.addAttribute("userClickEmployeeManageClothes", true);
			model.addAttribute("title", "Manage Clothes");
			model.addAttribute("message", "Validation Failed For Product Submission!");
			return "page";
		}
		logger.info(mclothes.toString());
		// Create a new Clothes Record
		if (mclothes.getId() == 0) {
			// create the clothes if id is 0
			clothesDAO.add(mclothes);
		} else {
			// update the clothes if id is not 0
			clothesDAO.update(mclothes);
		}

		if (!mclothes.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mclothes.getFile(), mclothes.getCode());
		}
		return "redirect:/employeemanage/clothes?operation=clothes";

	}

	@RequestMapping(value = "/{id}/clothes", method = RequestMethod.GET)
	public ModelAndView showEditClothes(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Clothes Management");
		mv.addObject("userClickEmployeeManageClothes", true);
		// fetch the clothes from database
		Clothes nclothes = clothesDAO.get(id);
		// set the clothes fetch from the database
		mv.addObject("clothes", nclothes);

		return mv;

	}

	@RequestMapping(value = "/clothes/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String managePostClothesActivation(@PathVariable int id) {
		// Is going to fetch the clothes from database
		Clothes clothes = clothesDAO.get(id);
		boolean isActive = clothes.isActive();
		// activation and deactivation based on the values of the active field
		clothes.setActive(!clothes.isActive());
		// update the product
		clothesDAO.update(clothes);
		return (isActive) ? "You have successfully deactivated clothes with " + clothes.getId()
				: "You have successfully activated clothes with: " + clothes.getId();
	}	
	
	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	//--------------------USER Management Controller-------------

			@RequestMapping(value = "/user", method = RequestMethod.GET)
			public ModelAndView showManageUser(@RequestParam(name = "operation", required = false) String operation) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "Manage User");
				mv.addObject("userClickEmployeeManageUser", true);

				User nuser = new User();
				// assuming that the user is ADMIN
				// later we will fixed it based on user is SUPPLIER or ADMIN
				nuser.setEnabled(true);

				mv.addObject("user", nuser);

				if (operation != null) {
					if (operation.equals("user")) {
						mv.addObject("message", "User Information Submitted Successfully!");
					}
				}
				return mv;
			}
			
			@RequestMapping(value = "/user/{id}/activation", method = RequestMethod.POST)
			@ResponseBody
			public String managePostUserActivation(@PathVariable int id) {
				// Is going to fetch the categories from database
				User user = userDAO.get(id);
				boolean isActive = user.isEnabled();
				// activation and De-activation based on the values of the active field
				user.setEnabled(!user.isEnabled());
				// update the User
				userDAO.update(user);
				return (isActive) ? "You have successfully deactivated User with " +user.getId()
						: "You have successfully activated User with: " + user.getId();
				
			}
			
			@RequestMapping(value ="/{id}/user", method = RequestMethod.GET)
			public ModelAndView showEditUser(@PathVariable int id) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "User Management");
				mv.addObject("userClickEmployeeManageUser", true);
				// fetch the employee from database
				User user = userDAO.get(id);
				// set the employee fetch from the database
				mv.addObject("user", user);

				return mv;

			}
			// handling User submission
			@RequestMapping(value = "/user", method = RequestMethod.POST)
			public String handleUserSubmission(@Valid @ModelAttribute("user") User muser, BindingResult results,
					Model model, HttpServletRequest request) { 
				// check if there is any error
				if (results.hasErrors()) {
					model.addAttribute("userClickEmployeeManageUser", true);
					model.addAttribute("title", "Manage User");
					model.addAttribute("message", "Validation Failed For User Submission!");
					return "page";
				}
				logger.info(muser.toString());
				// Create a new User Record
				if (muser.getId() == 0) {
					// create the user if id is 0
					//userDAO.addUser(muser);
					model.addAttribute("message", "You Can't Add User From Here!");
				} else {
					// update the user if id is not 0
					userDAO.update(muser);
				}

				return "redirect:/employeemanage/user?operation=user";

			}
			
			//-----------Supplier Clothes Purchase Management------------------
			
			//methods to load all the supplier clothes
			@RequestMapping(value="/purchase")
			public ModelAndView showAllSupplierClothes()
			{
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","Purchase Clothes");
			mv.addObject("userClickEmployeePurchaseClothes",true);
			return mv;
			}
			
			//--------------Transaction Management Control--------------------
			@RequestMapping(value = "/transactions", method = RequestMethod.GET)
			public ModelAndView showManageTransaction(@RequestParam(name = "operation", required = false) String operation) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "Manage Transaction");
				mv.addObject("userClickEmployeeManageTransaction", true);

				OrderDetail orderDetail = new OrderDetail();
				// assuming that the user is ADMIN

				mv.addObject("transactions",orderDetail);

				if (operation != null) {
					if (operation.equals("transactions")) {
						mv.addObject("message", "Transaction Information Submitted Successfully!");
					}
				}
				return mv;
			}
			
			@RequestMapping(value = "/transactions/{id}/activation", method = RequestMethod.POST)
			@ResponseBody
			public String managePostTransactionsActivation(@PathVariable int id) {
				// Is going to fetch the Transactions from database
				OrderDetail orderDetail = orderDetailsDAO.get(id);
				boolean isActive = orderDetail.isActive();
				// activation and De-Activation based on the values of the active field
				orderDetail.setActive(!orderDetail.isActive());
				// update the Transaction
				orderDetailsDAO.update(orderDetail);
				return (isActive) ? "You have successfully Closed Transaction with " + orderDetail.getId()
						: "You have successfully Activated Transaction with: " + orderDetail.getId();
			}
			
			// handling Transaction submission
			@RequestMapping(value = "/transactions", method = RequestMethod.POST)
			public String handleTransactionSubmission(@Valid @ModelAttribute("transactions") OrderDetail orderDetail, BindingResult results,
					Model model, HttpServletRequest request) { 
				// check if there is any error
				if (results.hasErrors()) {
					model.addAttribute("userClickEmployeeManagetransaction", true);
					model.addAttribute("title", "Manage Transactions");
					model.addAttribute("message", "Validation Failed For Transaction Submission!");
					return "page";
				}
				logger.info(orderDetail.toString());
				// Create a new Transaction Record
				if (orderDetail.getId() == 0) 
				{
					model.addAttribute("message", "You Can't Add Order Details From Here!");
				}
				else 
				{
					// update the Transaction if id is not 0
					orderDetailsDAO.update(orderDetail);
				}

				return "redirect:/employeemanage/transactions?operation=transactions";

			}			
						
}
