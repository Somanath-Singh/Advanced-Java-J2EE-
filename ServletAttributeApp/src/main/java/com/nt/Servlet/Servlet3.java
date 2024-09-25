package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read and display the attributes
		pw.println ("<b>From servlet3 --- attr1 value :: " + req.getAttribute("attr1")+"</b><br>");
		
		
		//read and display the session attributes values
				HttpSession ses=req.getSession();
				pw.println ("<b>From servlet3 --- attr2(Session) value :: " + ses.getAttribute("attr2")+"</b><br>");
				
				//read and display the servletContext attributes values
				ServletContext sc=req.getServletContext();
				pw.println ("<b>From servlet3 --- attr3(Application) value :: " + sc.getAttribute("attr3")+"</b><br>");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
