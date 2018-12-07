package com.amplesoftech.dress2impress.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

@Controller
public class PageController {
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ClothesDAO clothesDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Home");
	
	//passing the list of categories
	mv.addObject("categories", categoryDAO.list());
	mv.addObject("userClickHome",true);
	return mv;
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Admin");
	mv.addObject("userClickAdmin",true);
	return mv;
	}
	
	@RequestMapping(value="/employee")
	public ModelAndView employee()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Employee");
	mv.addObject("userClickEmployee",true);
	return mv;
	}
	
	@RequestMapping(value="/supplier")
	public ModelAndView supplier()
	{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Supplier");
	mv.addObject("userClickSupplier",true);
	return mv;
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
	mv.addObject("categories",categoryDAO.list());
	mv.addObject("userClickViewClothes",true);
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
	mv.addObject("categories",categoryDAO.list());
	//passing the single category
	mv.addObject("category",category);
	mv.addObject("userClickCategoryClothes",true);
	return mv;
	}
	
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/clothes") 
	public ModelAndView showSingleProduct(@PathVariable int id){
		
		ModelAndView mv = new ModelAndView("page");
			// update the view count
		Clothes clothes = clothesDAO.get(id);
		clothes.setViews(clothes.getViews() + 1);
		clothesDAO.update(clothes);
		//---------------------------
		
		mv.addObject("title", clothes.getName());
		mv.addObject("clothes", clothes);
		
		mv.addObject("userClickShowClothes", true);
		
		
		return mv;
		
	}
}
