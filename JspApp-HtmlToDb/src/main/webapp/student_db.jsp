<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!-- page directive tags -->
<%@ page import="java.sql.*" %><!-- importing the packages -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	/* global variable */
	Connection con=null;
	PreparedStatement ps1=null,ps2=null;
	
	public void jspInit(){
	//get access to servletConfig object
	ServletConfig cg=getServletConfig();
	//read jdbc properties from web.xml file as init param values
	String driver=cg.getInitParameter("driver");
	String url=cg.getInitParameter("url");
	String username=cg.getInitParameter("username");
	String password=cg.getInitParameter("password");
	
	try{
		//load the jdbc driver class
		Class.forName(driver);
		//establish the connection
		con=DriverManager.getConnection(url,username,password);
		//create the preparedstatement objects represention the sql queries
		ps1=con.prepareStatement("SELECT SNO,SNAME,SADD,AVG FROM STUDENT4");
		ps2=con.prepareStatement("INSERT INTO STUDENT4 VALUES(stud_seq4.NEXTVAL ,?,?,?)");
	}
	catch(SQLException e){
		e.printStackTrace(); 
	}
	catch(Exception e){
		e.printStackTrace(); 
	}
	
}
%>

			<%
		//request processing logic
		//read the additional request param(s1) values
		String pval=request.getParameter("s1");
		if(pval.equalsIgnoreCase("link")){
			//for hyperlink
			//execute the sql query
			ResultSet rs=ps1.executeQuery();
					//process the resultset obj
					%>
					
					<table border="1" align="center" bgcolor="cyan">
							<tr>
								<th>sno</th>
								<th>sname</th>
								<th>sadd</th>
								<th>savg</th>		
							</tr>
					    <%
							while(rs.next()){%>
							<tr>
								<td><%=rs.getInt(1) %></td>
								<td><%=rs.getString(2)%></td>
								<td><%=rs.getString(3) %></td>
								<td><%=rs.getFloat(4) %></td>		
							</tr>
						 <% 
							}//while
					       %>
					</table>
		<% }//if
		else{
			//for submit button
			//read the form data
			String name=request.getParameter("sname");
			String addrs=request.getParameter("sadd");
			float avg=Float.parseFloat(request.getParameter("savg"));
			
			//set value to query param
			ps2.setString(1, name);
			ps2.setString(2, addrs);
			ps2.setFloat(3, avg);
			
			//execute the SQL query
			int result= ps2.executeUpdate();
			
			//process the resultset
			if(result==0){%>
			<h1>Student registration failed</h1>
			<% 
			}
			else{%>
			<h1>Student registration success</h1>
			<% 
			}
		}//else
       %>
       
       <br><br>
       <a href="register.html">home</a>
       
       <%!
       		public void jspDestroy(){
    	   try{
    		   if(ps1!=null)
    			   ps1.close();
    		   }
    	   catch(SQLException e){
				e.printStackTrace(); 
			}
    	   
    	   try{
    		   if(ps2!=null)
    			   ps2.close();
    		   }
    	   catch(SQLException e){
				e.printStackTrace(); 
			}
    	   
    	   try{
    		   if(con!=null)
    			   con.close();
    		   }
    	   catch(SQLException e){
				e.printStackTrace(); 
			}
       }//jspDestroy()
       		
       %>
</body>
</html>