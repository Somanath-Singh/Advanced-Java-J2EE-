package datatime.nt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class PersoneAgeCalculater_javalogic {

	private final static String GET_DOB_BY_CNO="SELECT DOB FROM CUSTOMER_INFO WHERE CNO=?";
	
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement ps=con.prepareStatement(GET_DOB_BY_CNO);
				Scanner sc=new Scanner(System.in);)
		{
			//read input values
			int cno=0;
			if(sc!=null)
			{
				System.out.println("Enter cno of present in oracle db:");
				cno=sc.nextInt();
			}
			//set the values to query param
			if(ps!=null)
			{
				ps.setInt(1, cno);
			}
			//process the result set and pre compiled query
			try(ResultSet rs=ps.executeQuery();)
			{
			
			if(rs!=null)
			{
				if(rs.next())
				{
					java.util.Date udob=rs.getDate(1);
					java.util.Date sysDate=new Date();
					long ageinMs=sysDate.getTime()-udob.getTime();
					System.out.println("person age is:"+(ageinMs/(1000.0f*60.0f*60.0f*24.0f*365.25f)));
				}
				else
				{
					System.out.println("customer age not found:");
				}
			}//if
			
			}//try2
		}//try1
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}
		

	}

}
