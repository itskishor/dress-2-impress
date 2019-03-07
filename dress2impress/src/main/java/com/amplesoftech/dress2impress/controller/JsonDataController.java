package com.amplesoftech.dress2impress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.OrderDetailsDAO;
import com.amplesoftech.dress2impressbackend.dao.SupplierClothesDAO;
import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.Clothes;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;
import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;
import com.amplesoftech.dress2impressbackend.dto.User;

@Controller
@RequestMapping("/json/data")
public class JsonDataController 
{

	@Autowired
	private ClothesDAO clothesDAO;
	
	@Autowired
	private SupplierClothesDAO supplierClothesDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/all/clothes")
	@ResponseBody
	public List<Clothes> getAllClothes() {
		
		return clothesDAO.listActiveClothes();
				
	}
	
	@RequestMapping("/all/popular/clothes")
	@ResponseBody
	public List<Clothes> getAllpopularClothes() {
		
		return clothesDAO.getClothesByParam("views");
				
	}
	
	@RequestMapping("/all/supplierclothes")
	@ResponseBody
	public List<SupplierClothes> getAllSupplierClothes() {
		
		return supplierClothesDAO.listActiveSupplierClothes();
				
	}
	
	@RequestMapping("/all/activetransactions")
	@ResponseBody
	public List<OrderDetail> getAllActiveTransactions() {		
		return orderDetailsDAO.listActiveTransactions();
				
	}
	
	
	@RequestMapping("/admin/all/clothes")
	@ResponseBody
	public List<Clothes> getAllClothesListForAdmin() {		
		return clothesDAO.list();
				
	}
	

	@RequestMapping("/admin/all/employees")
	@ResponseBody
	public List<User> getAllEmployeeListForAdmin() {		
		return userDAO.listByRole("EMPLOYEE");
				
	}
	
	@RequestMapping("/admin/all/user")
	@ResponseBody
	public List<User> getAllUserListForAdmin() {		
		return userDAO.listByRole("USER");
				
	}
	
	@RequestMapping("/admin/all/supplier")
	@ResponseBody
	public List<User> getAllSupplierListForAdmin() {		
		return userDAO.listByRole("SUPPLIER");
				
	}
	
	
	@RequestMapping("/category/{id}/clothes")
	@ResponseBody
	public List<Clothes> getProductsByCategory(@PathVariable int id) {
		
		return clothesDAO.listActiveClothesByCategory(id);
				
	}
		
	@RequestMapping("/mp/clothes")
	@ResponseBody
	public List<Clothes> getMostRentedClothes() {		
		return clothesDAO.getClothesByParam("rented");				
	}
	
	/*@RequestMapping(value ="/{email}/getPassword", method = RequestMethod.GET)
	public ModelAndView showEditCategory(@PathVariable String email) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Forget Password");
		mv.addObject("userClickGetPassWord", true);
		// fetch the category from database
		String emaill=userDAO.getPasswordByContactNumber(email);
		// set the category fetch from the database
		mv.addObject("email", emaill);

		return mv;

	}*/
	
	

	@RequestMapping("/admin/all/categories")
	@ResponseBody
	public List<Category> getAllCategoryListForAdmin() {		
		return categoryDAO.list();
				
	}
	
	@RequestMapping("/admin/all/transactions")
	@ResponseBody
	public List<OrderDetail> getAllTransactionsListForAdmin() {		
		return orderDetailsDAO.list();
				
	}

}
