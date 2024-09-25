package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class Cs_FunctionStudentDetTest {
	
	/*
CREATE OR REPLACE FUNCTION FX_GET_STUDENT_DET_BY_SNO 
( NO IN NUMBER , NAME OUT VARCHAR2 , ADDS OUT VARCHAR2 ) RETURN FLOAT AS 
PERCENTAGE FLOAT;
BEGIN
SELECT SNAME,CITYS,AVG INTO NAME,ADDS,PERCENTAGE FROM STUDENT2 WHERE SNO=NO;
  RETURN PERCENTAGE;
END FX_GET_STUDENT_DET_BY_SNO;
	 */
	
	private static final String CALL_FUNCTION_QUERY="{?=call FX_GET_STUDENT_DET_BY_SNO(?,?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				CallableStatement cs=con.prepareCall(CALL_FUNCTION_QUERY);
				Scanner sc=new Scanner(System.in);)
		{
			
			//read inputs
			int no=0;
			if(sc!=null)
			{
					System.out.println("Enter student no:");
					no=sc.nextInt();
			}
			        if(cs!=null)
			         {
			        	//register out params with jdbc type (all out, return params must be registerd)
						cs.registerOutParameter(1, Types.FLOAT);//RETURN PARAM
						cs.registerOutParameter(3, Types.VARCHAR);//out PARAM
						cs.registerOutParameter(4, Types.VARCHAR);//out PARAM					
				      //set value to in params
			          cs.setInt(2,no);//in param 
			          //call PL?SQL procedure
				      cs.execute();
				     //gather result from out params
				      System.out.println("student name:"+cs.getString(3));
				      System.out.println("student addres:"+cs.getString(4));
				      System.out.println("student avg:"+cs.getFloat(1));
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
