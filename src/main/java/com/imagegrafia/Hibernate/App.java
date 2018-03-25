package com.imagegrafia.Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.imagegrafia.model.Address;
import com.imagegrafia.model.UserDetail;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")// optional by default it will
																							// search by this name
				.addAnnotatedClass(UserDetail.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			UserDetail userDetail = new UserDetail();
			Address add = new Address();
			add.setCity("Hyderabad");
			add.setState("Telangana");
			userDetail.setHomeAddress(add);
			Address add2 = new Address();
			add2.setState("Bihar");
			add2.setCity("Saharsa");
			userDetail.setOfficeAddress(add2);
			userDetail.setDescription("User desc");
			userDetail.setJoinedDate(new Date());
			userDetail.setName("Surila Moharana");
			session.beginTransaction();
			session.persist(userDetail);
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception arised @" + e);
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
