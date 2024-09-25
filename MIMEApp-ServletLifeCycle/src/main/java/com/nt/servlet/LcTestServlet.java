package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet:statis block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet:0-param constructor");
	}

	private ServletConfig cg;
	  public void init(ServletConfig cg) {
		  this.cg=cg;
	  System.out.println("LcTestServlet:init() method"); String
	 val1=cg.getInitParameter("p1"); String val2=cg.getInitParameter("p2");
	  System.out.println("from init method"+val1+".... .."+val2);
	  
	  }
	 
	//recomended to use init with parameter method
	/*
	 * public void init() { System.out.println("LcTestServlet:init() "); //GET
	 * ACCESS TO SERVLET CONFIG OBJECT ServletConfig cg=getServletConfig(); String
	 * val1=cg.getInitParameter("p1"); String val2=cg.getInitParameter("p2");
	 * System.out.println(val1+"......"+val2); }
	 */
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("LCTestServlet.service(-,-)");
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//set responce contenttype
		res.setContentType("text/html");
		//write output content to responce object
		pw.println("<h1 style='color:red;text-align:center;'>Date and time is::"+new Date()+"</h1>");
		
		//ServletConfig is declared globaly 
		//if you use init with out parameter then not need to commentout "ServletConfig cg=getServletConfig();" otherwise
		//ServletConfig cg=getServletConfig();
		String val1=cg.getInitParameter("p1");
		String val2=cg.getInitParameter("p2");
	    System.out.println("form service"+val1+"......"+val2);
	    
		//close the stream
		pw.close(); 
	}
	
	public void destroy() {
		System.out.println("LCTestServlet:destroy()");
	}
}
