<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page isErrorPage="true" %>

<h2 style="color=red;text-align:center;"> Internal problem-Try again </h2>

<%=exception.toString()%>

</body>
</html>