<%@page import="com.nt.entities.Message" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    
</head>
<body>
<!-- navbar -->
<%@include file="navbar.jsp"  %>

<main class="d-flex align-items-center primary-background banner-background " style="height:70vh;">
   <div class="container">
         <div class="row">
                  <div class="col-md-4 offset-md-4">
                        
                       <div class="card">
                              <div class="card-header primary-background text-white text-center">
                              <br> 
                              <span class="fa fa-user-plus fa-3x"></span>
                                       <p>Login here</p>
                              </div>
                              
                              <%
                              
                              Message m=(Message)session.getAttribute("message");
                              if(m != null){
                            	  
                            	  %>
                            	   <div class="alert <%= m.getCssClass() %> " role="alert">
 												<%= m.getContent()  %>
								</div>
								<% 
								
								        session.removeAttribute("message");
                                  }
                              
                              %>
                             
                              
                               <div class="card-body"> 
                                       <form action="LoginServlet" method="POST">
                                       
  											<div class="mb-3">
  											  <label for="exampleInputEmail1" class="form-label">Email address</label>
  											  <input type="email" name="email" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    										 <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  											 </div>
  											 
  											 <div class="mb-3">
    												<label for="exampleInputPassword1" class="form-label">Password</label>
  													  <input type="password" name="password" required class="form-control" id="exampleInputPassword1">
  											</div>
  
												  <div class="container text-center">
												      <button type="submit" class="btn btn-primary">Submit</button>
												  </div>
  												
  												
										</form>
                              </div>
                       </div>
                       
                          
                  </div>
         </div>
   </div>
</main>
<!-- Java Script -->
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="js/logic.js" type="text/javascript"></script>
<br><br>
</body>
</html>