package com.nt.Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//add request attributes
		req.setAttribute("attr1", "val1");
		
		//create HttpSession object
		HttpSession ses=req.getSession();
		ses.setAttribute("attr2", "val2");
		
		//create servletSession object
		ServletContext sc=req.getServletContext();
		sc.setAttribute("attr3", "val3");
		
		//forward the request to servlet2
		RequestDispatcher rd=req.getRequestDispatcher("/s2url");
		rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
