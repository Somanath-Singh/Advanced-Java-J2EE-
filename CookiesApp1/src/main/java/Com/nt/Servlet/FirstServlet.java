package Com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//create 4 cookies (2 inMemory cookies and 2 Persistance cookies)
		
		Cookie ck1=new Cookie("TN","Chennia");
		Cookie ck2=new Cookie("AP","NoCapital");
		
		//add cookies to the response
		res.addCookie(ck1);//inMemory cookie
		res.addCookie(ck2);//inMemory cookie
		
		Cookie ck3=new Cookie("MH","Mumbai");
		Cookie ck4=new Cookie("OR","Bhubaneswar");
		ck3.setMaxAge(60);
		ck4.setMaxAge(90);
		
		//add cookies to the response
				res.addCookie(ck3);
				res.addCookie(ck4);
				
		//get printwriter
				PrintWriter pw=res.getWriter();
				//set the response content tyepe
				res.setContentType("text/html");
				
				pw.println("<h1>Cookies are created</h1>");
				//close the stream
				pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
