<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SendEmailServlet" method="POST">
		<input type="text" name="sender" placeholder="Enter sender Email id ">
		<input type="text" name="msg" placeholder="Enter message ">
		<button type="submit">send</button>
	</form>
</body>
</html>