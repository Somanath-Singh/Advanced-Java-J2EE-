package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmployeeMgmtOperationController extends HttpServlet {
	
	private IEmployeeMgmtService empService;
	
	public void init()throws ServletException{
		empService =new EmployeeMgmtServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read form data
		String  desg=req.getParameter("desg");
		//read additional req param related to submit buttons
		String caption =req.getParameter("s1");
		
		//use service class
		try {
			List<Employee> list=empService.showEmployeeDesg(desg);
			//keep the results in request scope attributes
			req.setAttribute("empinfo", list);
			//forword the request to view component(jsp pages)
			if(caption.equalsIgnoreCase("HTMLOUTPUT")) {
				RequestDispatcher rd=req.getRequestDispatcher("/html_screen.jsp");
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("/exel_screen.jsp");
				rd.forward(req, res);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");//error page configuration
			rd.forward(req, res);
			}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
