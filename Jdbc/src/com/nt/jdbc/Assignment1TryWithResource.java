package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment1TryWithResource 
{
	public static void main(String[] args) 
	{
	
	try(	Scanner sc=new Scanner(System.in);
			//ESTABLISH THE CONNECTION
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			//CREATE THE STATEMENT OBJECT
			Statement st=con.createStatement();){
		
		String deg1=null;
		String deg2=null;
		String deg3=null;
		
		if(sc!=null)
		{
			System.out.println("Enter Employee deg1 :");
			deg1=sc.next().toUpperCase();
			System.out.println("Enter Employee deg2 :");
			deg2=sc.next().toUpperCase();
			System.out.println("Enter Employee deg3 :");
			deg3=sc.next().toUpperCase();
		}
		//convert input values as required for the input
		String cond="('"+deg1+"','"+deg2+"','"+deg3+"')";
		//prepare the sql query
		String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";
		//SEND AND EXECUTE THE SQL QUERY
		try(ResultSet rs=st.executeQuery(query)){
		//process the ResultSet
		if(rs!=null)
		{
			boolean isRSEmpty=true;
			while(rs.next())
			{
				isRSEmpty=false;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			if(isRSEmpty)
				System.out.println("NO RECORD FOUND");
			else
				System.out.println("RECORD FOUND AND DISPLAYED");
				
		}//if
		}//try2
	}//try1
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}//main
}//class
