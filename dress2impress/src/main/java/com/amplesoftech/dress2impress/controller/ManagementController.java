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
import com.amplesoftech.dress2impress.validator.ClothesValidator;
import com.amplesoftech.dress2impress.validator.EmployeeValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.EmployeeDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.Employee;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private ClothesDAO clothesDAO;
	
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private CategoryDAO categoryDAO;
    
	//--------------------Clothes Management Controller-------------
	
	
	@RequestMapping(value = "/clothes", method = RequestMethod.GET)
	public ModelAndView showmanageClothes(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Clothes");
		mv.addObject("userClickManageClothes", true);

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
			model.addAttribute("userClickManageClothes", true);
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
		return "redirect:/manage/clothes?operation=clothes";

	}

	@RequestMapping(value = "/{id}/clothes", method = RequestMethod.GET)
	public ModelAndView showEditClothes(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Clothes Management");
		mv.addObject("userClickManageClothes", true);
		// fetch the clothes from database
		Clothes nclothes = clothesDAO.get(id);
		// set the clothes fetch from the database
		mv.addObject("clothes", nclothes);

		return mv;

	}

	/*
	 * @RequestMapping(value = "/product", method=RequestMethod.POST) public String
	 * managePostProduct(@Valid @ModelAttribute("product") Product mProduct,
	 * BindingResult results, Model model, HttpServletRequest request) {
	 * 
	 * // mandatory file upload check if(mProduct.getId() == 0) { new
	 * ProductValidator().validate(mProduct, results); } else { // edit check only
	 * when the file has been selected
	 * if(!mProduct.getFile().getOriginalFilename().equals("")) { new
	 * ProductValidator().validate(mProduct, results); } }
	 * 
	 * if(results.hasErrors()) { model.addAttribute("message",
	 * "Validation fails for adding the product!");
	 * model.addAttribute("userClickManageProduct",true); return "page"; }
	 * 
	 * 
	 * if(mProduct.getId() == 0 ) { productDAO.add(mProduct); } else {
	 * productDAO.update(mProduct); }
	 * 
	 * //upload the file if(!mProduct.getFile().getOriginalFilename().equals("") ){
	 * FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode()); }
	 * 
	 * return "redirect:/manage/product?success=product"; }
	 */

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
	
	
	//--------------------Employee Management Controller-------------

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView showManageEmployee(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Employee");
		mv.addObject("userClickManageEmployee", true);

		Employee nemployee = new Employee();

		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//employee.setSupplierId(1);
		nemployee.setEnabled(true);

		mv.addObject("employee", nemployee);

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
		// Is going to fetch the employee from database
		Employee employee = employeeDAO.get(id);
		boolean isActive = employee.isEnabled();
		// activation and deactivation based on the values of the active field
		employee.setEnabled(!employee.isEnabled());
		// update the product
		employeeDAO.update(employee);
		return (isActive) ? "You have successfully deactivated Employee with " + employee.getId()
				: "You have successfully activated Employee with: " + employee.getId();
	}
	
	@RequestMapping(value = "/{id}/employee", method = RequestMethod.GET)
	public ModelAndView showEditEmployee(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Employee Management");
		mv.addObject("userClickManageEmployee", true);
		// fetch the clothes from database
		Employee memployee = employeeDAO.get(id);
		// set the clothes fetch from the database
		mv.addObject("employee", memployee);

		return mv;

	}
	
	// Handling Employee Addition
		@RequestMapping(value = "/employee", method = RequestMethod.POST)
		public String handleEmployeeSubmission(@Valid @ModelAttribute("employee") Employee memployee, BindingResult results,
				Model model, HttpServletRequest request) {
			// handle image validation for new clothes
			if (memployee.getId() == 0) {
				new EmployeeValidator().validate(memployee, results);
			} 
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickManageEmployee", true);
				model.addAttribute("title", "Manage Employee");
				model.addAttribute("message", "Validation Failed For Employee Submission!");
				return "page";
			}
			logger.info(memployee.toString());
			// Create a new employee Record
			if (memployee.getId() == 0) {
				// create the employee if id is 0
				employeeDAO.add(memployee);
			} else {
				// update the employee if id is not 0
				employeeDAO.update(memployee);
			}
			return "redirect:/manage/employee?operation=employee";

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
			// handle image validation for new clothes
			if (mcategory.getId() == 0) {
				new EmployeeValidator().validate(mcategory, results);
			} 
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickManageCategory", true);
				model.addAttribute("title", "Manage Category");
				model.addAttribute("message", "Validation Failed For Category Submission!");
				return "page";
			}
			logger.info(mcategory.toString());
			// Create a new employee Record
			if (mcategory.getId() == 0) {
				// create the employee if id is 0
				categoryDAO.add(mcategory);
			} 
			else 
			{
				// update the employee if id is not 0
				categoryDAO.update(mcategory);
			}
		return "redirect:/manage/categories?operation=category";

	}

}
