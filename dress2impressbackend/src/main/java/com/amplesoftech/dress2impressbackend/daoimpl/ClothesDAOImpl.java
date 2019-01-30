package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.ClothesDAO;
import com.amplesoftech.dress2impressbackend.dto.Clothes;

@Repository("clothesDAO")
@Transactional
public class ClothesDAOImpl implements ClothesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Clothes get(int clothesId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Clothes.class,Integer.valueOf(clothesId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}
	
	/*
	 * LIST
	 * */
	
	@Override
	public List<Clothes> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Clothes" , Clothes.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Clothes clothes) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(clothes);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}
	
	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Clothes clothes) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(clothes);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}


	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Clothes clothes) {
		try {
			
			clothes.setActive(false);
			// call the update method
			return this.update(clothes);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Clothes> listActiveClothes() {
		String selectActiveClothes = "FROM Clothes WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveClothes, Clothes.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Clothes> listActiveClothesByCategory(int categoryId) {
		String selectActiveClothesByCategory = "FROM Clothes WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveClothesByCategory, Clothes.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Clothes> getLatestActiveClothes(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Clothes WHERE active = :active ORDER BY id", Clothes.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

	@Override
	public List<Clothes> getClothesByParam(String views) {
		
		String query = "FROM Clothes WHERE active = true ORDER BY " + views + " DESC";
		
		return sessionFactory
					.getCurrentSession()
					.createQuery(query,Clothes.class)
					.setFirstResult(0)
				/*	.setMaxResults(count)*/
					.getResultList();
					
		
	}

}
