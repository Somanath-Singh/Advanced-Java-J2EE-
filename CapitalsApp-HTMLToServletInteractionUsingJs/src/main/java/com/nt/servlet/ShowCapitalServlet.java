package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowCapitalServlet extends HttpServlet {
	
	@Override
public void	doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
		//getprintwriter
		PrintWriter pw=res.getWriter();
		//set the response content type
		res.setContentType("text/html");
		//read the form data
		int countryCode=Integer.parseInt(req.getParameter("country"));
		//prepare array having list of capitals
		String capitals[]=new String[] {"New Delhi","Benjing","Katmandu","ISlamabad","WashingtonDC","Canberra"};
		//get capital city name
		String capital=capitals[countryCode];
		pw.println("<h1 style='color:green;text-align:center'>Capitalcity name::"+capital+"</h1>");
		
		
		//add the home hyperlink
		pw.println("<a href='input.html'>home<a/>");
		//close the stream
		pw.close();
		
}//doPost(-,-)

}
