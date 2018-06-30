package com.mikadosolutions.training.hibernate.onetoonexml;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee 
{
	private static SessionFactory sessionFactory;
	public static void main(String[] args) 
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e)
		{
			throw new ExceptionInInitializerError(e);
		}
		ManageEmployee me = new ManageEmployee();
		
		Integer id1 = me.addEmployee(new Employee("Sanjay", "Makhija", 20000, new MCertificate("BE")));
		System.out.println(id1);
		
		/*Integer id2 = me.addEmployee(new Employee("Sunil", "Kamble", 20000, new MCertificate("BCOM")));
		System.out.println(id2);*/
		
		//me.updateEmployee(1, 2);
		
		/**
		 * Add the certificate only when the Certificate is the owner.
		 */
		/*MCertificate certificate = new MCertificate("BE", new Employee("Sanjay", "Makhija", 10000));
		me.addCertificate(certificate);*/
		
		/*Employee employee1 = me.getEmployee(id1);
		System.out.println(employee1);
		System.out.println("Certificates = " + employee1.getCertificate());*/
		
		me.updateEmployee(id1, new MCertificate("MS"));
		me.deleteEmployee(id1);
		
		System.exit(0);
	}
	
	public Integer addEmployee(Employee employee)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer id = null;
		try
		{
			tx = session.beginTransaction();
			Serializable s = session.save(employee);
			id = (Integer) s;
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return id;
	}
	
	public Employee getEmployee(Integer id1) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Employee employee = null;
		try
		{
			tx = session.beginTransaction();
			employee = (Employee) session.get(Employee.class, id1);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return employee;
	}
	
	public Integer addCertificate(MCertificate certificate)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer id = null;
		try
		{
			tx = session.beginTransaction();
			Serializable s = session.save(certificate);
			id = (Integer) s;
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return id;
	}
	
	public void updateEmployee(Integer empId, Integer certificateId)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empId);
			MCertificate certificate = (MCertificate) session.get(MCertificate.class, certificateId);
			employee.setCertificate(certificate);
			session.update(employee);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
	}
	
	public void updateEmployee(Integer id, MCertificate certificate)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			employee.setCertificate(certificate);
			session.update(employee);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
	}
	
	public void deleteEmployee(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			session.delete(employee);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
	}
}
