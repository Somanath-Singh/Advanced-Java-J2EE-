package metedataINjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParaMeterMetaDataTest {
  
	private static final String INSERT_QUERY="INSERT INTO STUDENT2 VALUES(?,?,?,?)";
	
	public static void main(String[] args) {
		
		try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);)
		{
			ParameterMetaData pmd=null;
			if(ps!=null)
			{
				pmd=ps.getParameterMetaData();
			}
			if(pmd!=null) {
				int paramsCount=pmd.getParameterCount();
				for(int i=1;i<paramsCount;++i) {
					System.out.println("Parameter count:"+i);
					System.out.println("parameter mode:"+pmd.getParameterMode(i));
					System.out.println("parameter type:"+pmd.getParameterTypeName(i));
					System.out.println("Is parameter nullable??:"+pmd.isNullable(i));
					System.out.println("is parameter signed??:"+pmd.isSigned(i));
					System.out.println("Parameter precesion value:"+pmd.getPrecision(i));
					System.out.println("parameter scale:"+pmd.getScale(i));
				}
			}
		}
		catch (SQLException se)
		{
			 se.printStackTrace();
		}
		catch (Exception e)
		{
	          e.printStackTrace();
		}

	}

}
