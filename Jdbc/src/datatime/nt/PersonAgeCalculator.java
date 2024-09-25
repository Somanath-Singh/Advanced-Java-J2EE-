package datatime.nt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonAgeCalculator {

	private final static String AGE_CALCULATE_QUERY_oracle="SELECT (SYSDATE-DOB)/365.25 FROM CUSTOMER_INFO WHERE CNO=?";
	
	private final static String AGE_CALCULATE_QUERY_mysql="SELECT (DATEDIFF(NOW(),DOB))/365.25 FROM CUSTOMER_INFO WHERE CNO=?";
	
	public static void main(String[] args) {
		
		try(//oracle connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				//mysql cconnection
				Connection con1=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
				//for oracle
				PreparedStatement ps1=con.prepareStatement(AGE_CALCULATE_QUERY_oracle);
				//for mysql
				PreparedStatement ps2=con1.prepareStatement(AGE_CALCULATE_QUERY_mysql);
				Scanner sc=new Scanner(System.in);)
		{
			int ocno=0;
			int mcno=0;
			if(sc!=null)
			{
				System.out.println("Enter cno of customer present in oracle db:");
				ocno=sc.nextInt();
				System.out.println("Enter cno of customer present in mysql db:");
				mcno=sc.nextInt();
			}
			
			//set the values to query param
			if(ps1!=null)
			{
				ps1.setInt(1, ocno);
			}
			if(ps2!=null)
			{
				ps2.setInt(1, mcno);
			}
			
			//process the result set
			try(//oracle resultset
				ResultSet rs1=ps1.executeQuery();
					//mysql resultset
				ResultSet rs2=ps2.executeQuery();)
			 {
				if((rs1!=null)&&(rs2!=null))
			   {
					//oracle db
				if(rs1.next())
				{
					float age1=rs1.getFloat(1);
					System.out.println("Age of Enter customer no in oracle db is:"+age1);
				}
				else
				{
				   System.out.println("customer not foundin oracle db.");
				}
				
				//mysql db
				if(rs2.next())
				{
					float age2=rs2.getFloat(1);
					System.out.println("Age of Enter customer no in mysql db is:"+age2);
				}
				else
				{
				   System.out.println("customer not found inmysql db.");
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
