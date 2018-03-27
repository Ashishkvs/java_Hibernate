package com.imagegrafia.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.imagegrafia.model.Student;
import com.imagegrafia.model.Vehicle;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")// optional by default it will
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			Vehicle vehicle=new Vehicle();
			vehicle.setName("BMW2");
			
			Vehicle vehicle2=new Vehicle();
			vehicle2.setName("AUdi");
			
			Student student = new Student();
			student.setName("Rahul2");
			
			student.getListofVehicle().add(vehicle);
			student.getListofVehicle().add(vehicle2);
			
			session.beginTransaction();
			
		/**
		 * we have to persist seperately child object along with parent
		 *  object other wise exception will arise
		 */
			session.save(student); 
			session.save(vehicle);
			session.save(vehicle2); //NOTE THIS
			
			
			
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
