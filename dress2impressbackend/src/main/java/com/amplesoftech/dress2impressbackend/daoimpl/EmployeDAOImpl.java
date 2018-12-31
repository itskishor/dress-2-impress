package com.amplesoftech.dress2impressbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amplesoftech.dress2impressbackend.dao.EmployeeDAO;
import com.amplesoftech.dress2impressbackend.dto.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee get(int empId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Employee.class,Integer.valueOf(empId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public List<Employee> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Employee" , Employee.class)
						.getResultList();
	}

	@Override
	public boolean add(Employee emp) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(emp);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean update(Employee emp) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(emp);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(Employee emp) {
	try {
			
		emp.setEnabled(false);
			// call the update method
			return this.update(emp);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;	
	}

	@Override
	public List<Employee> listActiveEmployee() {
		String selectActiveEmployee = "FROM Employee WHERE enabled = :enabled";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveEmployee, Employee.class)
						.setParameter("enabled", true)
							.getResultList();
	}

	@Override
	public List<Employee> listActiveEmployeeByCategory(int department) {
		String selectActiveEmployeeByCategory = "FROM Employee WHERE enabled = :enabled AND department = :department";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveEmployeeByCategory, Employee.class)
						.setParameter("enabled", true)
						.setParameter("department",department)
							.getResultList();
	}

}
