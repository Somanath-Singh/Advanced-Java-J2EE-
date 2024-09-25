<%@ page isELIgnored="false"%>

<%
//create diffeenscope of attribute

pageContext.setAttribute("attr1", "val1");//page scope
pageContext.setAttribute("attr2", "val2" , pageContext.REQUEST_SCOPE);//REQUEST SCOPE
pageContext.setAttribute("attr3", "val3" , pageContext.SESSION_SCOPE);//SESSION SCOPE
pageContext.setAttribute("attr4", "val4" , pageContext.APPLICATION_SCOPE);//APPLICATION SCOPE

%>

<!-- FORWARD THE REQUEST -->
<jsp:forward page="b.jsp"/>