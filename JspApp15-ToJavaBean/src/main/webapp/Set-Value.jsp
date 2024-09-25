<%@ page isELIgnored="false"  import="java.util.*"%>

<!-- create or locate java bean class object -->
<jsp:useBean id="st" class="com.nt.bean.StudentBean" scope="session" />

<!-- set data to java bean class object -->
<!-- values are hard coaded -->
<!-- 
<jsp:setProperty  name="st" property="sno" value="1001"/>
<jsp:setProperty  name="st" property="sname" value="somanath"/>
<jsp:setProperty  name="st" property="sadd" value="jatani"/>
<jsp:setProperty  name="st" property="m1" value="30"/>
<jsp:setProperty  name="st" property="m2" value="45"/>
<jsp:setProperty  name="st" property="m3" value="60"/>
 -->

<!-- set request param values as the bean property values -->
<!-- 
<jsp:setProperty  name="st" property="sno"  param="no"/>
<jsp:setProperty  name="st" property="sname" param="name"/>
<jsp:setProperty  name="st" property="sadd" param="addrs" />
<jsp:setProperty  name="st" property="m1"  param="mk1" />  
<jsp:setProperty  name="st"  property="m2" param="mk2" />
<jsp:setProperty  name="st" property="m3" param="mk3" />
 -->

<!-- if the request param names are matching with bean property names then use "*" to set request param values as the bean property names  -->
<jsp:setProperty  name="st" property="*" />

<h1>Values are set to bean class object </h1>