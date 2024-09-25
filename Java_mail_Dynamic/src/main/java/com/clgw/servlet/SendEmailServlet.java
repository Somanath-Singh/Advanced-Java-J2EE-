package com.clgw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.clgw.helper.Mail;
import com.clgw.javabeans.MailJavaBeans;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmailServlet
 */
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//set response content type
		res.setContentType("text/html");
		//get the printwriter object
		PrintWriter pw=res.getWriter();
		String sender=req.getParameter("sender");
		String msg=req.getParameter("msg");
		
		//create the object of java beans class
			MailJavaBeans m=new MailJavaBeans();
			//pass the value through getter and setter method
			m.setToUser(sender);
			m.setMsg(msg);
			pw.println("<h1>run</h1>");
			pw.println("<h1>run 1</h1>");
			//create the Mail class object to call the Mail class
			Mail mail=new Mail();
			mail.setupServerProperties();
			pw.println("<h1>run 2</h1>");
			
			
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		
	}

}
