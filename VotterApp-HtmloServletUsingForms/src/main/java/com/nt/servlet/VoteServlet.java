package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

public class VoteServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		System.out.println("VoterServlet.doPost(-,-)");
		//get printwriter object from the response object
		PrintWriter pw=res.getWriter(); 
		//set response content type
		res.setContentType("text/html");
		
		//read from data the req obj as the request param value
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		int age=Integer.parseInt(tage);
		String addrs=req.getParameter("paddrs");
		
		//write the logic
		if(age>=18)
			pw.println("<h1 style='color:green'>Mr/Miss/Mrs "+name+" you eligible for Voting</h1>");
		else
			pw.println("<h1 style='color:red'>Mr/Miss/Mrs "+name+" you are not eligible for Voting</h1>");

		//add graphical hyperlink
		pw.println("<a href='input.html'><img src='images/home.png' width='100' height='100'></a>");
		//close the stream
		pw.close(); 
     }
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("VoterServlet.doGet(-,-)");
	//get printwriter
		PrintWriter pw=res.getWriter();
		//set the response content type
		res.setContentType("text/html");
		//write the response
		pw.println("<h1 Style='color:green;text-align:center'>Date and Time is::"+new Date()+"</h1>");
		//close the stream
		//add graphical hyperlink
		pw.println("<a href='input.html'><img src='images/home.png' width='100' height='100'></a> ");
		pw.close();
		
		
	}
}

