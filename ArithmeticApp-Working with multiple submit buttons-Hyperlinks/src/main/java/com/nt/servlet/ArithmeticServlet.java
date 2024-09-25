package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//get print writer
		PrintWriter pw=res.getWriter();
		//set the response content type
		res.setContentType("text/html");
		//read addition s1 request param value
		String pval=req.getParameter("s1");
		//read from data only when submit button are clicked
		float val1=0,val2=0;
		//get date and time
		LocalDateTime ldt=null;
		if(!pval.equalsIgnoreCase("link1")&& !pval.equalsIgnoreCase("link2")){
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
		}
		else {//creating localADteTime class obj only when hyperlink is clicked 
			ldt=LocalDateTime.now();//gives the system date and time
		}
		
		
		//differentiate the logics for the submit button and hyperlinks
		 if(pval.equalsIgnoreCase("add")) {
			 pw.println("<h1> Addition::"+(val1+val2)+"</h1>");
		 }
		 else if(pval.equalsIgnoreCase("sub")) {
			 pw.println("<h1> Subtraction::"+(val1-val2)+"</h1>");
		 }
		 else if(pval.equalsIgnoreCase("mul")) {
			 pw.println("<h1> Multiplication::"+(val1*val2)+"</h1>");
		 }
		 else if(pval.equalsIgnoreCase("Div")) {
			 pw.println("<h1> Division::"+(val1/val2)+"</h1>");
		 }
		 else if(pval.equalsIgnoreCase("link1")) {
			 //get current hour of the day
			 int hour=ldt.getHour();
				if(hour<12)
					//generate the wish message based on the
					pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
				else if(hour<16)
					pw.println("<h1 style='color:orange;text-align:center'>Good Afternoon</h1>");
				else if(hour<20)
					pw.println("<h1 style='color:orange;text-align:center'>Good Evening</h1>");
				else
					pw.println("<h1 style='color:orange;text-align:center'>Good Night</h1>");
		 }
		 else {
			//get system date and month
				//get current month
				int month=ldt.getMonthValue();
				//generate the season name based on the current month
				if(month>=3 && month<=6)
					pw.println("<h1 style='color:red;text-align:center;'>summar season</h1>");
				else if(month>=7&&month<=11)
					pw.println("<h1 style='color:red;text-align:center;'>Rainy season</h1>");
				else
					pw.println("<h1 style='color:red;text-align:center;'>Winter season</h1>");
		 }//else
		 
		 //add the home icon
		 pw.println("<br><br><h1 style='color:red:text-align:center'><a href='input.html'>home</a></h1>");
		 
		 //close the stream
		 pw.close();
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}//dopost(-,-)

}
