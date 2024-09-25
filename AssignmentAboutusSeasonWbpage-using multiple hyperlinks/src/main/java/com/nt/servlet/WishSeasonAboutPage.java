package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Locale;

public class WishSeasonAboutPage extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read additional param value
		String pval=req.getParameter("s1");
		//write the business logic
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1Wish Message</h1>");
			LocalDateTime ldt=LocalDateTime.now();
			//get curent time
			int hour=ldt.getHour();
			if(hour<12)
			    pw.println("<h1 style='color:blue;text-align:center;'>Good Morning</h1>");
			else if(hour<16)
				pw.println("<h1 style='color:blue;text-align:center;'>Good Afternoon</h1>");
			else if(hour<20)
				pw.println("<h1 style='color:blue;text-align:center;'>Good Evening</h1>");
			else
				pw.println("<h1 style='color:blue;text-align:center;'>Good Night</h1>");
		}//if
		else if(pval.equalsIgnoreCase("link2")) {
			
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
		else 
		{
			pw.println("<div style='color:white;text-align:center;bordr:1px solid red;background-color:black;margin:auto;padding:12px;font-size:34px;font-weight:600;'>Hello everybody i am <mark>SOMANATH SINGH</mark> from khordha .</div>");
			pw.println("<div style='color:white;text-align:center;bordr:1px solid red;background-color:black;margin:auto;padding:12px;font-size:34px;font-weight:600;'>i have completed my graduation from prananath autonomus ,Khordha</div>");
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

