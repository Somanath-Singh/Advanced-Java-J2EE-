package postgresql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTestPostgresql {
	
	private final static String INSERT_PRODUCT_DATA_QUERY="INSERT INTO PRODUCT VALUES(NEXTVAL('PID_SEQUENCE'),?,?,?)";

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","somanath");
			PreparedStatement ps=con.prepareStatement(INSERT_PRODUCT_DATA_QUERY);)
			{
			 
			//get the input values
			String pname=null;
			float price=0.0f;
			float qty=0.0f;
			
			if(sc!=null)
			{
				System.out.println("Enter product name:");
				pname=sc.next();
				System.out.println("Enter product price:");
				price=sc.nextFloat();
				System.out.println("Enter product quantity:");
				qty=sc.nextFloat();
			}
			//set the values to query param
			
			if(ps!=null)
			{
				ps.setString(1, pname);
				ps.setFloat(2, price);
				ps.setFloat(3, qty);
				
				//Execute the pre compiles sql query
				
				int count=ps.executeUpdate();
				
				//process the resultset
				if(count==0)
					System.out.println("record not inserted.");
				else
					System.out.println("record inserted");
					
			}//if
			}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
