package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;

import com.amplesoftech.dress2impressbackend.dto.Clothes;

public interface ClothesDAO {
	

	Clothes get(int clothesId);
	List<Clothes> list();	
	boolean add(Clothes clothes);
	boolean update(Clothes clothes);
	boolean delete(Clothes clothes);

	List<Clothes> getClothesByParam(String param);	
	
	
	// business methods
	List<Clothes> listActiveClothes();	
	List<Clothes> listActiveClothesByCategory(int categoryId);
	List<Clothes> getLatestActiveClothes(int count);

}
