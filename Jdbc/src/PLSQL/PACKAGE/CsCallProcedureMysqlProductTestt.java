package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

public class CsCallProcedureMysqlProductTestt {
	
	/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCTS_BY_PRICE_RANGE_MYSQL`(IN startprice float,IN endprice float)
BEGIN
SELECT PID,PNAME,PRICE,QTY FROM PRODUCT WHERE PRICE>=STARTPRICE AND PRICE<=ENDPRICE;
END
	 */
	
	private static final String CALL_PROCEDURE_QUERY="{call P_GET_PRODUCTS_BY_PRICE_RANGE_MYSQL(?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE_QUERY);
				Scanner sc=new Scanner(System.in);)
		{
			
			//read inputs
			int startpricerange=0,endpricerange=0;
			if(sc!=null)
			{
					System.out.println("Enter start price range:");
					startpricerange=sc.nextInt();
					System.out.println("Enter end price range:");
					endpricerange=sc.nextInt();
			}
			        if(cs!=null)
			         {
			        	//register out params with jdbc type (all out, return params must be registerd)
						//NOT AVAILABLE				
				      //set value to in params
			          cs.setInt(1,startpricerange);//in param 
			          cs.setInt(2,endpricerange);//in param
			          //call PL?SQL procedure
				      cs.execute();
				     //gather result from out params
				      try(ResultSet rs=cs.getResultSet();)
				      {
				    	  //process the resultset obj
				    	  if(rs!=null)
				    	  {
				    		  boolean isRSEmpty=true;
				    		  while(rs.next())
				    		  {
				    			  isRSEmpty=false;
				    			  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getFloat(4));
				    		  }
				    	  if(isRSEmpty)
				    		  System.out.println("No Recorsd found.");
				    	  else
				    		  System.out.println("All record found and displayed.");
				    	  }//if
				    	  
				      }//try2
			         }//if
		}//try1
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
