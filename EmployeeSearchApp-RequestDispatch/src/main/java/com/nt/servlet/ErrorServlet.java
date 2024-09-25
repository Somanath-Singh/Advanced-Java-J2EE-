package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/errorurl",name="err")

public class ErrorServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet()");
		//gegt printwriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//error message as non technical guiding message
		pw.println("<h1 style='color:red;text-align:center;'>Internal problem ----Try again</h1>");
		//home link
		pw.println("<a href='input.html'>Home</a>");
		//close the stream
		pw.close();
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(req, res);
	}
}
