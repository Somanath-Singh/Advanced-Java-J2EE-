package com.employee;

import java.util.Scanner;

public class Main {

	EmployeeService service=new EmployeeService();
	static boolean ordering=true;
	public static void menu() {
		System.out.println("*******************************welcome to Employee Management system Application****************************************"
				                                     +"\n 1.Add Employee "
				                                     +"\n 2.View Employee"
				                                     +"\n 3.Update Employee"
				                                     +"\n 4.Delete Employee"
				                                     +"\n 5.View all Employee"
				                                     +"\n 6.Exit");
	}
	public static void main(String[] args) {
	
		//use of Scanner class
		Scanner sc=new Scanner(System.in);
		
		//create the object of EmployeeService class to access all the methods present in this class
		EmployeeService service=new EmployeeService();
		
		do {
			//call the menu() method
			menu();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
			switch(choice) {
			case 1:
				System.out.println("Add Employee:"); 
				service.addEmp();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 2:
				System.out.println("View Employee:");
				service.viewEmp();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("Update Employee:");
				service.updateEmployee();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 4:
				System.out.println("Delete Employee:");
				service.deletEmp();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break; 
			case 5:
				System.out.println("view all Employee:");
				service.viewAllEmps();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 6:
				System.out.println("*************************************Thank you for using application!!***************************************");
				System.exit(0);
				break;
				
			default:
				System.out.println("please enter valid choice");
			}
			
		}while(ordering);

		sc.close();
	}

}
