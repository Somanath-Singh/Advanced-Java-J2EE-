package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormProcessingServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			//set response content type
		res.setContentType("text/html");
		//get printwriter Stream
		PrintWriter pw=res.getWriter();
		//read from data
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("ages"));
		String address=req.getParameter("addrs");
		String gender=req.getParameter("gender");
		String hobies[]=req.getParameterValues("hb");
		//handle no select state for the checkbox
		hobies=(hobies==null)?new String[] {"no hobies"}:hobies;
		String ms=req.getParameter("ms");
		//handle no select state for the checkbox
		ms=(ms==null)?"single":ms;
		String qlfy=req.getParameter("qlfy");
		String favplaces[]=req.getParameterValues("favplaces");
		//handle no select state for the list box
		favplaces=(favplaces==null)?new String[] {"no-fav-palces"}:favplaces;
		long phone=Long.parseLong(req.getParameter("mobileno"));
		String favcolor=req.getParameter("favcolor");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String doj=req.getParameter("doj");
		int favno=Integer.parseInt(req.getParameter("favnum"));
		String mail=req.getParameter("email");
		String week=req.getParameter("fredomweek");
		String instaurl=req.getParameter("instaurl");
		String ss=req.getParameter("ss");
		long incom=Long.parseLong(req.getParameter("incom"));
		
		//write the business logic
		if(gender.equalsIgnoreCase("M")) {
			
			if(age<=5) {
				pw.println("<h1>master."+name+"u r baby boy</h1>");
			}
			else if(age<=12) {
				pw.println("<h1>master."+name+"u r small boy</h1>");
			}
			else if(age<=19) {
				pw.println("<h1>Mr."+name+"u r teenage boy</h1>");
			}
			else if(age<=35) {
				pw.println("<h1>Mr."+name+"u r middle age man</h1>");
			}
			else if(age<=50) {
				pw.println("<h1>Mr."+name+"u r senior citizen man</h1>");
			}
			else {
				pw.println("<h1>Mr."+name+"u r senior citizen man</h1>");
			}
		}
		else 
		{
			if(age<=5) {
				pw.println("<h1>master."+name+"u r baby girl</h1>");
			}
			else if(age<=12) {
				pw.println("<h1>master."+name+"u r small girl</h1>");
			}
			else if(age<=19) {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h1>Mrs."+name+"u r teenage girl</h1>");
				}
				else {
					pw.println("<h1>Miss."+name+"u r teenage girl</h1>");
				}	
			}
			else if(age<=35) {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h1>Mrs."+name+"u r middle young woman</h1>");
				}
				else {
					pw.println("<h1>Miss."+name+"u r middle young woman</h1>");
				}
			}
			else if(age<=50) {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h1>Mrs."+name+"u r middle aged woman</h1>");
				}
				else {
					pw.println("<h1>Miss."+name+"u r middle aged woman</h1>");
				}
			}
			else {
				if(ms.equalsIgnoreCase("married")) {
					pw.println("<h1>Mrs."+name+"u r senior citizen woman</h1>");
				}
				else {
					pw.println("<h1>Miss."+name+"u r senior citizen woman</h1>");
				}
			}
		}
		
		
		//print the form data
		pw.println("<b>Name::"+name+"</b><br>");
		pw.println("<b>Age::"+age+"</b><br>");
		pw.println("<b>Address::"+address+"</b><br>");
		pw.println("<b>Gender::"+gender+"</b><br>");
		pw.println("<b>Hobies::"+Arrays.toString(hobies)+"</b><br>");
		pw.println("<b>Qualification::"+qlfy+"</b><br>");
		pw.println("<b>Maritial Status::"+ms+"</b><br>");
		pw.println("<b>Fav places::"+Arrays.toString(favplaces)+"</b><br>");
		pw.println("<b>Phone Number::"+phone+"</b><br>");
		pw.println("<b>Fav color::"+favcolor+"</b><br>");
		pw.println("<b>fav Number::"+favno+"</b><br>");
		pw.println("<b>DOB::"+dob+"</b><br>");
		pw.println("<b>TOB::"+tob+"</b><br>");
		pw.println("<b>DOJ::"+doj+"</b><br>");
		pw.println("<b>Instal URL::"+instaurl+"</b><br>");
		pw.println("<b>Fredom Week::"+week+"</b><br>");
		pw.println("<b>Search Item::"+ss+"</b><br>");
		pw.println("<b>Mail Id::"+mail+"</b><br>");
		pw.println("<b>income::"+incom+"</b><br>");
		
		//add home hyperlink
		pw.println("<h1 style='color:red;text-align:center'><a href='input.html'>home</a></h1>");
		
		//close the stream
		pw.close();
				
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}
