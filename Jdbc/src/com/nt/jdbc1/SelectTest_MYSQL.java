package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest_MYSQL {

	public static void main(String[] args) {
		
		try(//establish the connection
				Connection con=DriverManager.getConnection("jdbc:mysql:///NTAJ414DB","root","root");
				//create statement object
				Statement st=con.createStatement();
				//execute the sql query
				ResultSet rs=st.executeQuery("SELECT * FROM PRODUCT");)
		{
			if(rs!=null)
			{
				boolean rsEmpty=false;
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getFloat(4));
				}//while
				if(rsEmpty)
				{
					System.out.println("NO RECORD FOUND");
				}
				else
				{
					System.out.println("RECORD FOUND AND DISPLAYED");
				}
			}//IF
		}//try1
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}
	}//MAIN
//CLASS
}
