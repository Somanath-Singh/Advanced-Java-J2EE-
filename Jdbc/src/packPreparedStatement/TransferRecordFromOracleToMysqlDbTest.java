package packPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransferRecordFromOracleToMysqlDbTest {
	
	private final static String ORACLE_SELECT_QUERY="SELECT * FROM PRODUCT";
	private final static String MYSQL_INSERT_QUERY="INSERT INTO PRODUCT VALUES(?,?,?,?)";

	public static void main(String[] args) {
		
		try(//establish the connection with oracle db
				Connection oracon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				//establisjh the connection with mysql db
				Connection mysqlcon=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root","root");
				Statement st=oracon.createStatement();
				PreparedStatement ps=mysqlcon.prepareStatement(MYSQL_INSERT_QUERY);
				)
		{
			//execute the  select sql query  in oracle db s/w
			try(ResultSet rs=st.executeQuery(ORACLE_SELECT_QUERY);)
			{
				//process the result set
				//and also insert record into mysql db
				int count=0;
				if(rs!=null && ps!=null)
				{
					while(rs.next())
					{
						//get each record from oracle db table
						int id=rs.getInt(1);
						String name=rs.getString(2);
						float price=rs.getFloat(3);
						float qty=rs.getFloat(4);
						//set the above values to insert sql query param values in mysql db table
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setFloat(3, price);
						ps.setFloat(4, qty);
						//execute query
						int result=ps.executeUpdate();
						//process the result set
						if(result==0)
						System.out.println("Record not inserted");
						else
							System.out.println("record inserted");
						count++;
					}//while
					System.out.println(count+"::no of records are copied from oracle db table to my sql db table");
				}//if
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
	}//main
}//class
