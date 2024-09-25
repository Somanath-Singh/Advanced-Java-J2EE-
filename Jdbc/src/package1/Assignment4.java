	package package1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

public class Assignment4 {

		public static void main(String[] args) {
		  
			Scanner sc=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			
			try{
				sc=new Scanner(System.in);
				int empno=0;
				String ename=null;
				String job=null;
				int sal=0;
				if(sc!=null)
				{
					System.out.println("Enter empno:");
					empno=sc.nextInt();
					//THIS METHOD IS USED BECAUSE OF GOING TO NEXT LINE
					sc.nextLine();
					System.out.println("Enter ename:");
					ename=sc.nextLine();
					System.out.println("Enter emp job:");
					job=sc.next();
					System.out.println("Enter emp sal:");
					sal=sc.nextInt();
				}
				
				//convert the input values as required for the sql query
				ename="'"+ename+"'";
				job="'"+job+"'";
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
				//INSERT INTO EMP(EMPNO,ENAME,JOB,SAL)VALUES(7800,'ADVIK','DEVELOPER',2000);
				String query="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL)VALUES("+empno+","+ename+","+job+","+sal+")";
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
					System.out.println("PROBLEM FOUND IN RECORD INSERTION.");
				}
				else
				{
					System.out.println(count+" RECORD INSERTED");
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
