package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/testurl")
public class TestServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//set the response content type
		res.setContentType("text/html");
		//get the printwriter object
		PrintWriter pw=res.getWriter();
		//request scope data
		req.setAttribute("attr1", "val1");
		//session scope data
		HttpSession ses=req.getSession();
		ses.setAttribute("attr2","val3");
		//application scope data
		ServletContext sc=req.getServletContext();
		sc.setAttribute("attr3", "val3");
		
		//forward the request
		RequestDispatcher rd=req.getRequestDispatcher("/el_scope_objects.jsp");
		rd.forward(req, res);
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		super.doPost(req, res);
	}
}
