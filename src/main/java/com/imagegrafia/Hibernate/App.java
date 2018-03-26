package com.imagegrafia.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.imagegrafia.model.Address;
import com.imagegrafia.model.Employee;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")// optional by default it will
																							// search by this name
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {

			/*Address add1 = new Address();
			add1.setCity("CUttcak");
			add1.setState("Odisha");
			Address add2 = new Address();
			add2.setCity("CUttcak1");
			add2.setState("Odisha1");
			Address add3 = new Address();
			add3.setCity("CUttcak2");
			add3.setState("Odisha2");

			Employee emp = new Employee();
			emp.setName("Surila");

			emp.getListOfAddress().add(add1);
			emp.getListOfAddress().add(add2);
			emp.getListOfAddress().add(add3);
*/
			session.beginTransaction();
			Employee empl=session.get(Employee.class,1);
			
			session.close();
			/**
			 * example of proxy class 
			 * When there is object or collection of object in 
			 * an entity class BY DEFAULT HINERNATE WILL NOT FETCH 
			 * such object (by default its lazy type only 1st level of member
			 *  var will initialize i.e parent and composition will not)
			 */
			System.out.println(empl.getListOfAddress().size());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception arised @" + e);
		} finally {
			
			sessionFactory.close();
		}
	}

}
