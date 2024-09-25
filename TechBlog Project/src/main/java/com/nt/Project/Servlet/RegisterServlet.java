package com.nt.Project.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.UserDao;
import com.nt.entities.UserData;
import com.nt.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set the response content type
		response.setContentType("text/html");
		//get the stream
		try(PrintWriter pw=response.getWriter();){
			/*output of your page here you use the sample code*/
			
			//fetch all form data
			
			String check=request.getParameter("check");
			if(check==null) {
				pw.println("please click on agree terms and condition  ...");
			}
			else
			{
				String name=request.getParameter("user-name");
				String email=request.getParameter("user-email");
				String pasw=request.getParameter("user-pasw");
				String gender=request.getParameter("gender");
				String about=request.getParameter("about");
				
				
				//create a user object and set all data to this object ...
				UserData user=new UserData(name,email,pasw,gender,about);
				
				//create a user dao object
				UserDao dao=new UserDao(ConnectionProvider.getConnection() );
				
				if(dao.addUser(user)) {
					//save
					pw.println("User Registration is Done ...");
				}
				else {
					pw.println("Error in User Registration ....");
				}
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
