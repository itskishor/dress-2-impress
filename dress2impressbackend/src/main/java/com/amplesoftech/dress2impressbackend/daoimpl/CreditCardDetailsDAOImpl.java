package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.CreditCardDetailsDAO;
import com.amplesoftech.dress2impressbackend.dto.CreditCardDetails;


@Repository("creditCardDetailsDAO")
@Transactional
public class CreditCardDetailsDAOImpl implements CreditCardDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CreditCardDetails> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM CreditCardDetails" , CreditCardDetails.class)
						.getResultList();
	}

	@Override
	public CreditCardDetails get(int id) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(CreditCardDetails.class,Integer.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public boolean add(CreditCardDetails creditCardDetails) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(creditCardDetails);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(CreditCardDetails creditCardDetails) {
		try {
			// call the update method
			return this.delete(creditCardDetails);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

}
