package datatime.nt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class DateRetriveTest_Mysql {

			private final static String GET_CUSTOMER_QUERY="SELECT * FROM CUSTOMER_INFO";
			
			public static void main(String[] args) {
				
				try(//establish the connection with oracle db
						Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
						PreparedStatement ps=con.prepareStatement(GET_CUSTOMER_QUERY);
						ResultSet rs=ps.executeQuery();)
				{
					if(rs!=null)
					{
						while(rs.next())
						{
							int cno=rs.getInt(1);
							String name=rs.getString(2);
							float billamt=rs.getFloat(3);
							java.sql.Date sqdob=rs.getDate(4);
							java.sql.Time sqlTime=rs.getTime(5);
							java.sql.Timestamp sqlorderdt=rs.getTimestamp(6);
							
							//convert java.sqlDate class obj to string 
							SimpleDateFormat sdf=new SimpleDateFormat("MMM-dd-yyyy");
							String d1=sdf.format(sqdob);
							
							//convert java.sql.Time class obj to String 
							//SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
							//String t1=sdf2.format(sqlTime);
							
							//or
							
							java.util.Date utop=new java.util.Date(sqlTime.getTime());
							SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
							String t1=sdf2.format(utop);
							
							//convert java.util.Timestamp class obj to string
							java.util.Date sodt=new java.util.Date(sqlorderdt.getTime());
							SimpleDateFormat sdf3=new SimpleDateFormat("MMM-dd-yyyy hh:mm:ss");
							String sqlorderdt2=sdf3.format(sodt);
							
							System.out.println(cno+" "+name+" "+billamt+" "+d1+" "+t1+" "+sqlorderdt2);
							
						}//while
					}//if
					
				}//try
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}//main

		}//class
