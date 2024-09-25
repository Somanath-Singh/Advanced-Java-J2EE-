package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

			public static void main(String[] args) {
			
				try( Scanner sc=new Scanner(System.in);
						//establish the connection
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
						//CREATE THE STATEMENT OBJECT
						Statement st=con.createStatement();)
						
				{
					//read the inputs
					String query=null;
					if(sc!=null)
					{
						System.out.println("Enter query::");
						query=sc.nextLine();
					}
					
					//send and execute the sql query
					if(st!=null)
					{
						boolean flag=st.execute(query);
						if(flag)
						{
							System.out.println("select sql query is executed.");
							//get the ResultSet object
							try(ResultSet rs=st.getResultSet())
							{
								//process the result set
								if(rs!=null)
								{
									while(rs.next())
									{
										System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
									}//while
								}//if
							}//try2
						}//if
						else
						{
							System.out.println("NON SELECT sql query executed");
							int count=st.getUpdateCount();
							System.out.println("no of record that effected:"+count);
						}//else
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
			}//main
		}//class

/*package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest 
{
	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in);
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
				Statement st=con.createStatement();
				)
		{
			String query=null;
			if(con!=null)
			{
				System.out.println("Enter the SQL Query");
				//sc.nextLine();
				query=sc.nextLine();
			}
			if(st!=null)
			{
				boolean flag=st.execute(query);
				if(flag)
				{
					System.out.println("Select SQL Query is executed ");
					try(ResultSet rs=st.getResultSet())
					{
						if(rs!=null)
						{
							while(rs.next())
							{
								System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
							}//while
						}//if
					}//try2
				}//if
				else
				{
					System.out.println("Non select SQL Query is Executed ");
					int count=st.getUpdateCount();
					System.out.println("No of records that are effected is "+count);
				}//else
			}//if
			
		}//try1
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}*/