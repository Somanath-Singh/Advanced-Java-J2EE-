package metedataINjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest1 {
	
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
					System.out.print("column count:"+i);
					System.out.println("column name:"+rsmd.getColumnLabel(i));
					System.out.println("column type:"+rsmd.getColumnTypeName(i));
					System.out.println("column display size:"+rsmd.getPrecision(i));
					System.out.println("column scale value:"+rsmd.getScale(i));
					System.out.println("column is nullable??:"+rsmd.isNullable(i));
					System.out.println("column is signed??:"+rsmd.isSigned(i));
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
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
