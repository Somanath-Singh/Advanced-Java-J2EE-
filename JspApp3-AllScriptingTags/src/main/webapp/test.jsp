<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- if you want to know the class name of any implicit object use -->

<b>out object class name:<%=out.getClass() %></b><br>
<b>request object class name:<%=request.getClass() %></b><br>
<b>response object class name:<%=response.getClass() %></b><br>
<b>page object class name:<%=page.getClass() %></b><br>
</body>
</html> 