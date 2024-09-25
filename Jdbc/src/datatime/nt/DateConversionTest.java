package datatime.nt;

import java.text.SimpleDateFormat;

public class DateConversionTest {

	public static void main(String[] args)throws Exception
	{
		String s1="10-12-2020";//dd-MM-yyyy
		//converting string date values to java.text.simpledateformat class object
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1=sdf.parse(s1);
		System.out.println("utill date:"+ud1);
		
		//converting java.util.date class obj to java.sql.date class object
		long ms=ud1.getTime();//get date in miliseconds w.r.t jan 1st 1970 00:00 hours
		java.sql.Date sqd1=new java.sql.Date(ms);
		System.out.println("sql date is:"+sqd1);
		
		//if string date pattern is "yyyy-MM-dd" then it can converted directly to
		//java.sql.Date class obj with out converting into java.util.Date class obj
		String s2="1990-10-20";
		java.sql.Date sqd2=java.sql.Date.valueOf(s2);
		System.out.println("Directly convert java.sql.Date  obj class:"+sqd2);
		
		System.out.println("======================================================");
		//converts java.sql.Date/java.util.Date class obj to String date value in the required pattern
		SimpleDateFormat sdf11=new SimpleDateFormat("MMM-dd-yy");//you can get Date in your required pattern
	    String s3=sdf11.format(sqd2);
	    System.out.println("String date value:"+s3);
		
		System.out.println("===============================================");
		
		//converting string time values to java.sql.time obj
		String t1="10:25:45";//hh:mm:ss
		java.sql.Time sqtime=java.sql.Time.valueOf(t1);
		System.out.println("sql time:"+sqtime);
		
		//converting String ,date time values to java.sql timestamp obj
		String dt1="20-10-1990 10:25:45";
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		java.util.Date udt1=sdf1.parse(dt1);
		//java.sql.Timestamp sqdt1=new java.sql.Timestamp(udt1.getTime());
		//or
		long ms1=udt1.getTime();
		java.sql.Timestamp sqdt1=new java.sql.Timestamp(ms1);
		
		System.out.println("sql timestamp:"+sqdt1);
		
		
		//if string date time value is in yyyy--dd hh:mm:ss pattern then it can converted directly to
		//java.sql.Timestamp class obj with out converting into java.util.Date class obj
		String dt2="1990-10-23 10:25:45";//yyyy-MM--dd hh:mm:ss
		java.sql.Timestamp sqdt2=java.sql.Timestamp.valueOf(dt2);
		System.out.println("directly converting timestamp:"+sqdt2);
		
		System.out.println("======================================================");
		//converting java.sql.Timestam class obj to string ,date value
		java.util.Date udt11=new java.util.Date(sqdt2.getTime());//convert mili second into java.util.Date class obj
		SimpleDateFormat sdf12=new SimpleDateFormat("yyyy:MMM:dd mm:ss:hh");
		String dt3=sdf12.format(udt11);
		System.out.println("String time stamp value:"+dt3);
		
		
		System.out.println("===================================================");
		//convert java.sql.time obj class to String value
		
		SimpleDateFormat sdf112=new SimpleDateFormat("hh/mm/ss");//you can get time in your required pattern
		String t2=sdf112.format(sqtime);
		System.out.println("String time value:"+t2);
	
	}

}
