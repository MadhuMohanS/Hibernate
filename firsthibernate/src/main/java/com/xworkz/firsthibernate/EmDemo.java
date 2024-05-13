package com.xworkz.firsthibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
public static void main(String[] args) {
	
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session= factory.openSession();
	Transaction tx= session.beginTransaction();
	
	Student student=new Student();
	student.setId(102);
	student.setName("Faraz");
	student.setCity("davangere");
	
	Certificate certificate=new Certificate();
	certificate.setCourse("java");
	certificate.setDuration("2hours");
	
	student.setCerti(certificate);
	
	session.save(student);
	System.out.println("data successfully entered");
	tx.commit();
}
}
