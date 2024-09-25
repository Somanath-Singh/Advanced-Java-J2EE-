package com.nt.Project.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.PostDao;
import com.nt.entities.Post;
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
 * Servlet implementation class AddPostServlet
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set the response content type
		response.setContentType("text/html");
		//get the stream
		try(PrintWriter pw=response.getWriter();){
			/*output of your page here you use the sample code*/
			
			int cid=Integer.parseInt(request.getParameter("cid"));
			String pTitle=request.getParameter("ptitle");
			String pContent=request.getParameter("pcontent");
			String pCode=request.getParameter("pcode");
			
		    Part part=request.getPart("pPic");
		    
		  //get image
            //part.getSubmittedFileName() this method return the name of selected file
			String image=part.getSubmittedFileName();

			
			//getting current userid
			
			//get httpsession object
			HttpSession session = request.getSession();
			UserData user=(UserData)session.getAttribute("currentUser");
			 
			
			//create the object of post class
			Post p=new Post(pTitle,pContent,pCode ,image,null,cid,user.getId());
			
			//create the object of postdao
			PostDao dao=new PostDao(ConnectionProvider.getConnection());
			
			if(dao.savePost(p)) {
				
				//store the post pictures in the files 
				ServletContext context = request.getServletContext();
				String path = context.getRealPath("/")+"post-pics"+File.separator+image;
				Helper.saveFile(part.getInputStream(), path);
				//path C:\Users\rames\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TechBlog Project\post-pics
				
				pw.println("done");
			}
			else {
				pw.println("error");
				
			}//if
		}//try
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
