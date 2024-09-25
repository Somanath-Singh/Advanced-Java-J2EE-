<%@page isELIgnored="false" import="java.util.*,com.nt.model.*" %>

<%
	//set MIME type
	response.setContentType("application/vnd.ms-excel");
	//make the output of this jsp page as the downloaded file
	 response.setHeader("Content-Disposition","attachment;fileName=empsInfo.xls");
	//read the request attribute value
	List <Employee> list=(List<Employee>)request.getAttribute("empinfo");
	//read request param value
	String desg=request.getParameter("desg");
%>

<!-- Display the details in the form of html table -->

 <h1 style="color:red;text-align:center"> The Employees  Belonging to <%=desg%>  are  </h1>
 
 <%	if(list.size()!=0 && list!=null){ %>
 
<table border="1" bgcolor="cyan" align="center">
<tr>
	<th>empno</th>
	<th>empname</th>
	<th>job</th>
	<th>salary</th>
	<th>Gross Salary</th>
	<th>Net Salary</th>
</tr>
<%
for(Employee emp:list){
%>

<tr>
<td><%=emp.getEno() %></td>
<td><%= emp.getEname()%></td>
<td><%=emp.getJob() %></td>
<td><%=emp.getSalary() %></td>
<td><%=emp.getGrossSalary() %></td>
<td><%=emp.getNetSalary() %></td>
</tr>

<%
}
%>

</table>
<%
}//if
	else{
%>

<h1 style="color:red;text-align:center">No Employee are found </h1>

<%} %>
