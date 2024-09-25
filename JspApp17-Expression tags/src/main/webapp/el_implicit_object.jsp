<%@ page isELIgnored="false"%>

<b>uname request param value :: ${param.uname}</b><br>
<b>sadd req param multiple values are :: ${paramValues.sadd[0]} , ${paramValues.sadd[1]}</b>

<!-- JspApp17-Expression_tags/el_implicit_object.jsp?uname=raja&sadd=vzg&sadd=hyd -->

<hr>

<b>browser name(user-agent request header value) :: ${header['user-agent']}</b><br>
<b>accept req header values :: ${headerValues.accept[0]},${headerValues.accept[1]}</b>

<hr>
<b>p init param value :: ${initParam.p1}</b><br>
<b>p init param value :: ${initParam.p2}</b>

<hr>

<b>Cookie name holding session id :: ${cookie.JSESSIONID.name}</b><br>
<b>Cookie value holding session id :: ${cookie.JSESSIONID.value}</b>

<hr>