package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
			//header content
			RequestDispatcher rd1=req.getRequestDispatcher("/headurl");
			rd1.include(req, res);
			pw.println("<h1>Hello Everyone</h1>");
			
			//get Access to ServletContext object
			ServletContext sc=getServletContext();
			//read the context param/global init param values
			String driver=sc.getInitParameter("driver");
			String url=sc.getInitParameter("url");
			String user=sc.getInitParameter("dbuser");
			String pwd=sc.getInitParameter("dbpswd");
			//load the jdbc driver class(activation the jdbc driver s/w)
			Class.forName(driver);
			//estlabish the connection with DB s/w
			con=DriverManager.getConnection(url,user,pwd);
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
			
			//footer content
			RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
			
		}//try
		catch(Exception e) {
			pw.println("problem ::"+e.getMessage());
			e.printStackTrace();
			//approach 1
			//RequestDispatcher rd=req.getRequestDispatcher("errorurl");//forward slash is not mandatory
			
			//approach 2
			ServletContext sc=getServletContext();
			//RequestDispatcher rd=sc.getRequestDispatcher("/errorurl");
			RequestDispatcher rd=sc.getNamedDispatcher("err");
			System.out.println("EmployeeSearchServlet.doGet(-,-) Before rd.forward(-,-)");
			pw.println("<h1>Before rd.forward(-,-)</h1>");
			rd.forward(req, res);
			pw.println("<h1>After rd.forward(-,-)</h1>");
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
