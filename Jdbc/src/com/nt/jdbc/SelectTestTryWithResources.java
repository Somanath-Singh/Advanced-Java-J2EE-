package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SelectTest5 

public class SelectTestTryWithResources{

		public static void main(String[] args) {
		
			try(//establish the connection
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
					//CREATE THE STATEMENT OBJECT
					Statement st=con.createStatement();
					//EXECUTE THE SQL QUERY
					ResultSet rs=st.executeQuery("SELECT COUNT(*)  FROM EMP"))	{
	
				if(rs!=null)
				{
					rs.next();
						//System.out.println("THE EMP DATABASE TABLE RECORDS CONTAINS:::"+rs.getInt("COUNT(*)"));
	                     //OR
						System.out.println("THE EMP DATABASE TABLE RECORDS CONTAINS:::"+rs.getInt(1));
				}//if
			}//try
			catch (SQLException se)
			{
		          se.printStackTrace();
			}
			catch (Exception e)
			{
		          e.printStackTrace();
			}
		}//main
	}//class
