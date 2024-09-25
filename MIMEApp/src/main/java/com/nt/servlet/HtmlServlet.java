//HtmlServlet.java
package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;



public class HtmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//set the response content type
		res.setContentType("text/html");
		//get printwriter stream obj
		PrintWriter pw=res.getWriter();
		//write the messages to res object 
		pw.println("<table border='1' align='center' bgcolor='lime'>");
		pw.println("<tr><td>player</td> <td>sport</td> <td>country</td></tr>");
        pw.println("<tr><td>dhoni</td> <td>cricket</td> <td>India</td></tr>");
		pw.println("<tr><td>sachin</td> <td>cricket</td> <td>India</td></tr>");
		pw.println("<tr><td>sania</td> <td>tennis</td> <td>India</td></tr>");
		pw.println("<tr><td>sindhu</td> <td>batminton</td> <td>India</td></tr>");
		pw.println("</table>");
		 //enable auto refresh on the generated webpage
		 res.setHeader("refresh","10");

		//generate the system date and time
		Date d=new Date();
		//write the response object
		pw.println("<br><h1>Date and time is "+d+"</h1>");
		//close the stream
		pw.close();
	}

}






