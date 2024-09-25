package packPreparedStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginAppPreparedStamnt {

	private final static String AUTO_QUERY="SELECT COUNT(*) FROM USERINFO WHERE USERNAME=? AND PASSWORD=?";

				public static void main(String[] args) {
				
					try( Scanner sc=new Scanner(System.in);
							//establish the connection
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
							//CREATE THE STATEMENT OBJECT
							PreparedStatement ps=con.prepareStatement(AUTO_QUERY);)
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
						//set values to query parameter
						
						if(ps!=null)
						{
							ps.setString(1, user);
							ps.setString(2, pass);
						}
	
						//send and execute the sql query
					 try(ResultSet rs=ps.executeQuery();)
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
