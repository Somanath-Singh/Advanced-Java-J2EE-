package packPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsAssignment2 {

	private final static String UPDATE_AVG_STUDENT="UPDATE STUDENT2 SET AVG=(AVG+(AVG/100)*10) WHERE(CITES=? OR CITES=?) AND AVG<90.00";
	
	public static void main(String[] args) {
		try(  Scanner sc=new Scanner(System.in);
				Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				//create prepared statement to execute pre-compile query
				PreparedStatement ps=con.prepareStatement(UPDATE_AVG_STUDENT);)
	         	{
			//get inputs
			String add1=null;
			String add2=null;
			if(sc!=null)
			{
				System.out.println("Enter Address of student 1 whose avg you want to update::");
				add1=sc.next();
				System.out.println("Enter Address of student 2 whose avg you want to update::");
				add2=sc.next();
			}
			
			 //set each student details to pre-compiled sql query param values(?)
			ps.setString(1, add1);
			ps.setString(2, add2);
			
			//create resultset
			
			int count=ps.executeUpdate();
			
			if(count==0)
			{
				System.out.println("NO RECORD UPDATED.");
			}
			else
			{
				System.out.println(count+" RECORD UPDATED.");
			}
	       }//TRY
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
