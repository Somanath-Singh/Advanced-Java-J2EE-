package som.img.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class AddImageServlet
 */

@MultipartConfig
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//set the response content type
		res.setContentType("text/html");
		//get the stream
		try(PrintWriter pw=res.getWriter();){
			
			//get the image from addimage.jsp page in the form of part
			Part file=req.getPart("image");
			
			String imageName=file.getSubmittedFileName();
			
			System.out.println("Image name:"+imageName);
			
			//after getting this image name get this image path to store the location
			ServletContext context=req.getServletContext();
			String imagePath= context.getRealPath("/")+"pictures"+File.separator+imageName;
			System.out.println("upload path:"+imagePath);
			
			//Upload our selected image into image path
			try(FileOutputStream fos=new FileOutputStream(imagePath);
					InputStream is=file.getInputStream();)
			{
				byte[] data=new byte[is.available()];
				is.read(data);
				fos.write(data);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//store this image name into the database
		
			try{
				//load the driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj414db","root","root");
					String query="insert into storeimage(profile) values (?)";
					PreparedStatement ps=null;
					ps=con.prepareStatement(query);
			
				//set the value to query param
				ps.setString(1, imageName);
				
				//execute the query
				int result =ps.executeUpdate();
				
				if(result==0) {
					System.out.println("Query not executed . ");
				}
				else {
					System.out.println("query executed image added successfully .");
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			pw.println("get image :");
			pw.println("<a href='./DisplayImage.jsp'>img</a>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
