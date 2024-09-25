package packPreparedStatement;

		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.SQLException;
		import java.util.Scanner;

public class AssignmentPs1 {

	private final static String STUDENT_INSERT_QUERY="INSERT INTO product VALUES(?,?,?,?)";

			public static void main(String args[])
			{
				try(Scanner sc=new Scanner(System.in);
						//establish the connection
						
						//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
						
						//Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj414db","root","root");
						
						//create preparedstatement having precompiled sql query
						PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY);
						)
				{
					int count=0;
					if(sc!=null)
					{
						System.out.println("Enter product counts:");
						count=sc.nextInt();
					}
					
					if(sc!=null && ps!=null)
					{
						for(int i=1;i<=count;i++)
						{
						   System.out.println("Enter "+i+" product details:");
						   System.out.println("Enterproduct no:");
						   int pno=sc.nextInt();
						   System.out.println("Enter product name:");
						   sc.nextLine();
						   String pname=sc.nextLine();
						   System.out.println("Enter product pprice:");
						   int pprice=sc.nextInt();
						   System.out.println("Enter product qty:");
						   float pqty=sc.nextFloat();
						   
						   //set each student details to pre-compiled sql query param values(?)
						   ps.setInt(1,pno);
						   ps.setString(2,pname);
						   ps.setInt(3, pprice);
						   ps.setFloat(4,pqty);
						   
						   //create the result statement (execute the query)
						   int result=ps.executeUpdate();
						   
						   //process the result 
						   
						   if(result==0)
						   System.out.println(i+"product record is not inserted.");
						   else
							   System.out.println(i+" product record is inserted.");
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
			}//main
		}//class

