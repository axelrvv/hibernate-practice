package com.axel.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.axel.hibernate.practice.entity.Employee;

public class EmployeeService {
	
	public void createEmployee(Employee employee) {
		
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
			
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
			
		}
			
	}
	
	public List<Employee> getAllEmployees(){
		
		List<Employee> allEmployees = null;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			allEmployees = session.createQuery("from Employee").getResultList();
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
			
		}
		
		return allEmployees;
	}
	
	public List<Employee> getAllEmployeesByCompany(String company){
		
		List<Employee> allEmployees = null;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			allEmployees = session.createQuery("from Employee e where e.company = '"+company+"'").getResultList();
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
			
		}
		
		return allEmployees;
	}
	
	public Employee getEmployeeById(int Id) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Employee employee = null;
		
		try {
			
			session.beginTransaction();
			employee = session.get(Employee.class, Id);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
			
		}
		
		return employee;
	}
	
	public void updateEmployeeFirstname(int Id, String firstname) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Employee employee = session.get(Employee.class,Id);
			employee.setFirstname(firstname);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
		}
		
	}
	
public void updateEmployeeLastname(int Id, String lastname) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Employee employee = session.get(Employee.class,Id);;
			
			employee.setLastname(lastname);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			factory.close();
		}
		
	}

public void updateEmployeeCompany(int Id, String company) {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();
	
	try {
		
		session.beginTransaction();
		Employee employee = session.get(Employee.class,Id);
		
		employee.setLastname(company);
		session.getTransaction().commit();
		
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}finally {
		
		factory.close();
	}
	
}

public Employee deleteEmployee(int Id) {
	
	Employee employee = null;
	
	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try {
		
		session.beginTransaction();
		employee = getEmployeeById(Id);
		session.delete(employee);
		session.getTransaction().commit();
		
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}finally {
		
		factory.close();
		
	}
	
	return null;
}

}
