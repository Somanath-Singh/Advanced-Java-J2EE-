package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class Cs_ProcedureGetStudentDet {
	
	/*
CREATE OR REPLACE PROCEDURE P_GET_STUDENT2_DET_BY_NO 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, AVG OUT FLOAT 
) AS 
BEGIN
  SELECT SNAME,AVG INTO NAME,AVG FROM STUDENT2 WHERE SNO=NO;
END P_GET_STUDENT2_DET_BY_NO;
	 */
	
	private static final String CALL_PROCEDURE_QUERY="{call P_GET_STUDENT2_DET_BY_NO (?,?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);
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
				      //set value to in params
			          cs.setInt(1, no);
			        //register out params with jdbc type (all out, return params must be registerd)
						cs.registerOutParameter(2, Types.VARCHAR);
						cs.registerOutParameter(3, Types.FLOAT);
			          //call PL?SQL procedure
				      cs.execute();
				     //gather result from out params
				     String name=cs.getString(2);
				     int sal=cs.getInt(3);
				     System.out.println("STUDENT name is:"+name);
				     System.out.println("STUDENT AVG is:"+sal);
			         }//if
		}//try
		catch (SQLException se)
		{
	         if(se.getErrorCode()==1403)
	         {
	        	 System.out.println("Employee not found.");
	         }
	         else if(se.getErrorCode()==1017)
	         {
	        	 System.out.println("Invalid Creden tials.");
	         }
	         else
	         {
	        	 System.out.println("Unknown db problem.");
	         }
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}	

	}

}
