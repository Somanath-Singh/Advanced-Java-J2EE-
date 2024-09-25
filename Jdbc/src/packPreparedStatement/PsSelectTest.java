package packPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelectTest {
	private final static String STUDENT_INSERT_QUERY="INSERT INTO STUDENT2 VALUES(?,?,?,?)";
	
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in);
				//establish the connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				//create preparedstatement having precompiled sql query
				PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY);
				)
		{
			int count=0;
			if(sc!=null)
			{
				System.out.println("Enter student counts:");
				count=sc.nextInt();
			}
			
			if(sc!=null && ps!=null)
			{
				for(int i=1;i<=count;i++)
				{
				   System.out.println("Enter "+i+" student details:");
				   System.out.println("Enter student no:");
				   int sno=sc.nextInt();
				   System.out.println("Enter student name:");
				   sc.nextLine();
				   String name=sc.nextLine();
				   System.out.println("Enter student adds:");
				   String sadd=sc.next();
				   System.out.println("Enter student avg:");
				   float avg=sc.nextFloat();
				   
				   //set each student details to pre-compiled sql query param values(?)
				   ps.setInt(1,sno);
				   ps.setString(2,name);
				   ps.setString(3, sadd);
				   ps.setFloat(4, avg);
				   
				   //create the result statement (execute the query)
				   int result=ps.executeUpdate();
				   
				   //process the result 
				   
				   if(result==0)
				   System.out.println(i+"student record is not inserted.");
				   else
					   System.out.println(i+"student record is inserted.");
				}//for
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
