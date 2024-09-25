package com.nt.jdbc;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;
	
public class LoginAppTest {

				public static void main(String[] args) {
				
					try( Scanner sc=new Scanner(System.in);
							//establish the connection
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
							//CREATE THE STATEMENT OBJECT
							Statement st=con.createStatement();)
					{
						//read the inputs
						String user=null;
						String pass=null;
						if(sc!=null)
						{
							System.out.println("Enter username::");
							user=sc.nextLine();
							System.out.println("Enter password::");
							pass=sc.nextLine();
						}
						
						//convert the i/ps values as required for the sql query
						user="'"+user+"'";
						pass="'"+pass+"'";
						
						//prepare the sql query
						//select COUNT(*) from userinfo where username='RAJA' and password='RANI';
						String query="select COUNT(*) from userinfo where username="+user+"and password="+pass;
						System.out.println(query);
						
						//send and execute the sql query
					 try(ResultSet rs=st.executeQuery(query);)
					 {
						 //process the resultset object
						 if(rs!=null)
						 {
							 rs.next();
							 int count=rs.getInt(1);
							 if(count==0)
							 {
								 System.out.println("INVALID CREDENTIALS.");
							 }
							 else
							 {
								 System.out.println("VALID CREDENTIALS.");
							 }
						 }//IF
					 }//TRY2
					
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

/* output
Enter username::
kk' or 1=1--
Enter password::
janihvhgchgc
select COUNT(*) from userinfo where username='kk' or 1=1--'and password='janihvhgchgc'
VALID CREDENTIALS.
*/