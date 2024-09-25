package package1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectTrial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Class.forName("oracle.jdbc.Driver.OracleDriver");
			//oracle.jdbc.driver.OracleDriver driver=oracle.jdbc.driver.OracleDriver();
			//DriverManager.registerDriver(driver);
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			if(con==null)
			{
				System.out.println("Connection isnot Established");
			}
			else
			{
				System.out.println("Connection is Established");
			}	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

	}
