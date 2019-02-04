package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.amplesoftech.dress2impressbackend.dao.OrderDetailsDAO;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;

@Repository("orderDetailsDAO")
@Transactional
public class OrderDetailsDAOImpl implements OrderDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDetail> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM OrderDetail" , OrderDetail.class)
						.getResultList();
	}

	@Override
	public boolean update(OrderDetail orderDetail) {

		try {
			// update the Transaction Details to the database table
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(OrderDetail orderDetail) {
		orderDetail.setActive(false);
		
		try {
			// Deactivate the Transaction to the database table
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public OrderDetail get(int id) {
		return sessionFactory.getCurrentSession().get(OrderDetail.class, Integer.valueOf(id));
	}

	@Override
	public List<OrderDetail> listActiveTransactions() {

		String selectActiveTransaction = "FROM OrderDetail WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveTransaction, OrderDetail.class)
						.setParameter("active", true)
							.getResultList();
	}

	@SuppressWarnings("deprecation")
	@Override
	public double totalProfit() {
		String query = "Select sum(od.totalRent) FROM OrderDetail od";
		return (double) sessionFactory.getCurrentSession().createQuery(query).list().get(0);
		
	}

}
