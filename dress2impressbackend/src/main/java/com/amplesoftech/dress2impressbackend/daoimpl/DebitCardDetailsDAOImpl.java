package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.DebitCardDetailsDAO;
import com.amplesoftech.dress2impressbackend.dto.DebitCardDetails;

@Repository("debitCardDetailsDAO")
@Transactional
public class DebitCardDetailsDAOImpl implements DebitCardDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<DebitCardDetails> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM DebitCardDetails" , DebitCardDetails.class)
						.getResultList();
	}

	@Override
	public DebitCardDetails get(int id) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(DebitCardDetails.class,Integer.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public boolean add(DebitCardDetails debitCardDetails) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(debitCardDetails);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(DebitCardDetails debitCardDetails) {
		 try {
				// call the update method
				return this.delete(debitCardDetails);
			}
			catch(Exception ex) {		
				ex.printStackTrace();			
			}		
			return false;
	}

}
