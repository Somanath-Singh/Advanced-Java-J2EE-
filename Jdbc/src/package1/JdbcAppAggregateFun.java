package package1;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;


public class JdbcAppAggregateFun {
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
				
				//1
				//prepare the sql query1
				String query1="SELECT COUNT(*)  FROM EMP";
				System.out.println(query1);
				//execute the sql query
				
				if(st!=null)
				{
					rs=st.executeQuery(query1);
				}
				//process the resultset
				
				if(rs!=null)
				{
					rs.next();
						//System.out.println("THE EMP DATABASE TABLE RECORDS CONTAINS:::"+rs.getInt("COUNT(*)"));
	                     //OR
						System.out.println("THE EMP DATABASE TABLE RECORDS CONTAINS:::"+rs.getInt(1));
				}//if
				
				//close the 1st resultset
				rs.close();
				
				//2
				//prepare the sql query
				String query2="SELECT MAX(SAL)  FROM EMP";
				System.out.println(query2);
				//execute the sql query
				
				if(st!=null)
				{
					rs=st.executeQuery(query2);
				}
				//process the resultset
				
				if(rs!=null)
				{
					rs.next();
						System.out.println("THE EMP DATABASE TABLE MAX OF ALL SAL::"+rs.getInt(1));
				}//if
				
				//close the 2nd resultset
				rs.close();
				
				//3
				//prepare the sql query
				String query3="SELECT MIN(SAL)  FROM EMP";
				System.out.println(query3);
				//execute the sql query
				
				if(st!=null)
				{
					rs=st.executeQuery(query3);
				}
				//process the resultset
				
				if(rs!=null)
				{
					rs.next();
						System.out.println("THE EMP DATABASE TABLE MIN OF  SAL::"+rs.getInt(1));
				}//if
				
				//close the 3rd resultset
				rs.close();
				
				//4
				//prepare the sql query
				String query4="SELECT AVG(SAL)  FROM EMP";
				System.out.println(query4);
				//execute the sql query
				
				if(st!=null)
				{
					rs=st.executeQuery(query4);
				}
				//process the resultset
				
				if(rs!=null)
				{
					rs.next();
						System.out.println("THE EMP DATABASE TABLE AVG OF ALL SAL::"+rs.getInt(1));
				}//if
				
				//close the 4th resultset
				rs.close();
				
				//5
				//prepare the sql query
				String query5="SELECT SUM(SAL)  FROM EMP";
				System.out.println(query5);
				//execute the sql query
				
				if(st!=null)
				{
					rs=st.executeQuery(query5);
				}
				//process the resultset
				
				if(rs!=null)
				{
					rs.next();
						System.out.println("THE EMP DATABASE TABLE SUM OF ALL SAL::"+rs.getInt(1));
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