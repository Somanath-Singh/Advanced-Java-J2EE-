package com.nt.Project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.entities.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set the response content type
		response.setContentType("text/html");
		//get the stream
		try(PrintWriter pw=response.getWriter();){
			/*output of your page here you use the sample code*/
			//create sesion object
			HttpSession s=request.getSession();
			
			s.removeAttribute("currentUser");
			//create the Message class object
			Message m=new Message("Logout Successfully" , "Success" , "alert-success");
			s.setAttribute("message", m);
			//get back to login-page
			response.sendRedirect("login-page.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
