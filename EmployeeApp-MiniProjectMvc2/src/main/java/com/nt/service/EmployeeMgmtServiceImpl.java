package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDaoImpl;
import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

public class EmployeeMgmtServiceImpl  implements IEmployeeMgmtService  {

	private IEmployeeDao empDAO=null;
	
	public EmployeeMgmtServiceImpl() {
		empDAO=new EmployeeDaoImpl();
	}

	@Override
	public List<Employee> showEmployeeDesg(String desg)throws Exception {

		//use DAO
		List<Employee> list=empDAO.getAllEmployeesByDesg(desg);
		//calculate the Gross and net salary
		for(Employee emp:list) {
			float grossSalary=(float) (emp.getSalary()+emp.getSalary()*0.4);
			float netgrossSalary=grossSalary-(grossSalary*0.2f);
			//set the value into Employee class
			emp.setGrossSalary(grossSalary);
			emp.setNetSalary(netgrossSalary);
		}
		System.out.println("List collection data::"+list);
		
		return list;
	}
}
