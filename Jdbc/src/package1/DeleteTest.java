package package1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

public class DeleteTest {
	
		public static void main(String[] args) {
		  
			Scanner sc=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			
			try{
				sc=new Scanner(System.in);
				int Sno=0;
				if(sc!=null)
				{
					System.out.println("Enter Student t no:");
					Sno=sc.nextInt();
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
				String query="DELETE FROM STUDENT WHERE SNO="+Sno;
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
					System.out.println("NO RECORD FOUND FOR DELETION.");
				}
				else
				{
					System.out.println(count+"NO OF RECORDS ARE FOUND AND DELETED");
				}
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
