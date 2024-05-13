package com.xworkz.firsthibernate.hql;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.firsthibernate.Student;

public class HqlExample {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session= factory.openSession();
	String query="from Student where city=:x and name=:n";
	
	Query q= session.createQuery(query);
	q.setParameter("x", "davangere");
	q.setParameter("n", "Madhu");
	List<Student> list= q.list();
	for(Student s:list) {
		System.out.println(s.getName());
		System.out.println(s.getCerti().getCourse());
		System.out.println(s.getCity());
		System.out.println(s.getId());
	}
	
	System.out.println("---------------------------------");
	
	Transaction tx= session.beginTransaction();
//	String deleteQuery="delete from Student where name=:x";
//	Query q2= session.createQuery(deleteQuery);
//	q2.setParameter("x", "Mohan");
//	
//	int r =q2.executeUpdate();
//	System.out.println("no of deleted rows are:"+r);
	
	String query2="update Student set course=:x where name=:y";
	Query q2= session.createQuery(query2);
	q2.setParameter("x", "Data science");
	q2.setParameter("y","Madhu");
	int executeUpdate = q2.executeUpdate();
	System.out.println("no of rows got updated are:"+executeUpdate);
	tx.commit();
	factory.close();
}
}
