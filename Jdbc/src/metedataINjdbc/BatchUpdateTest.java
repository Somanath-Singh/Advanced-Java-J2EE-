package metedataINjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateTest {

	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				Statement st=con.createStatement();)
		{
			if(st!=null) {
				//add queries to the batch
				st.addBatch("INSERT INTO STUDENT2 VALUES(110,'syam','hyd',68.29)");
				st.addBatch("UPDATE STUDENT2 SET AVG=AVG+2.23 WHERE SAAD='hyd' ");
				st.addBatch("DELETE FROM STUDENT2 WHERE SNO>=108");
				//EXECUTE THE BATCH
				
				int result[]=st.executeBatch();
				
				//process the resultset
				
				int sum=0;
				if(result!=null) {
					for(int i=0;i<result.length;++i)
						sum=sum+result[i];
				}//if1
						System.out.println("no of record that are affected:"+sum);
			}//if2
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}

	}

}
