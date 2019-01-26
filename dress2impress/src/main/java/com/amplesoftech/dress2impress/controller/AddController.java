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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impress.util.FileUploadUtility;
import com.amplesoftech.dress2impress.validator.SupplierClothesValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.SupplierClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;

@Controller
@RequestMapping("/add")
public class AddController {
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private SupplierClothesDAO supplierClothesDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	/*@Autowired
	private ContactusDAO contactUsDAO;*/
	
	@RequestMapping(value = "/supplierclothes", method = RequestMethod.GET)
	public ModelAndView manageAddClothes(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Clothes");
		mv.addObject("userClickAddClothes", true);

		SupplierClothes nSupplierClothes = new SupplierClothes();

		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nSupplierClothes.setSupplierId(1);
		nSupplierClothes.setActive(true);

		mv.addObject("supplierclothes", nSupplierClothes);

		if (operation != null) {
			if (operation.equals("supplierclothes")) {
				mv.addObject("message", "Your Clothes Inserted Successfully!");
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
	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	// handling clothes submission
		@RequestMapping(value = "/supplierclothes", method = RequestMethod.POST)
		public String handleAddSupplierClothesSubmission(@Valid @ModelAttribute("supplierclothes") SupplierClothes mSupplierClothes, BindingResult results,
				Model model, HttpServletRequest request) {
			// handle image validation for new clothes
			if (mSupplierClothes.getId() == 0) {
				new SupplierClothesValidator().validate(mSupplierClothes, results);
			} else {
				if (!mSupplierClothes.getFile().getOriginalFilename().equals("")) {
					// FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
					new SupplierClothesValidator().validate(mSupplierClothes, results);
				}
			}
			// check if there is any error
			if (results.hasErrors()) {
				model.addAttribute("userClickAddClothes", true);
				model.addAttribute("title", "Add Clothes");
				model.addAttribute("message", "Validation Failed For your Clothes Submission!");
				return "page";
			}
			logger.info(mSupplierClothes.toString());
			// Create a new Clothes Record
			if (mSupplierClothes.getId() == 0) {
				// create the clothes if id is 0
				supplierClothesDAO.add(mSupplierClothes);
			} else {
				// update the clothes if id is not 0
				supplierClothesDAO.update(mSupplierClothes);
			}

			if (!mSupplierClothes.getFile().getOriginalFilename().equals("")) {
				FileUploadUtility.uploadFile(request, mSupplierClothes.getFile(), mSupplierClothes.getCode());
			}
			return "redirect:/add/supplierclothes?operation=supplierclothes";

		}
		
		//Add Query By User
		/*
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
			}
			return mv;

		}
		// handling clothes submission
			@RequestMapping(value = "/contactus", method = RequestMethod.POST)
			public String handleAddQuerySubmission(@Valid @ModelAttribute("contactus") Contactus mcontactus, BindingResult results,
					Model model, HttpServletRequest request) {
				// handle image validation for new clothes
				if (mcontactus.getId() == 0) {
					new ClothesValidator().validate(mclothes, results);
				} else {
					if (!mclothes.getFile().getOriginalFilename().equals("")) {
						// FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
						new ClothesValidator().validate(mclothes, results);
					}
				}
				// check if there is any error
				if (results.hasErrors()) {
					model.addAttribute("userClickContactUs", true);
					model.addAttribute("title", "Contact Us");
					model.addAttribute("message", "Validation Failed For Product Submission!");
					return "page";
				}
				logger.info(mcontactus.toString());
				// Create a new Clothes Record
				if (mcontactus.getId() == 0) {
					// create the clothes if id is 0
					contactUsDAO.add(mcontactus);
				} 
				else {
					// update the clothes if id is not 0
					contactUsDAO.update(mcontactus);
				}
				return "redirect:/add/contactus?operation=contactus";

			}
*/


}
