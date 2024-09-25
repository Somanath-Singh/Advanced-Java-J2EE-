package typesofresultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PsSensitiveRsTest {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement ps=con.prepareStatement("SELECT SNO,SNAME,CITYS,AVG FROM STUDENT2",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();)
		{
			if(rs!=null)
			{
				System.out.println("Record displayed top to bottom.");
				int count=0;
				while(rs.next())
				{
					if(count==0)
					{
						System.out.println("In next 20 sec modify the record db table ");
						Thread.sleep(20000);
					}
					rs.refreshRow();
					count++;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getFloat(4));
				}//while
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

	}

}
