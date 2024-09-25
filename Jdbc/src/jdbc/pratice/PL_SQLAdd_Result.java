package jdbc.pratice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class PL_SQLAdd_Result {

	private static final String Call_Procedure="{call p_add_data(?,?,?)}";
	
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				CallableStatement cs=con.prepareCall(Call_Procedure);)
		{
			int val1=0,val2=0;
			if(sc!=null) {
				System.out.println("Enter val1 and val2 .");
				val1=sc.nextInt();
				val2=sc.nextInt();
			}
			
			if(cs!=null) {
				//register the outparam values
				cs.registerOutParameter(3, Types.INTEGER);
				//set the values to query param
				cs.setInt(1, val1);
				cs.setInt(2, val2);
				
				//execute the sql query
				cs.execute();
				//result the out parameter
				int result=cs.getInt(3);
				System.out.println("value is :"+result);
				
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		

	}

}
