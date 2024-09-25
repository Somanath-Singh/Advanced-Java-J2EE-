<%@page import="com.nt.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!-- import the database package to access it -->
<%@page import="java.sql.*"  %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
    
<style>
	*{
    margin: 0;
    padding: 0;
}
	 /* footer */
.footer{
   width: 100%;
   text-align: center;
   padding: 30px 0;
}
.footer h4{
   margin-bottom: 25px;
   margin-top: 20px;
   font-weight: 600;
}
.icons .fa{
   color: #f44336;
   margin: 0 13px;
   cursor: pointer;
   padding: 18px 0;
}
.fa-heart{
   color: #1fd145;
}
.footer-background-con{
	background-image:url("./images/pattern.png");
	background-position:center;
	background-size:300px;
	
	width:100%;
	background-color:#00f2ffa8;
	font-family: 'Baloo Bhai 2', cursive;
	font-size:25px;
	height:60px;
	padding:10px 30px;
	}
.footer-background-copy{
	text-align:right;
	width:100%;
	background-color:rgba(0, 0, 0, 0.696);
	font-family: 'Baloo Bhai 2', cursive;
	font-size:15px;
	height:60px;
	padding:13px 35px;
	margin-bottom:10px;
	color:white;
}

/* cta */
.cta{
   width: 80%;
   margin: 100px auto;
   text-align: center;
   background-image: linear-gradient(rgba(2, 12, 206, 0.7),rgba(31, 87, 255, 0.582)),url(./images/ctaback.jpg);
   background-position: center;
   background-size: cover;
   border-radius: 10px;
   padding: 100px 0;
}
.cta h1{
   color: #fff;
   margin-bottom: 40px;
   padding: 0;
}
@media(max-width:700px){
   .cta h1{
      font-size: 24px;
   }
}
.hero_btn{
   display: inline-block;
   text-decoration: none;
   color: #fff;
   border: 1px solid #fff;
   padding: 12px 34px;
   font-size: 13px;
   background: transparent;
   position: relative;
   cursor: pointer;
 }
 .hero_btn:hover{
  border: 1px solid #f44336;
   background: #f44336;
   transition: 1s;
 }
</style>
</head>

<body>

<!-- navbar -->
<%@include file="navbar.jsp"  %>

<!-- banner -->
<div class="container-fluid p-0 m-0">


     <div class="jumbotron primary-background text-white banner-background">
     
       <div class="container content-padding">
       
          <h3 class="Display-3">Welcome to TechBlog</h3>
          <p>Welcome to technical blog, World .A programming language is a system of notation for writing computer programs.[1] Most programming languages are text-based formal languages, but they may also be graphical. They are a kind of computer language.</p>
        
          <p>The description of a programming language is usually split into the two components of syntax (form) and semantics (meaning), which are usually defined by a formal language.</p>
        
        
        <a class="btn btn-outline-light btn-lg"  href="starts_it_free.jsp"><span class="fa fa-drivers-license"></span>  Start ! its free</a>
        <a class="btn btn-outline-light btn-lg" href="login-page.jsp"><span class="fa fa-child fa-spin" ></span>  Login</a>
       </div>
       
     </div>
     
     
</div>



  <!-- card -->


<br>

 <!-- cards -->

		<div class="container">
			<div class="row">
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">	HTML</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">CSS</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">JAVA SCRIPT</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
</div>
		</div>
		
		<div class="container">
			<div class="row">
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">JAVA Programming</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">PYTHON Programming</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card text-center">
      <div class="card-body">
        <h5 class="card-title">C++ Programming</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="login-page.jsp" class="btn primary-background text-white">Know More....</a>
      </div>
    </div>
  </div>
</div>
</div>


   <section class="cta">
        <h1>Enroll For Our Various Online Courses <br> Anywhere From The World</h1>
        <a href="#" class="hero_btn" style="font-size:15px;">Join Us</a>
    </section>
    
<section class="footer">
        <h4>About Us</h4>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo quam, pariatur <br> nemo dolorum sint similique sunt numquam </p>
        <div class="icons">
        <span class="fa fa-facebook" style="color:blue;" ></span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="fa  fa-twitter" ></span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="fa fa-instagram" ></span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="fa  fa-linkedin" ></span>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        <p>Made with <span class="fa  fa-heart" ></span> by Somanath  and  Trilochan ....</p>
    </section>
	
	 <br><br>
    <footer align="center" class="footer-background-con text-white">
    	<p>------/Thanks for visit our website./------</p>
    </footer>
    
    
    <footer align="center" class="footer-background-copy">
    	<p>Copyrights © 2023 SOLOLEARN. All Rights Reserved.</p>
    </footer>

<!-- Java Script -->
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="js/logic.js" type="text/javascript"></script>



</body>
</html>

<!-- Checking the database is connected successfully -->
<%-- <h1>Hello world</h1>
<%
Connection con=ConnectionProvider.getConnection();
%>
<h1><%=con  %></h1> --%>