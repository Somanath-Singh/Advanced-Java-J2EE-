package com.nt.jdbc1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
    import java.util.Scanner;

public class SelectTest1_MYSQL {

		public static void main(String[] args) {
			
			try(Scanner sc=new Scanner(System.in);
					//establish the connection
					Connection con=DriverManager.getConnection("jdbc:mysql:///NTAJ414DB","root","root");
					//create statement object
					Statement st=con.createStatement();)
			{
				//read the inputs
				float start=0.0f;
				float end=0.0f;
				if(sc!=null)
				{
					System.out.println("input the start price:");
					start=sc.nextFloat();
					System.out.println("input the end price:");
					end=sc.nextFloat();
				}
				//prepare the sql query
				//SELECT * FROM PRODUCT WHERE PRICE>=1000 AND PRICE<=3000
				String query="SELECT * FROM PRODUCT WHERE PRICE>="+start+" AND PRICE<="+end;
				System.out.println(query);
				
				try(ResultSet rs=st.executeQuery(query);)
				{
				if(rs!=null)
				{
					boolean rsEmpty=true;
					while(rs.next())
					{
						rsEmpty=false;
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
		}//MAIN
	//CLASS
	}
