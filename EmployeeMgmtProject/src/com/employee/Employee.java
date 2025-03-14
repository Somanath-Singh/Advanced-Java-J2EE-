package com.employee;

public class Employee {
  
	private int id;
	private String name;
	private int age;
	private String designation;
	private String department;
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDept() {
		return department;
	}
	public void setDept(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
public String toString() {
	return "Employee [id=" + id + ", name=" + name  +  " ,  age=" +  age  + ",  designamtion=" +  designation + ", department=" +  department  + ",salary=" +  salary + "]"; 
}

public Employee(int id, String name, int age , String designation,String department,double salary  ) {
	//call the parent class constructor
	this.id=id;
	this.name = name;
	this.age = age;
	this.designation = designation;
	this.department = department;
	this.salary = salary;
     }
		
}
