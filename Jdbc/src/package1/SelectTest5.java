package package1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest5 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
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
			String query="SELECT COUNT(*)  FROM EMP";
			System.out.println(query);
			//execute the sql query
			
			if(st!=null)
			{
				rs=st.executeQuery(query);
			}
			//process the resultset
			
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
