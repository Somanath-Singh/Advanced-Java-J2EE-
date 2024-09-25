<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-background ">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><span class="fa fa-cogs">  SoloLearn </span> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><span class="fa fa-500px">Learn with Somanath</span>  </a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="#"><span class="fa fa-address-book"onclick="alert('Please signup to connect with us')">  Contacts</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login-page.jsp"><span class="fa fa-child">  Login</span></a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="registeration-page.jsp"><span class="fa fa-child">  Register</span></a>
        </li>
      </ul>
      <form  action="https://www.google.com/search" method="get"  class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search anything " aria-label="Search" name="q" target="_parent">
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</body>
</html>