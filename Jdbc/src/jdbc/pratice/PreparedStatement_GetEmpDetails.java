package jdbc.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatement_GetEmpDetails {

	private static final String Get_Emp_Details="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO=?";
	private static final String Insert_Emp_Details="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL) VALUES (?,?,?,?) ";
	
	public static void main(String args[]) {
		
		try (//Class.forName("oracle.jdbc.driver.OracleDriver");
				Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
				PreparedStatement ps=con.prepareStatement(Get_Emp_Details);
				PreparedStatement ps2=con.prepareStatement(Insert_Emp_Details);){
			
			int choice=0;
			if(sc!=null) {
				System.out.println("Enter your choice .");
				System.out.println("press 1 for Get_Emp_Details .");
				System.out.println("press 2 for Insert_Emp_Details .");
				choice=sc.nextInt();
			}
			
			if(choice==1) {
				
				int deptno=0;
				if(sc!=null) {
					System.out.println("Enter dept no :");
					deptno=sc.nextInt();
				}
				//set the value to sql query param
				if(ps!=null) {
					ps.setInt(1, deptno);
				}
				//execute the sql query
				try(ResultSet rs=ps.executeQuery();){
					
					if(rs!=null) {
						boolean isExecute=true;
						while(rs.next()) {
							isExecute=false;
							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getInt(5));
						}//while
						if(isExecute) {
							System.out.println("Deptno not found .");
						}
						else {
							System.out.println("Query executed successfully .");
						}//if
					}//if
				}//innertry
			}//if
			else {
				
				int insert=0;
				int count=0;
				
				if(sc!=null) {
					System.out.println("how many user you eant to insert .");
					insert=sc.nextInt();
				}
				
				int empno=0;
				String ename=null;
				String job=null;
				int sal=0;
				
				for(int i=1;i<=insert;i++) {
					//get all the details form user
					if(sc!=null) {
						System.out.println("Enter empno :");
						empno=sc.nextInt();
						System.out.println("Enter emp name :");
						ename=sc.next();
						System.out.println("Enter emp job :");
						job=sc.next();
						System.out.println("Enter emp sal :");
						sal=sc.nextInt();
					}
					
					//set the values to query param
					if(ps2!=null) {
						ps2.setInt(1, empno);
						ps2.setString(2, ename);
						ps2.setString(3, job);
						ps2.setInt(4, sal);
						
					}
					//execute the sql query
					count=ps2.executeUpdate();
				}//for
				
				
				if(count==0) {
					System.out.println("Query not executed .");
				}
				else {
					System.out.println( count+"Query executed successfully .");
				}
			}
			
		
			
		}//outertry
		
		catch(SQLException se ) {
			se.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
	}
}
