<%@ page isELIgnored="true" import="com.nt.service.*,com.nt.model.*"%>
<!-- import the both package to use the class present inside pacakge -->

<!-- create or locate java bean class object -->

<jsp:useBean id="emp" class="com.nt.model.Employee" scope="request" />

<!-- write form data to model class object  -->
<jsp:setProperty property="*" name="emp"/>


<!-- create service class object -->
<jsp:useBean id="empService" class="com.nt.service.EmployeeManagemtService" scope="application"/>

<!-- call the business method -->

<jsp:scriptlet>

	empService.generatePaySlip(emp);

</jsp:scriptlet>

<!-- read and display the inputs and outputs on to the web page -->

<h3 style="color:red;text-align:center">

	<!-- another way of get value -->
	<b>employee number::<%=emp.getEno() %></b><br>
	
	<b>employee number::<jsp:getProperty  name="emp" property="eno"/></b><br>
	<b>employee name::<jsp:getProperty  name="emp" property="ename"/></b><br>
	<b>employee salary::<jsp:getProperty  name="emp" property="salary"/></b><br>
	<b>employee address::<jsp:getProperty  name="emp" property="address"/></b><br>
	<b>employeegrossSalary::<jsp:getProperty  name="emp" property="grossSalary"/></b><br>
	<b>employee netSalary::<jsp:getProperty  name="emp" property="netSalary"/></b><br>

</h3>

<!-- home hyperrlink -->









<br><br>

<a href="employee-details.html">home</a>