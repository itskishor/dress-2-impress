package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.ContactusDAO;
import com.amplesoftech.dress2impressbackend.dto.Contactus;

@Repository("contactusDAO")
@Transactional
public class ContactusDAOImpl implements ContactusDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Contactus> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Contactus" , Contactus.class)
						.getResultList();
	}

	@Override
	public Contactus get(int id) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Contactus.class,Integer.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public boolean add(Contactus contactus) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(contactus);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(Contactus contactus) {
     try {
			// call the update method
			return this.delete(contactus);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean update(Contactus contactus) {
		 try {
				// call the update method
				return this.update(contactus);
			}
			catch(Exception ex) {		
				ex.printStackTrace();			
			}		
			return false;
	}

}
