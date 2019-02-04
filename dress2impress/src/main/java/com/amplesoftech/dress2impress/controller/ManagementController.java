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

import com.amplesoftech.dress2impress.validator.CategoryValidator;
import com.amplesoftech.dress2impress.validator.EmployeeValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.OrderDetailsDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;
import com.amplesoftech.dress2impressbackend.dto.User;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	/*@Autowired
	private ClothesDAO clothesDAO;*/
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	/*
	 * @RequestMapping(value = "/category", method=RequestMethod.POST) public String
	 * managePostCategory(@ModelAttribute("category") Category mCategory,
	 * HttpServletRequest request) { categoryDAO.add(mCategory); return "redirect:"
	 * + request.getHeader("Referer") + "?success=category"; }
	 */

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	//--------------------Category Management Controller-------------

		@RequestMapping(value = "/categories", method = RequestMethod.GET)
		public ModelAndView showManageCategories(@RequestParam(name = "operation", required = false) String operation) {

			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title", "Manage Categories");
			mv.addObject("userClickManageCategories", true);

			Category ncategory = new Category();

			// assuming that the user is ADMIN
			// later we will fixed it based on user is SUPPLIER or ADMIN
			ncategory.setActive(true);

			mv.addObject("category", ncategory);

			if (operation != null) {
				if (operation.equals("category")) {
					mv.addObject("message", "Category Information Submitted Successfully!");
				}
			}
			return mv;
		}
		
		@RequestMapping(value = "/categories/{id}/activation", method = RequestMethod.POST)
		@ResponseBody
		public String managePostCategoryActivation(@PathVariable int id) {
			// Is going to fetch the categories from database
			Category category = categoryDAO.get(id);
			boolean isActive = category.isActive();
			// activation and deactivation based on the values of the active field
			category.setActive(!category.isActive());
			// update the Category
			categoryDAO.update(category);
			return (isActive) ? "You have successfully deactivated Category with " + category.getId()
					: "You have successfully activated Category with: " + category.getId();
		}
		
		@RequestMapping(value ="/{id}/category", method = RequestMethod.GET)
		public ModelAndView showEditCategory(@PathVariable int id) {

			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title", "Category Management");
			mv.addObject("userClickManageCategories", true);
			// fetch the category from database
			Category mcategory = categoryDAO.get(id);
			// set the category fetch from the database
			mv.addObject("category", mcategory);

			return mv;

		}

	// To handle category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@Valid @ModelAttribute("category") Category mcategory, BindingResult results,
				Model model, HttpServletRequest request) {
			// handle  validation for new category
			if (mcategory.getId() == 0) {
				new CategoryValidator().validate(mcategory, results);
			} 
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickManageCategory", true);
				model.addAttribute("title", "Manage Category");
				model.addAttribute("message", "Validation Failed For Category Submission!");
				return "page";
			}
			logger.info(mcategory.toString());
			// Create a new Category Record
			if (mcategory.getId() == 0) {
				// create the Category if id is 0
				categoryDAO.add(mcategory);
			} 
			else 
			{
				// update the employee if id is not 0
				categoryDAO.update(mcategory);
			}
		return "redirect:/manage/categories?operation=category";

	}
	
	
	//--------------------Employee Management Controller-------------
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView showManageEmployee(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Employee");
		mv.addObject("userClickManageEmployee", true);

		User nuser = new User();
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nuser.setEnabled(true);

		mv.addObject("user", nuser);

		if (operation != null) {
			if (operation.equals("employee")) {
				mv.addObject("message", "Employee Information Submitted Successfully!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/employee/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String managePostEmployeeActivation(@PathVariable int id) {
		// Is going to fetch the User from database
		User user = userDAO.get(id);
		boolean isActive = user.isEnabled();
		// activation and De-activation based on the values of the active field
		user.setEnabled(!user.isEnabled());
		// update the User
		userDAO.update(user);
		return (isActive) ? "You have successfully deactivated Employee with " +user.getId()
				: "You have successfully activated Employee with: " + user.getId();
		
	}
	
	@RequestMapping(value ="/{id}/employee", method = RequestMethod.GET)
	public ModelAndView showEditEmployee(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Employee Management");
		mv.addObject("userClickManageEmployee", true);
		// fetch the employee from database
		User user = userDAO.get(id);
		// set the employee fetch from the database
		mv.addObject("user", user);

		return mv;

	}
	// handling User submission
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String handleEmployeeSubmission(@Valid @ModelAttribute("user") User muser, BindingResult results,
			Model model, HttpServletRequest request) {
		
		if(muser.getId() == 0) {
		       new EmployeeValidator().validate(muser, results);
	      }
		// check if there is any error
		if (results.hasErrors()) {
			model.addAttribute("userClickManageEmployee", true);
			model.addAttribute("title", "Manage Employee");
			model.addAttribute("message", "Validation Failed For Employee Submission!");
			return "page";
		}
		logger.info(muser.toString());
		// Create a new User Record
		if (muser.getId() == 0) {
			// create the user if id is 0
		userDAO.addUser(muser);
		} 
		else {
			// update the user if id is not 0
			userDAO.update(muser);
		}

		return "redirect:/manage/employee?operation=employee";

	}
			
			//--------------------SUPPLIER Management Controller-------------

			@RequestMapping(value = "/supplier", method = RequestMethod.GET)
			public ModelAndView showManageSupplier(@RequestParam(name = "operation", required = false) String operation) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "Manage Supplier");
				mv.addObject("userClickManageSupplier", true);

				User nuser = new User();
				// assuming that the user is ADMIN
				// later we will fixed it based on user is SUPPLIER or ADMIN
				nuser.setEnabled(true);

				mv.addObject("user", nuser);

				if (operation != null) {
					if (operation.equals("supplier")) {
						mv.addObject("message", "Supplier Information Submitted Successfully!");
					}
				}
				return mv;
			}
			
			@RequestMapping(value = "/supplier/{id}/activation", method = RequestMethod.POST)
			@ResponseBody
			public String managePostSupplierActivation(@PathVariable int id) {
				// Is going to fetch the User from database
				User user = userDAO.get(id);
				boolean isActive = user.isEnabled();
				// activation and De-activation based on the values of the active field
				user.setEnabled(!user.isEnabled());
				// update the User
				userDAO.update(user);
				return (isActive) ? "You have successfully deactivated Supplier with " +user.getId()
						: "You have successfully activated Supplier with: " + user.getId();
				
			}
			
			@RequestMapping(value ="/{id}/supplier", method = RequestMethod.GET)
			public ModelAndView showEditSupplier(@PathVariable int id) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "Supplier Management");
				mv.addObject("userClickManageSupplier", true);
				// fetch the employee from database
				User user = userDAO.get(id);
				// set the employee fetch from the database
				mv.addObject("user", user);

				return mv;

			}
			// handling User submission
			@RequestMapping(value = "/supplier", method = RequestMethod.POST)
			public String handleSupplierSubmission(@Valid @ModelAttribute("user") User muser, BindingResult results,
					Model model, HttpServletRequest request) {
				// handle image validation for new clothes
				/*if (muser.getId() == 0) {
					new EmployeeValidator().validate(muser, results);
				} */
				// check if there is any error
				if (results.hasErrors()) {
					model.addAttribute("userClickManageSupplier", true);
					model.addAttribute("title", "Manage Supplier");
					model.addAttribute("message", "Validation Failed For Supplier Submission!");
					return "page";
				}
				logger.info(muser.toString());
				// Create a new User Record
				if (muser.getId() == 0) {
					// create the user if id is 0
					//userDAO.addUser(muser);
					model.addAttribute("message", "You Can't Add Supplier From Here!");
				} else {
					// update the user if id is not 0
					userDAO.update(muser);
				}

				return "redirect:/manage/supplier?operation=supplier";

			}
		
			//--------------Transaction Management Control--------------------
			@RequestMapping(value = "/viewtransactions", method = RequestMethod.GET)
			public ModelAndView showManageTransaction(@RequestParam(name = "operation", required = false) String operation) {

				ModelAndView mv = new ModelAndView("page");
				mv.addObject("title", "View Transactions");
				mv.addObject("userClickAdminViewTransaction", true);
				
				

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
			
			// handling Transaction submission
			@RequestMapping(value = "/viewtransactions", method = RequestMethod.POST)
			public String handleTransactionSubmission(@Valid @ModelAttribute("transactions") OrderDetail orderDetail, BindingResult results,
					Model model, HttpServletRequest request) { 
				// check if there is any error
				if (results.hasErrors()) {
					model.addAttribute("userClickEmployeeManagetransaction", true);
					model.addAttribute("title", "Manage Transactions");
					model.addAttribute("message", "Validation Failed For Transaction Submission!");
					return "page";
				}
				request.setAttribute("TotalProfit",orderDetailsDAO.totalProfit() );
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
