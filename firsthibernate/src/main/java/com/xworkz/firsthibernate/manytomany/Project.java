package com.xworkz.firsthibernate.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@Column(name="p_id")
private int projectId;
private String projectName;
@ManyToMany(mappedBy = "projects")
private List<Employee> emps;
public Project() {
	System.out.println("running no-arg constructor of project");
}
@Override
public String toString() {
	return "Project [projectId=" + projectId + ", projectName=" + projectName + ", emps=" + emps + "]";
}
public Project(int projectId, String projectName, List<Employee> emps) {
	super();
	this.projectId = projectId;
	this.projectName = projectName;
	this.emps = emps;
}
public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public List<Employee> getEmps() {
	return emps;
}
public void setEmps(List<Employee> emps) {
	this.emps = emps;
}
}
