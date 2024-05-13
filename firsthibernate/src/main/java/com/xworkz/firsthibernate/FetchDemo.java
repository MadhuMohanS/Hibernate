package com.xworkz.firsthibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class FetchDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	 Student student = session.get(Student.class, 102);
	 System.out.println(student);
	
}
}
