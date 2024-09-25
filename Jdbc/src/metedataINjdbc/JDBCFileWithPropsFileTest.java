package metedataINjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCFileWithPropsFileTest {
	
	private static final String GET_STUDENT_DETAILS_QUERY="SELECT * FROM STUDENT2";
	
	public static void main(String args[])
	{
		try (InputStream is =new FileInputStream("src/com/nt/commons/jdbc.properties");)
		{
			//load the properties content to java.util.properties class obj
			Properties props=null;
			if(is!=null) {
				props=new Properties();
				props.load(is);
			}
			      /*jdbc.url=jdbc:orcla:thin:@localhost:1521:xe
					jdbc.username=system
					jdbc.password=admin*/
			
			try(Connection con=DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
				 PreparedStatement ps=con.prepareStatement(GET_STUDENT_DETAILS_QUERY);
				 ResultSet rs=ps.executeQuery();){
				
				if(rs!=null) {
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					}//while
			}//if
					 
			}//try2
		}//try1
		catch(IOException se){
			se.printStackTrace();
		}
		catch(Exception se){
			se.printStackTrace();
		}
	}

}
