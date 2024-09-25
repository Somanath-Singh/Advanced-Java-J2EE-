package package1;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


class SelectTest3
{
	public static void main(String[] args) 
	{
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try
	{
		//read i/ps
		sc=new Scanner(System.in);
		String initchars=null;
		
		if(sc!=null)
		{
			System.out.println("enter initial chars of employee name");
			initchars=sc.next();
		}//if
			//convert input values as required for the SQL querys
			initchars= "'"+initchars+"%' ";//gives s%
	
		//load jdbc Driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		
		//create the statement object
		if(con!=null)
		{
			 st=con.createStatement();
		}//if
			 //prepare the sql query
			 String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME  LIKE"+initchars+"ORDER BY JOB";
			 
			 //execute the SQL QUERY
		if(st!=null)
		{
				rs=st.executeQuery(query);
		}//if
		
		//process the resultSet
		if(rs!=null)
		{
			boolean isRsEmpty=true;
				while(rs.next())//it is an improvised method//while(rs.next()!=false)
				{
					isRsEmpty=false;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
				}//while
				if(isRsEmpty==true)
			    {
					System.out.println("No Record Found");
			    }
				else
			   {
					System.out.println("Record Found And Display");
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
}//class
