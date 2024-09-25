package PLSQL.PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class Cs_ProcedureSquareCubeTest {
	
	/*
	  create or replace procedure p_square_cube(x in number,y out number,z out number)
      as
      begin
      y:=x*x;
      z:=x*x*x;
      end;
      /
	 */
	
	private static final String CALL_PROCEDURE_SQUARE_CUBE_QUERY="{call p_square_cube(?,?,?)}";

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				CallableStatement cs=con.prepareCall(CALL_PROCEDURE_SQUARE_CUBE_QUERY);
				Scanner sc=new Scanner(System.in);)
		{
			//register out params with jdbc type (all out, return params must be registerd)
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.INTEGER);
			//read inputs
			int val1=0,count=0,i;
			if(sc!=null)
			{
				System.out.println("How many time you want to execute procedure:");
				count=sc.nextInt();
				for(i=1;i<=count;i++)
				{
					System.out.println("Enter value "+i+":");
					val1=sc.nextInt();
			        if(cs!=null)
			         {
				      //set value to in params
			          cs.setInt(1, val1);
			          //call PL?SQL procedure
				      cs.execute();
				     //gather result from out params
				     int result1=cs.getInt(2);
				     int result2=cs.getInt(3);
				     System.out.println("square:"+result1);
				     System.out.println("cube:"+result2);
			         }//if
		         }//for
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
