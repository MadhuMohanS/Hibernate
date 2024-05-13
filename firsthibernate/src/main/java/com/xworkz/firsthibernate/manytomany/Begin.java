package com.xworkz.firsthibernate.manytomany;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Begin {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session= factory.openSession();
	
	Employee employee=new Employee();
	employee.setEmployeeId(101);
	employee.setName("Madhu");
	
	Project project=new Project();
	project.setProjectId(10);
	project.setProjectName("chatbot");
	
	Employee employee1=new Employee();
	employee1.setEmployeeId(102);
	employee1.setName("Mohan");
	
	Project project1=new Project();
	project1.setProjectId(11);
	project1.setProjectName("Bike game");
	
	List<Employee> employees=new ArrayList<Employee>();
	List<Project> projects=new ArrayList<Project>();
	
	employees.add(employee);
	employees.add(employee1);
	projects.add(project);
	projects.add(project1);
	
	employee.setProjects(projects);
	project.setEmps(employees);
	
	
	Transaction tx =session.beginTransaction();
	session.save(employee);
	session.save(employee1);
	
	session.save(project);
	session.save(project1);
	
	System.out.println("data successfully inserted");
	tx.commit();
	factory.close();
}
}
