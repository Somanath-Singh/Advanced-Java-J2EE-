package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDao {

	public List<Employee> getAllEmployeesByDesg(String desg) throws Exception;
}
