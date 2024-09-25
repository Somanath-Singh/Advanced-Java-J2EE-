package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LinksServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read additional param value
		String pval=req.getParameter("s1");
		//get all locales in the world
		Locale locale[]=Locale.getAvailableLocales();
		//write the business logic
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1>All the languages are</h1>");
			for(Locale l:locale) {
				pw.println(l.getDisplayLanguage()+",");
			}
		}//if
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All the countries are</h1>");
			for(Locale l:locale) {
				pw.println(l.getDisplayCountry()+",");
			  }
			}
		else 
		{
			//get system date and month
			LocalDateTime ldt=LocalDateTime.now();
			//get current month
			int month=ldt.getMonthValue();
			if(month>=3 && month<=6)
				pw.println("<h1 style='color:red;text-align:center;'>summar season</h1>");
			else if(month>=7&&month<=11)
				pw.println("<h1 style='color:red;text-align:center;'>Rainy season</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center;'>Winter season</h1>");
		}
		
		//add hyperlink
		pw.println("<a href='links.html'>home</a>");
		
		//close the stream
		pw.close();
		
	}
	public void dopost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}//dopost(-,-)
	

}
