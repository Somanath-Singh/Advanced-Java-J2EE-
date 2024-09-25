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
		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else
			url="https://search.yahoo.com/search?p="+ss;
		//perform the send rediraction
		res.sendRedirect(url);
		//close the stream
		pw.close();
			
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req, res);
	}
}
