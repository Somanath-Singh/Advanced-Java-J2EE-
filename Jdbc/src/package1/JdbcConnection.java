package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
			{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		
		Statement smt=con.createStatement();
		
		smt.executeUpdate("create table emp(eno number,ename varchar(15),esal number)");
		System.out.println("Table created successfully...");
		con.close();
			}
		catch(Exception e)
			{
     		System.out.println(e);
			}
	}

}
