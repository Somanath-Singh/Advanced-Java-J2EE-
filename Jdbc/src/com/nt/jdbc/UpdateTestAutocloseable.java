package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateTestAutocloseable {
	
		public static void main(String[] args) {
			//AUTO CLOSEABLE METHOD USE NO NEED CLOSE THE JDBC OBJECT IN SEPARATE FINALLY BLOCK
			try(Scanner sc=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
					Statement st=con.createStatement();
					){
				String newname=null ;
				String newcity=null;
				int age=0;
				int sno=0;
				if(sc!=null)
				{
					System.out.println("Enter sno of existing student table");
					sno=sc.nextInt();
					//THIS METHOD IS USED BECAUSE OF GOING TO NEXT LINE
					sc.nextLine();
					System.out.println("Enter new student name:");
					newname=sc.nextLine();
					System.out.println("Enter student newcity:");
					newcity=sc.next();
					System.out.println("Enter student new age:");
					age=sc.nextInt();
				}
				
				//convert the input values as required for the sql query
				newname="'"+newname+"'";
				newcity="'"+newcity+"'";
			
				//prepare the sql query
				//UPDATE STUDENT SET SNAME='SOMANATH SINGH',CITY='BENGALOR',AGE=25 WHERE SID=8;
				String query="UPDATE STUDENT SET SNAME="+newname+","+"CITY="+newcity+","+"AGE="+age+" WHERE SNO="+sno;
				System.out.println(query);
				//execute the sql query
				
				int count=0;
				if(st!=null)
				{
					count=st.executeUpdate(query);
				}
				//process the resultset
				
				if(count==0)
				{
					System.out.println("PROBLEM FOUND IN UPDATION");
				}
				else
				{
					System.out.println(count+" RECORD UPDATED WITH NEW VALUES");
				}
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
