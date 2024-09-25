package com.nt.Project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.UserDao;
import com.nt.entities.Message;
import com.nt.entities.UserData;
import com.nt.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set the response content type
				response.setContentType("text/html");
				//get the stream
				try(PrintWriter pw=response.getWriter();){
					/*output of your page here you use the sample code*/
					//login
					//fetch all username and password
					String userName=request.getParameter("email");
					String userPassword=request.getParameter("password");
					//create object of UserDao class
					UserDao dao=new UserDao(ConnectionProvider.getConnection());
					//check the user email and password is present in the database or not
					UserData u=dao.getUserByEmailAndPassword(userName, userPassword);
					
					if(u==null) {
						//login error
						/* pw.println("Invalid details try again ....."); */
						//call the Message class constructor with object creating
						Message msg=new Message("Invalid details try with another ...","error","alert-danger");	
						//create session object
						HttpSession s= request.getSession();
						s.setAttribute("message",msg);
						//when error user ivalid user email and password enter then we rediret this message into login page
						response.sendRedirect("login-page.jsp");
					}
					else {
						//login success
						
						//get httpsession object
						HttpSession s=request.getSession();
						s.setAttribute("currentUser", u);
						response.sendRedirect("profile.jsp");
					}
				}
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
