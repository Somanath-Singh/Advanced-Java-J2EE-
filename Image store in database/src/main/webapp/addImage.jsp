<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add images</title>
</head>
<body>
	<h1 style="color:red;text-align:center;">Add Image</h1>
	
	<div align="center">
		<form action="AddImageServlet" method="POST" enctype="multipart/form-data">
			select image:<input type="file" name="image">
			<input type="submit" value="Add Image">
	</form>
	</div>
</body>
</html>