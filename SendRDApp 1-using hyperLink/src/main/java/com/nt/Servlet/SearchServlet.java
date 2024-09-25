package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set response content type
		res.setContentType("text/html");
		//get printwriter object
		PrintWriter pw=res.getWriter();
		//read the form data
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		//generate the webpages having hyperlink to complete the send rediriction
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>Click hear for google search</a></h1>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>Click hear for Bing search</a></h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'><a href='https://search.yahoo.com/search?p="+ss+"'>Click hear for Yahoo search</a></h1>");
		//close the stream
		pw.close();
			
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req, res);
	}
}
