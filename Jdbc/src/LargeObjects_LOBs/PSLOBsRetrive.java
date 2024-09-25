package LargeObjects_LOBs;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PSLOBsRetrive {

	private final static String GET_ACTOR_INFO_BY_ID="SELECT * FROM ACTOR_INFO WHERE AID=?";
	
	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				PreparedStatement ps=con.prepareStatement(GET_ACTOR_INFO_BY_ID);)
		{
			//reads the input values
			int Ano=0;
			if(sc!=null)
			{
				System.out.println("Enter the Actor id");
				Ano=sc.nextInt();
			}
			//set the values to query params
			if(ps!=null)
			{
				ps.setInt(1, Ano);
			}
			try(ResultSet rs=ps.executeQuery();
				OutputStream os=new FileOutputStream("retrive_photo.jpg");
				Writer writer=new FileWriter("retrive_bio_data.txt");)
			{
				//get inputstream ,readerobject from resultset object representing the BLOB,CLOB data of db table
				if(rs!=null)
				{
					if(rs.next())
					{
						int no=rs.getInt(1);
						String name=rs.getString(2);
						
						try(InputStream is=rs.getBinaryStream(3);
						Reader reader=rs.getCharacterStream(4);)
						{
						//write inputstream,reader obj related files content to destination files pointed by outputstream,writer objs
							
					    IOUtils.copy(is,os);
						IOUtils.copy(reader,writer);
						System.out.println(no+" "+name+" "+"Actors resume,photo content is retrived from the db tablecols and placed into the files");
						}//try3
					}
					else
					{
						System.out.println("Actor information not found");
					}
				}//if
				
			}//try2
		}//try1
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(IOException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}//main

}//class
