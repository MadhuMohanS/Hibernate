package com.xworkz.firsthibernate.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@Column(name="e_id")
private int employeeId;
private String name;
@ManyToMany
@JoinTable(name="emp_learn",joinColumns = {@JoinColumn(name="e_id")},inverseJoinColumns = {@JoinColumn(name="p_id")})
private List<Project> projects;
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getName() {
	return name;
}
public Employee() {
	System.out.println("running no-arg constructor of employee");
}
public Employee(int employeeId, String name, List<Project> projects) {
	super();
	this.employeeId = employeeId;
	this.name = name;
	this.projects = projects;
}
public void setName(String name) {
	this.name = name;
}
public List<Project> getProjects() {
	return projects;
}
public void setProjects(List<Project> projects) {
	this.projects = projects;
}

}
