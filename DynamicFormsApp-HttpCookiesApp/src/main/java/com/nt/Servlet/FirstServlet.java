package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//set the response content type
		res.setContentType("text/html");
		//read the form1 data
		String name=req.getParameter("tname");
		String addrs =req.getParameter("addrs");
		String ms =req.getParameter("ms");
		
		//create inMemory cookies having form1/req1 data and add them to response
		Cookie ck1=new Cookie("cname",name);
		Cookie ck2=new Cookie("caddrs",addrs);
		Cookie ck3=new Cookie("cms",ms);
		//add cookies into response thats way it is visible on globally
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		
		
		//generate the form2 as the dynamic form page based on the maritial status
		if(ms.equalsIgnoreCase("Single")) {
			pw.println("<h1 style='color:red;text-align:center;'>Getting personal details ---form2</h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("When do u want to marry?:: <input type='text' name='f2t1'>");
			pw.println("Why do you want to marry?::<input type='text' name='f2t2'>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>Getting personal details ---form3</h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("Spouse name?:: <input type='text' name='f2t1'>");
			pw.println("No of kids ?::<input type='text' name='f2t2'>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		
		//close the stream
		pw.close();
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
