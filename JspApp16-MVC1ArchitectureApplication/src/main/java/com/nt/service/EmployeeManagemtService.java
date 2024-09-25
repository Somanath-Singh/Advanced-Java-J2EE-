package com.nt.service;

import com.nt.model.Employee;

public class EmployeeManagemtService {

	//zero param constructor
			public EmployeeManagemtService() {
				System.out.println("EmployeeManagemtService:: 0param constructor");
			}
			
	public void generatePaySlip(Employee emp) {
		
		
		//calculate gross salary and net salary
		double grossSalary=emp.getSalary()+(emp.getSalary()*0.4);
		double netSalary=grossSalary-(grossSalary*0.2);
		
		//set grossSalary and netSalary to Employee class object
		
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
		
	}
}
