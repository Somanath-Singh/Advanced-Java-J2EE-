package com.nt.service;

import java.util.List;

import com.nt.model.Employee;


	public interface IEmployeeMgmtService{
		
		public List<Employee> showEmployeeDesg(String desg)throws Exception;
}
  