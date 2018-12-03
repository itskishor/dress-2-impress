package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);

}
