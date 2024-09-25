package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poolurl")
public class StudentRegistrationServlet extends HttpServlet {

	private static final String INSERT_STUDENT_QUERY="INSERT INTO STUDENT2 VALUES(SNO_SEQ1.NEXTVAL,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read from data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		float avg=Float.parseFloat(req.getParameter("avg"));
		//WRITE JDBC CODE TO INSERT THE RECORD IN DB TABLE
		try(Connection con=makeConnection(); //pooled jdbc connection 
				PreparedStatement ps=con.prepareStatement(INSERT_STUDENT_QUERY))
		{//try with resources
			
			//set the value to query param
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, avg);
			//execute the query
			int count=ps.executeUpdate();
			//process the resultset
			if(count==0) 
				pw.println("<h1>Problem in student registration</h1>");
			else
				pw.println("<h1>Student registration is done successfully</h1>");
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("DB problem ::"+se.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("problem in establish the connection");
		}
		
		//home hyperlink
		pw.println("<br><a href='input.html'>Home</a>");
	}
	

	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	
	//it is helper method to get Pooled JDBC con object
	private Connection makeConnection() throws Exception{
		//establish the connection with jndi rejistry
		InitialContext ic=new InitialContext();
		//perform jndi lookup operation
		DataSource ds=(DataSource)ic.lookup("java://comp/env/Dsjndi");
		//get pooled jdbc con object
		Connection con=ds.getConnection();
		return con;
	}

	
}
