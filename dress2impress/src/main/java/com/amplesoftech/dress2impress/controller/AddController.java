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
import com.amplesoftech.dress2impress.validator.ClothesValidator;
import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

@Controller
@RequestMapping("/add")
public class AddController {
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private ClothesDAO clothesDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = "/clothes", method = RequestMethod.GET)
	public ModelAndView manageAddClothes(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Clothes");
		mv.addObject("userClickAddClothes", true);

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
	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listActiveCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	// handling clothes submission
		@RequestMapping(value = "/clothes", method = RequestMethod.POST)
		public String handleAddClothesSubmission(@Valid @ModelAttribute("clothes") Clothes mclothes, BindingResult results,
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
				model.addAttribute("userClickAddClothes", true);
				model.addAttribute("title", "Add Clothes");
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
			return "redirect:/add/clothes?operation=clothes";

		}


}
