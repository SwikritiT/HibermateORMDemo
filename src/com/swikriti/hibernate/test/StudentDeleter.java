package com.swikriti.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.swikriti.hibernate.entity.Student;

public class StudentDeleter {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
	 			.configure()
	 			.addAnnotatedClass(Student.class)
	 			.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
	 	
	 	
	 		session.beginTransaction();
	 		Student student = session.get(Student.class,1);
	 		session.delete(student);
	 		session.getTransaction().commit();
	 	}catch(Exception e) {
	 		e.printStackTrace();
	 	}finally {
	 		factory.close();
	 	}

	}

}
