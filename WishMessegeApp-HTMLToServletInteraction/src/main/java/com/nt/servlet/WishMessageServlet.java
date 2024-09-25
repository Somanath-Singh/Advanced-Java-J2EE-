package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		//get printwriter object from the response object
		PrintWriter pw=res.getWriter(); 
		//get response content type
		res.setContentType("text/html");
		
		//write the business logic
		LocalDateTime idt=LocalDateTime.now();//givrs the system date and time
		//get current hour of the day
		int hour=idt.getHour();
		
		if(hour<12)
			pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
		else if(hour<16)
			pw.println("<h1 style='color:orange;text-align:center'>Good Afternoon</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:orange;text-align:center'>Good Evening</h1>");
		else
			pw.println("<h1 style='color:orange;text-align:center'>Good Night</h1>");
		
		
		//add the hyperlink
		//absolute url not required when servlet and html are local to each other 
		/*pw.println("<a href='http://localhost:3031/WishMessegeApp-HTMLToServletInteraction/page.html'> Home</a>"); */
		//relative url
		pw.println("<a href='page.html'> Home</a>");
		//close the stream
		pw.close();
		
	}//doget(-,-)
}
