package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlSelectTest {
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in);
				//establish the connection
				Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
				//create statement object
				Statement st=con.createStatement();)
		{
			float startprice=0.0f;
			float endprice=0.0f;
			if(sc!=null)
			{
				System.out.println("Enter start price:");
				startprice=sc.nextFloat();
				System.out.println("Enter endprice:");
				endprice=sc.nextFloat();
			}
			//prepare the sql query
			String query="SELECT * FROM CUSTOMERS WHERE BILLAMOUNT>="+startprice+" AND BILLAMOUNT<="+endprice;
			System.out.println(query);
			//send and execute the sql query
			try(ResultSet rs=st.executeQuery(query);)
			{
				if(rs!=null)
				{
					boolean rsEmpty=true;
					while(rs.next())
					{
						rsEmpty=false;
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
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
			}//try2
		}//try1
		catch (SQLException se)
		{
	          se.printStackTrace();
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}
	}//main
}//class
