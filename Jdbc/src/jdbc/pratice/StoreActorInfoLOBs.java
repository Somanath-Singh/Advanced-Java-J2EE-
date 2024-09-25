package jdbc.pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

public class StoreActorInfoLOBs {

	private static final String Actor_info_query="INSERT INTO ACTOR_INFO VALUES(?,?,?,?)";
	private static final String Get_Actor_info="SELECT * FROM ACTOR_INFO WHERE AID=?";
	
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in);
				Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				PreparedStatement ps=con.prepareStatement(Actor_info_query);
				PreparedStatement ps2=con.prepareStatement(Get_Actor_info);)
		{
			System.out.println("Enter 1 for Insert value . ");
			System.out.println("Enter 2 or retrive information .");
			int choice=sc.nextInt();
			
			if(choice==1) {
				//read the input values
				int Ano=0;
				String Aname=null,PhotoPath=null,ResumePath=null;
				if(sc!=null)
				{
					System.out.println("Enter Actor no:");
					Ano=sc.nextInt();
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
						ps.setInt(1, Ano);
						ps.setString(2, Aname);
						ps.setBinaryStream(3,is);
						ps.setCharacterStream(4, read);
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
			}//if
			else {
				int aid=0;
				if(sc!=null) {
					System.out.println("Enter Actor id .");
					aid=sc.nextInt();
				}
				//set the value to query param
				if(ps!=null) {
					ps2.setInt(1, aid);
				}
				
				//execute the sql query
				try(ResultSet rs=ps2.executeQuery();
						OutputStream os=new FileOutputStream("D:/Photo.jpg");
						Writer write=new FileWriter("D:/text.txt");)
				{
					if(rs!=null) {
						if(rs.next()) {
							int no=rs.getInt(1);
							String name=rs.getString(2);
							
							try(InputStream is2=rs.getBinaryStream(3);
									Reader read2=rs.getCharacterStream(4);)
							{
								IOUtils.copy(is2,os);
								IOUtils.copy(read2,write);
								System.out.println(no+"  "+name+"   "+"photo and resume is retrived from another folder");
							}//try
							
						}//if
						else {
							System.out.println("query not executed .");
						}
					}//if
				}
			}
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		

	}

}
