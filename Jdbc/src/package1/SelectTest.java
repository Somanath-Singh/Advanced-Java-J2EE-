package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SelectTest

	{
		public static void main(String[] args)
		{
			    //one type
				/*oracle.jdbc.driver.OracleDriver driver= new oracle.jdbc.driver.OracleDriver();
				DriverManager.registerDriver(driver);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");*/
				//2nd type
			   /*Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");*/
				//3rd type (modern method)
				/*Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");*/

				//establish the connection
			try
			{
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
					
				if(con==null)
				{
					System.out.println("Connection isnot Established");
				}
				else
				{
					System.out.println("Connection is Established");
				}	
				//create jdbc statement object
				Statement st=con.createStatement();
				//send and execute the SELECT sql querry to DB s/w
                st.executeUpdate("CREATE TABLE STUDENT4(SNO NUMBER(5) PRIMARY KEY,SNAME VARCHAR2(20),SADD VARCHAR2(20),AVG FLOAT)");
                System.out.println("table created.");
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
				}
	}

