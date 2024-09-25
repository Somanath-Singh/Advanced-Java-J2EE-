package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;

public class Cs_ProcedureCursorInitialCharsTest {
	
	/*
CREATE OR REPLACE PROCEDURE P_GET_EMP_DETAILS_BY_CHARS 
(
  NAMECHARS IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
OPEN DETAILS FOR
  SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE NAMECHARS;
END P_GET_EMP_DETAILS_BY_CHARS;
	 */
	
	private static final String CALL_PROCEDURE_QUERY="{call P_GET_EMP_DETAILS_BY_CHARS(?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);
				Scanner sc=new Scanner(System.in);)
		{
			
			//read inputs
			String initialname=null ;
			if(sc!=null)
			{
					System.out.println("Enter initial character of emp:");
					initialname=sc.next();
			}
			        if(cs!=null)
			         {
			        	//register out params with jdbc type (all out, return params must be registerd)
						cs.registerOutParameter(2, OracleTypes.CURSOR);
				      //set value to in params
			          cs.setString(1,initialname+"%"); 
			          //call PL?SQL procedure
				      cs.execute();
				     //gather result from out params
				      try(ResultSet rs=(ResultSet)cs.getObject(2);)
				      {
				    	  //process the resultset obj
				    	  if(rs!=null)
				    	  {
				    		  boolean isRSEmpty=true;
				    		  while(rs.next())
				    		  {
				    			  isRSEmpty=false;
				    			  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
				    		  }
				    	  if(isRSEmpty)
				    		  System.out.println("No Recorsd found.");
				    	  else
				    		  System.out.println("All record displayed.");
				    	  }//if
				    	  
				      }//try
				    	  
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
