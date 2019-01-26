package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.SupplierClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.SupplierClothes;

@Repository("supplierClothesDAO")
@Transactional
public class SupplierClothesDAOImpl implements SupplierClothesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SupplierClothes get(int supplierClothesId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(SupplierClothes.class,Integer.valueOf(supplierClothesId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public List<SupplierClothes> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM SupplierClothes" , SupplierClothes.class)
						.getResultList();
	}

	@Override
	public boolean add(SupplierClothes supplierClothes) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(supplierClothes);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean update(SupplierClothes supplierClothes) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(supplierClothes);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(SupplierClothes supplierClothes) {
try {
			
	supplierClothes.setActive(false);
			// call the update method
			return this.update(supplierClothes);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public List<SupplierClothes> getSupplierClothesByParam(String param, int count) {
String query = "FROM SupplierClothes WHERE active = true ORDER BY " + param + " DESC";
		
		return sessionFactory
					.getCurrentSession()
					.createQuery(query,SupplierClothes.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
	}

	@Override
	public List<SupplierClothes> listActiveSupplierClothes() {
		String selectActiveSupplierClothes = "FROM SupplierClothes WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveSupplierClothes, SupplierClothes.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<SupplierClothes> listActiveSupplierClothesByCategory(int categoryId) {
		String selectActiveSupplierClothesByCategory = "FROM SupplierClothes WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveSupplierClothesByCategory, SupplierClothes.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<SupplierClothes> getLatestActiveSupplierClothes(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM SupplierClothes WHERE active = :active ORDER BY id", SupplierClothes.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();	
	}

}
