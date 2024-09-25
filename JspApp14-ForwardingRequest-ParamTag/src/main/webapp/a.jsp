<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<b>Strat of jsp page</b>

<%

float price=567.43f;
float discount=price*0.3f;
float finalprice=price-discount;

%>

<jsp:forward page="b.jsp">
<jsp:param value="CRJ-by HS" name="bookName"/>
<jsp:param value="<%=finalprice %>" name="netPrice"/>
</jsp:forward>
<b>End of jsp page</b>


</body>
</html>