package Com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set the response content tyepe
		res.setContentType("text/html");
		
		//read cookies
		Cookie cks[]=req.getCookies();
		if(cks!=null) {
			pw.println("<table align='center' border='1'>");
			pw.println("<tr><th>Cookie name</th><th>Cookie value</th><tr>");
			for(Cookie ck:cks) {
				pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td><tr>");
			}//for
		}//if
		
		pw.println("</table>");
		//close the stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
