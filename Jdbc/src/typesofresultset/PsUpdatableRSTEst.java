package typesofresultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PsUpdatableRSTEst {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				PreparedStatement ps=con.prepareStatement("SELECT SNO,SNAME,CITYS,AVG FROM STUDENT2",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=ps.executeQuery();)
			{
			 if(rs!=null)
			 {
				 System.out.println("select operation.");
				 while(rs.next())
					{
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getFloat(4));
					}//while
				 //insert operation
				 rs.moveToInsertRow();
				 rs.updateInt(1, 107);
				 rs.updateString(2, "mahes");
				 rs.updateString(3, "delhi");
				 rs.updateFloat(4, 8900);
				 
				 rs.insertRow();
				 
				 System.out.println("record inserted.");
				 
				 //update operation
				 
				 rs.absolute(2);
				 rs.updateString(3, "delhi");
				 rs.updateRow();
				 System.out.println("record updated.");
				 
				 //delete operation
				 rs.absolute(3);
				 rs.deleteRow();
				 System.out.println("record deleted.");
				 
			 }
			
			}
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
