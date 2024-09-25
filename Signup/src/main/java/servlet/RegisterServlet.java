package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		 String uname = request.getParameter("name");
	        String uemail = request.getParameter("email");
	        String upwd = request.getParameter("pass");
	        String umobile = request.getParameter("contact");
	        RequestDispatcher dispatcher = null;
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "");
	            PreparedStatement pst = con.prepareStatement("insert into users(uname,upwd,uemail,umobile)values(?,?,?,?)");
	            pst.setString(1, uname);
	            pst.setString(2, upwd);
	            pst.setString(3, uemail);
	            pst.setString(4, umobile);
	            int rowCount = pst.executeUpdate();
	            dispatcher = request.getRequestDispatcher("registration.jsp");
	            if (rowCount > 0) {
	                request.setAttribute("status", "success");
	            } else {
	                request.setAttribute("status", "failed");
	            }
	            dispatcher.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (con != null) {
	                    con.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        pw.println("<h1>Registration success</h1>");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
