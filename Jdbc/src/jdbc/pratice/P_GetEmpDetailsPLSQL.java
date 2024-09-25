package jdbc.pratice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class P_GetEmpDetailsPLSQL {

	private static final String CALL_PROCEDURE="{CALL P_GET_EMP_DET_BY_EMP_NO(?,?,?)}";
	
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE);
				Scanner sc=new Scanner(System.in);)
		{
			int empno=0;
			if(sc!=null) {
				System.out.println("Enter empno .");
				empno=sc.nextInt();
			}
			
			if(cs!=null) {
				//register out param values
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.FLOAT);
				
				//set the valie to in param
				cs.setInt(1, empno);
				//execute the query
				cs.execute();
				
				//get display the values
				System.out.println("Emp name:"+cs.getString(2));
				System.out.println("Emp salary:"+cs.getFloat(3));
				
			}
			
			
		}
		catch(SQLException se) {
			if(se.getErrorCode()==1403)
				System.out.println("Emp no not found .");
			else if(se.getErrorCode()==1017) 
				System.out.println("invalid credential");
			else
				System.out.println("some db problem .");
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		

	}

}
