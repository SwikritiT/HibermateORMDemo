package com.swikriti.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.swikriti.hibernate.entity.Student;

public class StudentReader {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
	 			.configure()
	 			.addAnnotatedClass(Student.class)
	 			.buildSessionFactory();
	 	Session session = factory.getCurrentSession();
	 	session.beginTransaction();
	 	Student student = session.get(Student.class,1);
	 	System.out.println(student);
	 	session.getTransaction().commit();
	 	factory.close();

	}

}
