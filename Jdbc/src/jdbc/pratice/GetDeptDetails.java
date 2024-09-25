package jdbc.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDeptDetails {

	public static void main(String args[]) throws Exception {
		//load tht jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
		//create the statement object
		Statement st=con.createStatement();
		//create the resultset object
		ResultSet rs=st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL FROM EMP");
		
		while(rs.next()!=false) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getLong(4));
		}
		rs.close();
		st.close();
		con.close();
		
	}
}
