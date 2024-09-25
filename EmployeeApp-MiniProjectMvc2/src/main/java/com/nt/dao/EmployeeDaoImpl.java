package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB=?";
	
	@Override
	public List<Employee> getAllEmployeesByDesg(String desg)throws Exception {
		
		List<Employee> list=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//WRIGHT the jdbc code
		try {
			//load the jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
			//create prepared statement object
			 ps=con.prepareStatement(GET_EMPS_QUERY);
			//set the value to query param
			ps.setString(1, desg);
			//send and execute the sql query
			rs=ps.executeQuery();
			
			//process the resultset object to copy record to List<Employee> object
			list=new ArrayList<Employee>();
			while(rs.next()) {
				
				//copy each record to java bean class object
				
				Employee emp= new Employee();
				emp.setEno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				//add "emp" object to the List collection
				list.add(emp);
				
			}//while
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;//Exception propagation
		}
		catch(Exception se) {
			se.printStackTrace();
			throw se;//Exception propagation
		}
		finally {
			//close the jdbc object
			try {
				if(con!=null) 
					con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			//close the jdbc object
			try {
				if(ps!=null) 
					ps.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		//close the jdbc object
		try {
			if(rs!=null) 
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		return list;
	}

}
