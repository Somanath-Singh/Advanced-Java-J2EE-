package datatime.nt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateTimeInsertTest_Mysql {

	private final static String INSERT_CUSTOMER_QUERY="INSERT INTO CUSTOMER_INFO(CNAME,BILLAMT,DOB,TOP,ORDER_DATE_TIME) VALUES(?,?,?,?,?)";
	
	
	public static void main(String[] args) {
				
				try(//establish the connection with oracle db
						Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
						PreparedStatement ps=con.prepareStatement(INSERT_CUSTOMER_QUERY);
						Scanner sc= new Scanner(System.in);)
				{
					//read input values
					String name=null,sdob=null,stop=null,sorderdt=null;
					float billamt=0.0f;
					if(sc!=null)
					{
						System.out.println("Enter customer name:");
						name=sc.next();
						System.out.println("Enter customerbill amount");
						billamt=sc.nextFloat();
						System.out.println("Enter dob(dd-mm-yyyy):");
						sdob=sc.next();
						System.out.println("Enter time of purchase(hh:mm:ss):");
						stop=sc.next();
						System.out.println("Enter order_date_time(dd/MM/yyyy hh:mm:ss):");
						sc.nextLine();
						sorderdt=sc.nextLine();
					}
					//convert string dob to java.sql.date class object
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date udob=sdf.parse(sdob);//string date to utill date
					java.sql.Date sqdob=new java.sql.Date(udob.getTime());//utill date sql date
					
					
					//simple time convertion
					//convert string top to java.sql.time obj
					java.sql.Time sqtop=java.sql.Time.valueOf(stop);
					
					//timestam used to only convert time not date
					/*SimpleDateFormat sdff=new SimpleDateFormat("hh:mm:ss");
					java.util.Date dot=sdff.parse(stop);//string date to utill date
					java.sql.Timestamp sqtop=new java.sql.Timestamp(dot.getTime());//utill date sql date*/
					
					//convert string date time to java.sql.timestamp obj
					SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					java.util.Date dob2=sdf2.parse(sorderdt);//string date to utill date
					java.sql.Timestamp sqdob2=new java.sql.Timestamp(dob2.getTime());//utill date sql date
					
					//set values sql query params
					if(ps!=null)
					{
						ps.setString(1, name);
						ps.setFloat(2, billamt);
						ps.setDate(3, sqdob);
						ps.setTime(4, sqtop);
						ps.setTimestamp(5, sqdob2);
						
						//execute the sql query
						int count=ps.executeUpdate();
						
						if(count==0)
						System.out.println("Record not inserted.");
						else
						System.out.println("Record inserted.");
						
					}
					
					
				}//try
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}//class

		}//main