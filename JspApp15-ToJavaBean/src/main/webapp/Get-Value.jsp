<%@ page isELIgnored="false"  import="java.util.*"%>

<!-- create or locate java bean class object -->
<jsp:useBean id="st" class="com.nt.bean.StudentBean" scope="session" />

<!-- get data from  java bean class object -->

<b>sno=</b><jsp:getProperty  name="st" property="sno"/>
<b>sname=</b><jsp:getProperty  name="st" property="sname" />
<b>sadd=</b><jsp:getProperty  name="st" property="sadd" />
<b>m1=</b><jsp:getProperty  name="st" property="m1" />
<b>m2=</b><jsp:getProperty  name="st" property="m2" />
<b>m3=</b><jsp:getProperty  name="st" property="m3" />


<h1>Values areread and display </h1>