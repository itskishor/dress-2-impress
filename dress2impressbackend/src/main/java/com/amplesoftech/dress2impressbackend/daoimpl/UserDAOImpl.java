package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.UserDAO;
import com.amplesoftech.dress2impressbackend.dto.Address;
import com.amplesoftech.dress2impressbackend.dto.Category;
import com.amplesoftech.dress2impressbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	@Override
	public boolean addUser(User user) {
		try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {			
			// will look for this code later and why we need to change it
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			System.out.println("Inside Method");
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		       
		}
		catch(Exception ex) 
		{
			System.out.println("Inside Exception");
			return null;
		}
							
	}
	
	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :billing";
		try{
		return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
						.setParameter("userId", userId)
						.setParameter("billing", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Address> listShippingAddresses(int userId) {
  		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :shipping";
		try {
		return sessionFactory .getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("shipping", true)
							.getResultList();
	}
	catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
		
	}

	@Override
	public List<User> listByRole(String role) {
		String selectQuery = "FROM User WHERE role = :role";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("role",role)
							.getResultList();
		}
		catch(Exception ex) 
		{
			return null;
		}
	}


	@Override
	public boolean updateAddress(Address address) {
		try {			
			sessionFactory.getCurrentSession().update(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}	

	@Override
	public User get(int id) {
		try {			
			return sessionFactory.getCurrentSession().get(User.class, id);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Address getAddress(int addressId) {
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean update(User user) {
		try {			
			sessionFactory.getCurrentSession().update(user);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	@SuppressWarnings("deprecation")
	public boolean alreadyExists(String email) {
		List result = sessionFactory.getCurrentSession()
	                         .createQuery("from User where email=:email")
	                         .setParameter("email", email)
	                         .list();
	    return !result.isEmpty();
	}
	
	@Override
	public boolean getByEmail1(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
		sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		}

	@Override
	public User getByContactNumber(String contactNumber) {
		String selectQuery = "FROM User WHERE contactNumber = :contactNumber";
		try {
			System.out.println("Inside Method");
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("contactNumber",contactNumber)
							.getSingleResult();
		       
		}
		catch(Exception ex) 
		{
			System.out.println("Inside Exception");
			return null;
		}
	}

	@Override
	public String getPasswordByContactNumber(String contactNumber) 
	{
		String selectQuery = " Select password FROM User WHERE contactNumber = :contactNumber";

        @SuppressWarnings("deprecation")
		String usrpassword = (String) session.createQuery(selectQuery).setInteger("id",10).uniqueResult();
		try {
		return usrpassword;
		       
		}
		catch(Exception ex) 
		{
			System.out.println("Inside Exception");
			return null;
		}
		
		
	}

	@Override
	public List<User> listAllUser() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM User" , User.class)
						.getResultList();
	}
							
	}



