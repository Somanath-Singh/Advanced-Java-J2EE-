<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	public String generateWishMessage(String user){
		//get system date and time
		java.time.LocalDateTime idt=java.time.LocalDateTime.now();
		//get current hour of the day
		int hour=idt.getHour();
		//generate wish message
		if(hour<12)
			return "Good Morning::"+user;
			else if(hour<16)
				return "Good Afternoon::"+user;
			else if(hour<20)
				return "Good Evening::"+user;
			else
				return "Good Night::"+user;
		
    }
%>

<h1 style="color:red;text-align:center;">Welcome java server page:</h1>
<h2 style="color:red;text-align:center;">Date and Time<%=new java.util.Date() %></h2>

<%
	String user=request.getParameter("uname");//user name as request parameter value
%>

<h2>the wish message is ::<%=generateWishMessage(user) %></h2>


</body>
</html>