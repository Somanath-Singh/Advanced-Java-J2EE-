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

	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		System.out.println("VoterServlet.doPost(-,-)");
		//get printwriter object from the response object
		PrintWriter pw=res.getWriter(); 
		//set response content type
		res.setContentType("text/html");
		
		//read from data the req obj as the request param value
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		/* int age=Integer.parseInt(tage); */
		String addrs=req.getParameter("paddrs");
		//read the hidden box value
		String vstatus=req.getParameter("vstatus");
		int age=0;
		System.out.println("client side validation status::"+vstatus);
		
	if(vstatus.equalsIgnoreCase("disabled")) {
		//Enable server side form validation logics
		List<String> errorsList=new ArrayList();
		//name validation
		if(name==null || name.equals("") || name.length()==0) {//required rule on name
			errorsList.add("person name is required");
		}
		else if(name.length()<5) {//minlength rule on the name
			errorsList.add("person namemust have >=5letters");
		}
		//age validation
		if(tage==null || tage.equals("")  || tage.length()==0){//required rule on age
			errorsList.add("Person age is required");
		}
		else {
			try {
				age=Integer.parseInt(tage);
				if(age<=0 || age>=126) {//range rule on age
					errorsList.add("person age must be there 1 through 125");
				}
			}
			catch(NumberFormatException nfe) {
				errorsList.add("person age must be numeric value");//age must be numeric value
			}
		}
		
		//address validation
		if(addrs==null || addrs.equals("") || addrs.length()==0) {//required rule on name
			errorsList.add("person address  is required");
		}
		
		//print the error message
		if(errorsList.size()!=0) {
			pw.println("<ol style='color:red'>");
			/*
			 * for(String errMsg:errorsList) {//java5 foreach loop
			 * pw.println("<li>"+errMsg+"</li>"); }//for
			 */			
			errorsList.forEach(msg->{pw.println("<li>"+msg+"</li>");});//java8 forEach method
			
			System.out.println("Server side form validation are on");
			
			pw.println("</ol>");
			pw.println("<br><a href='input.html'>home</a>");
			return ;
		}//if
	}//if
	else {
		age=Integer.parseInt(tage);
	}
		
		//end server side form validation
		
		
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
	
	/*@Override
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
	}*/
}

