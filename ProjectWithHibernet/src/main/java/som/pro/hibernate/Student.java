package som.pro.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

//we created this class because we tell the hibernate to treate this class as entity in database to create table
//this anotation is used to use this class as entity that hibernate can understand i have to use this class as entity
//we can change this entity name using "name" attribute entit name is change student to student_details
//@Entity(name="student_details")

//if you dont't want to change the entyty name and want to create table in different name using table annotation in the use of name attribute
//@Entity
//@Table(name="student_details")


//making any class as Entity
@Entity
public class Student {

	//id is taken as primary key in the table
	//marking any column as primary key
	@Id
	private int id;
	
	private String name;
	
	private String city;
	

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Student() {
		super();
	}

	//getter and setter method
	
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	//create the toString() method to return the present data in Student entity
	@Override
	public String toString() {
		return   id + ":" + name + ":" + city ;
	}

	
}
