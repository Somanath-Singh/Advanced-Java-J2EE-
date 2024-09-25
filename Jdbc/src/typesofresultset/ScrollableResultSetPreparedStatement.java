package typesofresultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollableResultSetPreparedStatement {

	public static void main(String[] args)
	{
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				PreparedStatement ps=con.prepareStatement("SELECT * FROM STUDENT", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=ps.executeQuery();)
		{
			if(rs!=null) 
			{
				System.out.println("Record displayed top to buttom");
				System.out.println("=====================================================");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				}
				System.out.println("=====================================================");
				rs.afterLast();
				
				System.out.println("Record display bottom to top");
				System.out.println("=====================================================");
				while(rs.previous())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				}
				System.out.println("=====================================================");
				//Display  record randomly or directly
				System.out.println("Display record randomly or directly");
				rs.first();
				System.out.println(rs.getInt(1)+" ---------------"+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				rs.last();
				System.out.println(rs.getInt(1)+" ---------------"+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				rs.absolute(3);
				System.out.println(rs.getInt(1)+" ---------------"+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				rs.absolute(4);
				System.out.println(rs.getInt(1)+"----------------- "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				rs.relative(2);
				System.out.println(rs.getInt(1)+" -----------------"+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				rs.relative(-4);
				System.out.println(rs.getInt(1)+" ------------------"+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				System.out.println("=====================================================");
				
			}
			
		}
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