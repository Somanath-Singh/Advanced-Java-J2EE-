package packPreparedStatement;


		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;

public class PsDynamicSelectTest {

			private final static String STDENT_ALL_QUERY="SELECT * FROM STUDENT4";

						public static void main(String[] args) {
						
							try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
								//CREATE THE STATEMENT OBJECT
							PreparedStatement ps=con.prepareStatement(STDENT_ALL_QUERY);
							//execute the pre-compiled sql query
							ResultSet rs=ps.executeQuery();)
							{
								//process ther result set
								if(ps!=null)
								{
									while(rs.next())
									{
										System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
									}
								}
								
							}//try
							catch (SQLException se)
							{
						          se.printStackTrace();
							}
							catch (Exception e)
							{
						          e.printStackTrace();
							}
						}//main
					}//class