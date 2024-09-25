package metedataINjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileTest {

	public static void main(String[] args) {
		
		try(InputStream is=new FileInputStream("src/com/nt/commons/info.properties");)
		{
			//Load the properties file content to java.util.properties class obj
			Properties props=new Properties();
			props.load(is);
			System.out.println("properties class obj data::"+props);
			System.out.println("per.name key value::"+props.getProperty("per.name"));
			System.out.println("per.age key value::"+props.getProperty("per.age"));
			System.out.println("per.adds key value::"+props.getProperty("per.adds"));
			System.out.println("per.qlfy key value::"+props.getProperty("per.qlfy"));
		}
		catch(IOException se) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}

	}

}
/*package metedataINjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileTest {

	public static void main(String[] args) {
		
		try(InputStream is=new FileInputStream("src/com/nt/commons/jdbc.properties");)
		{
			//Load the properties file content to java.util.properties class obj
			Properties props=new Properties();
			props.load(is);
			System.out.println("properties class obj data::"+props);
			System.out.println("per.name key value::"+props.getProperty("jdbc.url"));
			System.out.println("per.age key value::"+props.getProperty("jdbc.username"));
			System.out.println("per.adds key value::"+props.getProperty("jdbc.password"));
		
		}
		catch(IOException se) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}

	}

}
*/