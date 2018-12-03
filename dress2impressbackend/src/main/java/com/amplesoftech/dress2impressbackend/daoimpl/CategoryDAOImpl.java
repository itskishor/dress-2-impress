package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amplesoftech.dress2impressbackend.dao.CategoryDAO;
import com.amplesoftech.dress2impressbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<Category>();
 
	static {

		Category category = new Category();
		// Adding First category
		category.setId(1);
		category.setName("Men");
		category.setDescr("Here is Men");
		category.setImageURL("men.png");

		categories.add(category);

		// Adding Second category
		category = new Category();
		category.setId(2);
		category.setName("Women");
		category.setDescr("Here is Women");
		category.setImageURL("women.png");

		categories.add(category);

		// Adding Third category
		category = new Category();
		category.setId(3);
		category.setName("Kids");
		category.setDescr("Here is Kids");
		category.setImageURL("kid.png");

		categories.add(category); 
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// Enhanced for loop
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		return null;
			
	}

}
