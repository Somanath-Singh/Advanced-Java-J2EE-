package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class Cs_ProcedureCallTest {
	
	private static final String CALL_PROCEDURE_QUERY="{call p_sum(?,?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);
				Scanner sc=new Scanner(System.in);)
		{
			//read inputs
			int val1=0,val2=0;
			if(sc!=null)
			{
				System.out.println("Enter value 1:");
				val1=sc.nextInt();
				System.out.println("Enter value 2:");
				val2=sc.nextInt();
			}
			
			if(cs!=null)
			{
				//register out params with jdbc type (all out, return params must be registerd)
				cs.registerOutParameter(3, Types.INTEGER);
				//set value to in params
				cs.setInt(1, val1);
				cs.setInt(2, val2);
				//call PL?SQL procedure
				cs.execute();
				//gather result from out params
				int result=cs.getInt(3);
				System.out.println("Result:"+result);	
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
