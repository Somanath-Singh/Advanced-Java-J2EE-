package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*@WebServlet("/homeurl")*/
public class HomePageServlet extends HttpServlet {
@Override
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
	//get print writer stream
	PrintWriter pw=res.getWriter();
	//set response content type
	res.setContentType("text/html");
    
	//add home page content having hyperlink
	pw.println("<h1 style=\"color:red;text-align:center\">HTML to servlet communication using Hyperlinks(HomeServlet)</h1><br>");
	
	pw.println("<a href='wishurl'>Get Message</a>");
	
	//close the stream
	pw.close();
	
	}
	}
