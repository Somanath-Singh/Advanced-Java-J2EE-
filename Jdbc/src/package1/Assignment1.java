/*package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Assignment1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try{
			sc=new Scanner(System.in);
			String job=null;
			
			if(sc!=null)
			{
				System.out.println("Enter designation(job) of employee:");
				 job = sc.next();
			}
			//load the jdbc Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			//create the statement object
			if(con!=null)
			{
				st=con.createStatement();
			}
			
			//prepare the sql query
			String query="SELECT EMPNO,ENAME, JOB,SAL FROM EMP WHERE JOB="+"job";
			System.out.println(query);
			//execute the sql query
			
			if(st!=null)
			{
				rs=st.executeQuery(query);
			}
			//process the resultset
			
			if(rs!=null)
			{
				if(rs.next())
				{
					System.out.println("THE EMP DETAILS ARE:");
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				}
				else
				{
					System.out.println("NO RECORD FOUND IN DATABASE");
				}
				
			}//if
		}//try
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
		catch(ClassNotFoundException cnf)
		{
	          cnf.printStackTrace();
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}
		//Best code to close jdbc object
		finally
		{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
		}//try
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
	    try
		{
			if(st!=null)
			{
				st.close();
			}
		}//try
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
		 try
		{
			if(con!=null)
			{
				con.close();
			}
		}//try
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
	  }//finally
		
	}//main
}//class*/
package package1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment1 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			String job1=null;
			String job2=null;
			String job3=null;
			
			if(sc!=null)
			{
				System.out.println("Enter Employee job1 :");
				job1=sc.next();
				System.out.println("Enter Employee job2 :");
				job2=sc.next();
				System.out.println("Enter Employee job3 :");
				job3=sc.next();
			}
			//Load JDBC Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
			
			//Statement Obj
			if(con!=null)
			{
				st=con.createStatement();
			}
			
			//concrete the sql queries
			//SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=7839
			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN('"+job1+"','"+job2+"','"+job3+"')"+"ORDER BY JOB";
			System.out.println(query);
			
			//creating result set
			if(st!=null)
			{
				rs=st.executeQuery(query);
			}
			
			//process the ResultSet
			if(rs!=null)
			{
				boolean isRSEmpty=true;
				while(rs.next())
				{
					isRSEmpty=false;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
				}
				if(isRSEmpty)
					System.out.println("NO RECORD FOUND");
				else
					System.out.println("RECORD FOUND AND DISPLAYED");
					
			}//if
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	   catch(ClassNotFoundException cnf)
	   {
		   cnf.printStackTrace();
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				if(rs!=null)
				rs.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(st!=null)
				st.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(con!=null)
				con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}//finally
		
	}//main

}//Class

	