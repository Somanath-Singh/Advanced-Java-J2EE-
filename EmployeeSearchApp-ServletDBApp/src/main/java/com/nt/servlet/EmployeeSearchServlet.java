package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empurl")
public class EmployeeSearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//getprintwriter object
		PrintWriter pw=res.getWriter();
		//set the response content type
		res.setContentType("text/html");
		//read from data
		int no=Integer.parseInt(req.getParameter("empno"));
		//writer jdbc code
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//load the jdbc driver class(activation the jdbc driver s/w)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//estlabish the connection with DB s/w
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			//create the preparedStatement object
			ps=con.prepareStatement("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?");
			//set the value to query param
			ps.setInt(1, no);
			//EXECUTE THE SQL QUERY
		     rs=ps.executeQuery();
			//process the resultset object
			if(rs.next()) {  
				pw.println("<h1 style='color:red;text-align:center'>Employee Details are::</h1>");
				pw.println("<table border='1' align='center'>");
				pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getFloat(4)+"</td></tr>");
				pw.println("</table>");
			}
			else{
				pw.println("<h1 style='color:red;text-align:center'>Employee Record not found </h1>");
			}
			//add hyperlink
			pw.println("<br><a href='input.html'>home</a>");
		}//try
		catch(SQLException se) {
			pw.println("DB problem ::"+se.getMessage());
			se.printStackTrace();
		}
		catch(Exception e) {
			pw.println("Unknown problem ::"+e.getMessage());
			e.printStackTrace();
		}
		finally{
			//close the jdbc object
			try {
				if(rs!=null) {
					rs.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) {
					ps.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	
	}//method
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);	
	}//method
}//class
