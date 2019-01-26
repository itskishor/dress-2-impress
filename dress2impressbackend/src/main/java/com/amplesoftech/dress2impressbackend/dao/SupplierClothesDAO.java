package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;
import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;

public interface SupplierClothesDAO 
{

	SupplierClothes get(int supplierClothesId);
	List<SupplierClothes> list();	
	boolean add(SupplierClothes supplierClothes);
	boolean update(SupplierClothes supplierClothes);
	boolean delete(SupplierClothes supplierClothes);

	List<SupplierClothes> getSupplierClothesByParam(String param, int count);	
	
	
	// business methods
	List<SupplierClothes> listActiveSupplierClothes();	
	List<SupplierClothes> listActiveSupplierClothesByCategory(int categoryId);
	List<SupplierClothes> getLatestActiveSupplierClothes(int count);

}
