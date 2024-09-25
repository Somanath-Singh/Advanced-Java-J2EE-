package package1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

public class InsertTest {
	
		public static void main(String[] args) {
		  
			Scanner sc=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			
			try{
				sc=new Scanner(System.in);
				int Sno=0;
				String sname=null;
				int srollno=0;
				int age=0;
				String pro_lang=null;
				int mark=0;
				String job=null;
				int sal=0;
				if(sc!=null)
				{
					System.out.println("Enter Student  Sno:");
					Sno=sc.nextInt();
					//THIS METHOD IS USED BECAUSE OF GOING TO NEXT LINE
					sc.nextLine();
					System.out.println("Enter Student sname:");
					sname=sc.nextLine();
					System.out.println("Enter Student srollno:");
					srollno=sc.nextInt();
					System.out.println("Enter Student  age:");
					age=sc.nextInt();
					System.out.println("Enter Student pro_lang:");
					pro_lang=sc.next();
					System.out.println("Enter Student mark:");
					mark=sc.nextInt();
					System.out.println("Enter Student job:");
					job=sc.next();
					System.out.println("Enter Student sal:");
					sal=sc.nextInt();
				}
				
				//convert the input values as required for the sql query
				sname="'"+sname+"'";
				pro_lang="'"+pro_lang+"'";
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
				String query="INSERT INTO STUDENT VALUES("+Sno+","+sname+","+srollno+","+age+","+pro_lang+","+mark+","+job+","+sal+")";
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
