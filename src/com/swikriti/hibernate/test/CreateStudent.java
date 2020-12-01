package com.swikriti.hibernate.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.swikriti.hibernate.entity.Student;

public class CreateStudent {
 public static void main(String[] args) {
	 	SessionFactory factory = new Configuration()
	 			.configure("hibernate.cfg.xml")
	 			.addAnnotatedClass(Student.class)
	 			.buildSessionFactory();
	 	Session session = factory.getCurrentSession();
	 	Student student = new Student("Ginny","pokhara","ginny@email.com");
		Student student1 = new Student("Harry","pokhara","harry@email.com");
	 	session.beginTransaction();
	 	session.save(student);
	 	session.save(student1);
	 	session.getTransaction().commit();
	 	factory.close();
}
}
