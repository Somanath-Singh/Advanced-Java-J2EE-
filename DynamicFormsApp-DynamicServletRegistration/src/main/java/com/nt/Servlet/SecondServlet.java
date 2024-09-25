package com.nt.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	 //get printwriter object
	 		PrintWriter pw=res.getWriter();
	 		//set the response content type
	 		res.setContentType("text/html");
	 		//read the form1/req1 data from hidden boxes(session tracking)
	 		String name=req.getParameter("hname");
			String addrs =req.getParameter("haddrs");
			String ms =req.getParameter("hms");
		
			//read the form2/req2 data
	 		String f2val1=req.getParameter("f2t1");
			String f2val2 =req.getParameter("f2t2");
			
			//display the form data
			pw.println("<h1 style='color:red;text-align:center;'>Form1/request1 data ::"+name+"------"+addrs+"------"+ms+"</h1>");
			pw.println("<h1 style='color:red;text-align:center;'>Form2/request1 data ::"+f2val1+"------"+f2val2+"</h1>");
			
			//add home hyperlink
			pw.println("<br><a href='person-details.html'>home</a>");
			
			//close the stream
			pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
