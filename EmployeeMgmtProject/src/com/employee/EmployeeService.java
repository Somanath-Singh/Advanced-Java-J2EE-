package com.employee;

import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {

	//create the Hashset
	HashSet<Employee>  empset=new HashSet<Employee>();
	
	Employee emp1=new Employee(101,  "Somanath" , 24  ,  "Developer", "IT" , 25000);
	Employee emp2=new Employee(102,  "Trilochan" , 25  ,  "Testor" , "CO" , 57000);
	Employee emp3=new Employee(103,  "Soumya" , 26  ,  "DevOps", "Admin" , 50000);
	Employee emp4=new Employee(104,  "Stanli" , 23  ,  "System Eng" , "CO" , 70000);
	
	//import Scanner class
	Scanner sc=new Scanner(System.in);
	boolean found=false;
	int choice;
	int id;
	String name;
	int age;
	String department; 
	String designation;
	double salary;
	
	public EmployeeService() {
		empset.add(emp1);
		empset.add(emp2);
		empset.add(emp3);
		empset.add(emp4);
	}
	
	//view  all employees
	public void viewAllEmps() {
		for(Employee emp:empset) {
			System.out.println(emp);
		}
	}//close of viewAllEmp()
	
	//view emp based on there id
	public void viewEmp() {
		//msg for user
		System.out.println("Enter Employee id to see all details:");
		id=sc.nextInt();
		//take foreach loop
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println(emp);
				found=true;
			}//if
		}//foreach
		if(!found) {
				System.out.println("-----------------------------------Employee with this id is not present-----------------------------------");
		}	
	}//close of viewEmp()
	
	
	//update the emp
	
	//User choice Display in console
	public static void choiceMenu() {
		System.out.println("-----------------------Which details you want to modify choose--------------------------"
                +"\n 1.Update Employee Name "
                +"\n 2.Update Employee Age"
                +"\n 3.Update Employee Designation"
                +"\n 4.Update Employee  Department"
                +"\n 5.Update Employee Salary"
                +"\n 6.Exit");
}
//logic for Update the details
	public void updateEmployee() {
		System.out.println("Enter emp id to update:");
		id=sc.nextInt();
		for(Employee emp:empset) {
			if(emp.getId()==id)
			{
				boolean execute=true;
				while(execute) {
					//call the choiceMenu() method
					choiceMenu();
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Enter your choice:");
					 choice=sc.nextInt();
					 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
					switch(choice) {
					case 1:
						System.out.println("Update Employee Name:"); 
						System.out.println("Enter Name:"); 
						name=sc.next();
						emp.setName(name);
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					case 2:
						System.out.println("Update Employee Age:");
						System.out.println("Enter Age:"); 
						age=sc.nextInt();
						emp.setAge(age);
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					case 3:
						System.out.println("Update Employee Designation:");
						System.out.println("Enter Designation:"); 
						designation=sc.next();
						emp.setDesignation(designation);
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					case 4:
						System.out.println("Update Employee Department:");
						System.out.println("Enter Department:"); 
						department=sc.next();
						emp.setDesignation(department);
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					case 5:
						System.out.println("Update Employee Salary:");
						System.out.println("Enter Salary:"); 
						salary=sc.nextDouble();  
						emp.setSalary(salary);
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					case 6:
						System.out.println("There is nothing to update:");
						execute=false;
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
						
					default:
						System.out.println("please enter valid choice");
					}//end of switch		
					found=true;
				}
			}//close of if 
		}//close of forEach	
		if(!found) {
			System.out.println("Employee with this id is not present");
	      }
		else
		{
			System.out.println("================================================Employee details is updated successfully!!=============================================");
			for(Employee emp:empset) {
				if(emp.getId()==id) {
					System.out.println(emp);
				}//if
			}//foreach
		}
		
	}//close of updateEmployee()
	
	
	//delete perticular employee
	public void deletEmp() {
		System.out.println("Enter id");
		id=sc.nextInt();
		Employee empdelete=null;
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				empdelete=emp;
				found=true;
			}
		}
		if(!found) {
			System.out.println("Employee is not present");
		}
		else
		{
			empset.remove(empdelete);
			System.out.println("============================================Employee deleted successfully!!============================================");
		}
	}


//add Employee
void addEmp() {
	System.out.println("Enter id");
	id=sc.nextInt();
	System.out.println("Enter name");
	name=sc.next();
	System.out.println("Enter age");
	age=sc.nextInt();
	System.out.println("Enter designation");
	designation=sc.next();
	System.out.println("Enter department");
	department=sc.next();
	System.out.println("Enter salary");
	salary=sc.nextDouble();
	
	//add these details to Employee HashSet
	Employee emp=new Employee(id , name , age , designation , department , salary);
	empset.add(emp);
	System.out.println(emp);
	System.out.println("=====================================================Employee added successfully!!================================================");
}

}
