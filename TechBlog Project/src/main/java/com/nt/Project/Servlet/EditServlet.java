package com.nt.Project.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.UserDao;
import com.nt.entities.Message;
import com.nt.entities.UserData;
import com.nt.helper.ConnectionProvider;
import com.nt.helper.Helper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set the response content type
		response.setContentType("text/html");
		//get the stream
		try(PrintWriter pw=response.getWriter();){
			/*fetch all data*/
			
			String email=request.getParameter("user-email");
			String pasw=request.getParameter("user-password");
			String about=request.getParameter("user-about");
			
			//get image
			Part part = request.getPart("image");
			String imageName=part.getSubmittedFileName();
			
			//get the user from the session using httpsession object
			HttpSession s=request.getSession();
			UserData user=(UserData)s.getAttribute("currentUser");
			user.setEmail(email);
			user.setPassword(pasw);
			user.setAbout(about);
			
			//set image
			//"oldFile" contain path of old file 
			String oldFile = user.getProfile();
			
			user.setProfile(imageName);
			
			//update database
			UserDao userdao=new UserDao(ConnectionProvider.getConnection());
			
			//pass the user object where all data present
			boolean ans=userdao.updateUser(user);
			if(ans) {
				
				ServletContext context = request.getServletContext();
				String path = context.getRealPath("/")+"pictures"+File.separator+user.getProfile();
				//pictures location
				//C:\Users\rames\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TechBlog Project\pictures
				
				
				//delete old file
				
				ServletContext context1 = request.getServletContext();
				String pathOldFile = context1.getRealPath("/")+"pictures"+File.separator  +  oldFile;
				
				//if the file is other than default file then delete the file
				if(!oldFile.equals("default.png")) {
					Helper.deleteFile(pathOldFile);
				}
				
				if(Helper.saveFile(part.getInputStream() , path)) {
					pw.println("profile updated . ...");
					
					//call the Message class constructor with object creating
					Message msg=new Message("profile details updated . ...","success","alert-success");
					s.setAttribute("message",msg);
					
				}
				else {
					//call the Message class constructor with object creating
					Message msg=new Message("Something went wrong while updating profile  . ...","error","alert-danger");
					s.setAttribute("message",msg);
				}

			}
			else {
				pw.println("User Data not updated");
				//call the Message class constructor with object creating
				Message msg=new Message("Something went wrong . ...","error","alert-danger");
				s.setAttribute("message",msg);
			}
			response.sendRedirect("profile.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
