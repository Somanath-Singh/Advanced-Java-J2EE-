package postgresql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectTestPostgresql {
	
	private final static String GET_PRODUCT_DATA="SELECT * FROM PRODUCT";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","somanath");
			PreparedStatement ps=con.prepareStatement(GET_PRODUCT_DATA);
			ResultSet rs=ps.executeQuery();)
			{
			if(rs!=null)
			{
				while(rs.next())
				{
					int no=rs.getInt(1);
					String name=rs.getString(2);
					float price=rs.getFloat(3);
					float qty=rs.getFloat(4);
					System.out.println(no+" "+name+" "+price+" "+qty);
				}
			}
			
			}
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
