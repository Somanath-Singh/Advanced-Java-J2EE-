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

public class LobsInsertionTest_oracle {

	private final static String ACTOR_INSERT_QUERY="INSERT INTO ACTOR_INFO VALUES(?,?,?,?)";
	
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				PreparedStatement ps=con.prepareStatement(ACTOR_INSERT_QUERY);)
		{
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

/*
 Enter actor name:
ThalaAjit ""
Enter actor photopath:
D:\@MyAllDocument\BlazerPhoto.jpg
Enter actor resumepath:
D:/CvOfSomanath/C.V.OFSOMANATH.pdf
Record insertd successufully.*/
