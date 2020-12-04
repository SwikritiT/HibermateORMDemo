package com.swikriti.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.swikriti.hibernate.entity.Student;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
	 			.configure()
	 			.addAnnotatedClass(Student.class)
	 			.buildSessionFactory();
	 	Session session = factory.getCurrentSession();
	 	try {
	 		session.beginTransaction();
	 		List<Student> students = (List<Student>) session.createQuery("from Student").getResultList();
	 		session.createQuery("DELETE FROM Student WHERE id = 2").executeUpdate();
	 		display(students);
	 		session.getTransaction().commit();
	 	}catch(Exception e) {
	 		e.printStackTrace();
	 	}finally {
	 		factory.close();
	 	}

	}
	public static void display(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}

}
