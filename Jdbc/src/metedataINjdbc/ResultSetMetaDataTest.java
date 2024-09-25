package metedataINjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest {
	
	private final static String SELECT_SQL_QUERY="SELECT * FROM STUDENT";

	public static void main(String[] args) {
	
		try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement ps=con.prepareStatement(SELECT_SQL_QUERY);
				ResultSet rs=ps.executeQuery();)
		{
			ResultSetMetaData rsmd=null;
			if(rs!=null)
			{
				rsmd=rs.getMetaData();
			}
			if(rsmd!=null && rs!=null)
			{
				int colCount=rsmd.getColumnCount();
				for(int i=1;i<=colCount;++i)
				{
					System.out.print(rsmd.getColumnName(i)+"("+rsmd.getColumnTypeName(i)+")\t");
				}
				System.out.println();
				
				while(rs.next())//it access each record of resultset
				{
					for(int i=1;i<=colCount;++i)//it is goes through column of each record
					{
						System.out.print(rs.getString(i)+"\t\t");
					}
					System.out.println();
					//this way we can also print the table record 
					//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9));
				}
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
