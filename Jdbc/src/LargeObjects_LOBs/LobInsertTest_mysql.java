package LargeObjects_LOBs;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LobInsertTest_mysql {

		private final static String ACTOR_INSERT_QUERY="INSERT INTO ACTOR_INFO(ANAME,PHOTO,RESUME) VALUES(?,?,?)";
		
		public static void main(String[] args) 
		{
			try(Scanner sc=new Scanner(System.in);
					Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db","root","root");
					PreparedStatement ps=con.prepareStatement(ACTOR_INSERT_QUERY);)
			{
				//read the input values
				String Aname=null,PhotoPath=null,ResumePath=null;
				if(sc!=null)
				{
					System.out.println("Enter actor name:");
					Aname=sc.next();
					System.out.println("Enter actor photopath:");
					PhotoPath=sc.next();
					System.out.println("Enter actor resumepath:");
					ResumePath=sc.next();
				}
				//create Streams representing the photo file and resume file
				try(InputStream is=new FileInputStream(PhotoPath);//byte stream for binary file
						Reader read=new FileReader(ResumePath);)//character stream for text file
				{
					//set the values to query param
					if(ps!=null)
					{
						ps.setString(1, Aname);
						ps.setBinaryStream(2,is);
						ps.setCharacterStream(3, read);
					}
					//execute the pre compiled sql query
					int result=ps.executeUpdate();
					
					//process the resultset
					if(result==0)
					{
						System.out.println("Record not inserted.");
					}
					else
					{
						System.out.println("Record insertd successufully.");
					}
				}//try2
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

	}
