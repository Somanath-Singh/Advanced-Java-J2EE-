package metedataINjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCapabilitiesTest {

	public static void main(String[] args) {
		
		try(//oracle
			//Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		    //mysql
			//Connection con =DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
			//postgersql
			Connection con =DriverManager.getConnection("jdbc:postgresql:///NTAJ415DB","postgres","somanath");)
		{
			if(con!=null) {
				//DatabaseMetaDAta doesn't support try with resources 
				DatabaseMetaData dbmd=con.getMetaData();
				if(dbmd!=null) {
					System.out.println("DB s/w name::"+dbmd.getDatabaseProductName());
					System.out.println("DB s/w version::"+dbmd.getDatabaseProductVersion());
					System.out.println("SQL keywards::"+dbmd.getSQLKeywords());
					System.out.println("Numeric functions::"+dbmd.getNumericFunctions());
					System.out.println("Max characters in db table name::"+dbmd.getMaxTableNameLength());
					System.out.println("Max connerction allowed::"+dbmd.getMaxConnections());
					System.out.println("Support stored procedure??::"+dbmd.supportsStoredProcedures());
					System.out.println("max row size::"+dbmd.getMaxRowSize());
					System.out.println("Max characters in username::"+dbmd.getMaxUserNameLength());
					System.out.println("Max col counts in Db tables::"+dbmd.getMaxColumnsInTable());
					
				}//if
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
