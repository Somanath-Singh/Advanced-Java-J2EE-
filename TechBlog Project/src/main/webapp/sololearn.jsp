<%@page import="com.nt.entities.UserData" %>
<%@page import="com.nt.entities.Post" %>
<%@page import="com.nt.helper.ConnectionProvider" %>
<%@page import="com.nt.dao.PostDao" %>
<%@page import="com.nt.dao.UserDao" %>
<%@page import="com.nt.entities.Message" %>
<%@page import="com.nt.entities.Category" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.DateFormat" %>


<!-- if any error the it open error page -->
<%@page errorPage="error-page.jsp" %>

<!-- it validate the user is login or not -->
<%

UserData user=(UserData)session.getAttribute("currentUser");
if(user==null)
{
	response.sendRedirect("login-page.jsp");
}

%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SoloLearn</title>
   <!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="css/learn.css" rel="stylesheet" type="text/css">
  
  <link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    
  <style>
  .link-hover  ul li a:hover{
  	color:#0be881;
  }
  </style>
</head>
<body>

		 

		<div class="banner  mb-5">

            <video autoplay loop muted plays-inline>
                <source src="./images/background.mp4" type="video/mp4">
            </video>
           

            <div class="content">
            
            <!-- navbar -->
   
   
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-background fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><span class="fa fa-cogs"></span>  SoloLearn</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="profile.jsp"><span class="fa fa-500px"></span>  Learn with Somanath</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="contact.jsp"><span class="fa fa-address-book"></span>  Contacts</a>
          </li>
           <li class="nav-item">
          <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#addPostModel"><span class="fa fa-asterisk"></span>  Post </a>
          <li class="nav-item">
           <li class="nav-item">
          <a class="nav-link" href="profile.jsp"><span class="fa"></span> Home</a>
          </li>
           <li class="nav-item">
          <a class="nav-link" href="sololearn.jsp"><span class="fa"></span> SoloLearn</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="https://www.programiz.com/c-programming/online-compiler/"><span class="fa"></span> {/} Code here</a>
        </li>
      </ul>
      
      <ul class="navbar-nav mr-right">
      
       <li class="nav-item">
          <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#profile-model" ><span class="fa fa-user-circle"></span> <%= user.getName() %></a>
        </li>
        
       <li class="nav-item">
          <a class="nav-link" href="LogoutServlet"><span class="fa fa-child"></span>  Logout </a>
        </li>
      
      
      </ul>
    </div>
  </div>
</nav>
   
   
   <!-- navbar end -->
            
            <br><br>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 p-5" >
                            <div class="card link-hover" style="width: 18rem;height:440px;">
                                <img src="images/c.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">C  language</h5>
                                    <p class="card-text">C is a general-purpose computer programming language. </p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLdo5W4Nhv31a8UcMN9-35ghv8qyFWD9_S&si=I0ceWtsCbYslW0_s" class="card-link text-dark">Jennys lecture</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLiOa6ike4WAHH3HyPUu6pUG-r0LApvW-l&si=8XxkL_RE0BykUySE" class="card-link text-dark">easytuts4you</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLBlnK6fEyqRggZZgYpPMUxdY1CYkZtARR&si=zImCGFqrWRGkhI48" class="card-link text-dark">Neso academy</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/c++.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">C++ language</h5>
                                    <p class="card-text">C++ was developed by Bjarne Stroustrup, as an extension to the C language. </p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLfqMhTWNBTe0b2nM6JHVCnAkhQRGiZMSJ&si=cBHMNfCgrYpAhkpn" class="card-link text-dark">Apna collage</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLu0W_9lII9agpFUAlPFe_VNSlXW5uE0YL&si=YbP_ofAREkDdxVY_" class="card-link text-dark">Code with harry</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLLYz8uHU480j37APNXBdPz7YzAi4XlQUF&si=UNLEprsHCFVoxcZu" class="card-link text-dark">Sourabh sukla</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/java.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Java language</h5>
                                    <p class="card-text">Java is a popular programming language. It is owned by Oracle, and more than 3 billion devices run Java.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLlhM4lkb2sEhfuXL-2BDrJ67WkUdQ2v9b&si=rpOQ-vSFdP5egWUt" class="card-link text-dark">Smart programming</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLd3UqWTnYXOmx_J1774ukG_rvrpyWczm0&si=LiGg6WnwF0D5-k8p" class="card-link text-dark">Durga soft</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLVlQHNRLflP8J1HiUMV1oC02Zu2CKvvuk&si=MAVTypcgNDC2Idm6" class="card-link text-dark">naresh it</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5" >
                            <div class="card" style="width: 18rem;overflow:auto;height:440px;">
                                <img src="./images/python.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Python language</h5>
                                    <p class="card-text">Python is a high-level, general-purpose programming language. </p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLu0W_9lII9agwh1XjRt242xIpHhPT2llg&si=rTixiMpnRdoTnzq1" class="card-link text-dark">code with harry</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/sCOw5y1RQpY?si=oMpkBxQa29FkgVjP" class="card-link text-dark">One short</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLLOxZwkBK52DmuHRO3UNpqAzDF57FtIxk&si=uUljJe4VUqeqlA5v" class="card-link text-dark">Sundeep Saradhi Kanthety</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/html.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Html</h5>
                                    <p class="card-text">HTML is the standard markup language for Web pages. With HTML you can create your own Website.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtu.be/QXPWs00RD3A?si=aqORGfZS6bKK5lOA" class="card-link text-dark">Techblog</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLu0W_9lII9agiCUZYRsvtGTXdxkzPyItg&si=uIXRxoTcjAH9v2B8" class="card-link text-dark">Code with harry</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/rklidcZ-aLU?si=0Ut2euutoC4Hy8D-" class="card-link text-dark">KG coading</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/css.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Css</h5>
                                    <p class="card-text">CSS is the language we use to style an HTML document. CSS describes how HTML elements should be displayed. </p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtu.be/WyxzAU3p8CE?si=at7dzA-GpQiwJ0n6" class="card-link text-dark">Tech blog</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/ESnrn1kAD4E?si=YyIB1e32lLZ89EiN" class="card-link text-dark">Apna collage</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/MSICFljRcb4?si=MC-MIz_UaP08-LBt" class="card-link text-dark">Thapa technical</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/js.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Java Script</h5>
                                    <p class="card-text">JavaScript often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLu0W_9lII9ahR1blWXxgSlL4y9iQBnLpR&si=39HqT-CMCpRq2xkN" class="card-link text-dark">Code with harry</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLjpp5kBQLNTSvHo6Rp4Ky0X8x_MabmKye&si=pwjbI4SrX03zqhCK" class="card-link text-dark">Tech blog</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/sscX432bMZo?si=wJtQGdwLGmgxn4hg" class="card-link text-dark">one short</a></li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;height:440px;">
                                <img src="./images/r.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">R language</h5>
                                    <p class="card-text">R is a programming language for statistical computing and graphics supported by the R . </p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLjVLYmrlmjGdmPrz0Lx7smkd0qIKHInOF&si=8q7eem8dMswWQLw2" class="card-link text-dark">WsCube Tech</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLYwpaL_SFmcCRFzBkZ-b92Hdg-qCUfx48&si=Ga8Yk_GqHv9Mdmh4" class="card-link text-dark">5 Minutes Engineering</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/NDto4BVHz4s?si=TO6AQCyjHlzuimbo" class="card-link text-dark">One short</a></li>
                                </ul>
                            </div>
                        </div>
                        
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;">
                                <img src="./images/adv.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Advanced Java</h5>
                                    <p class="card-text">JavaScript often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLVlQHNRLflP9OiTKTQuq3UWJNA_wOPlFr&si=hjd8sR8I9ECJLW1S" class="card-link text-dark">Natraj sir</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLd3UqWTnYXOniKfYRNY___weULTRd9Co0&si=rpTpInEhvxYV68CK" class="card-link text-dark">JDBC</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PL0zysOflRCel5BSXoslpfDawe8FyyOSZb&si=hUaYS8pEfCUUCxpK" class="card-link text-dark">Learn code with Durgesh</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;">
                                <img src="./images/sql.jpg" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">Sql</h5>
                                    <p class="card-text">JavaScript often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLsjUcU8CQXGFFAhJI6qTA8owv3z9jBbpd&si=EANrkcMdXNSv0wZT" class="card-link text-dark">QAFox</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/-fW2X7fh7Yg?si=HN9UbFk8XocbxdfI" class="card-link text-dark">One short</a></li>
                                    <li class="list-group-item"><a href="https://youtu.be/hlGoQC332VM?si=UfCB1gezEH4EXX2_" class="card-link text-dark">One short</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;">
                                <img src="./images/dsa.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">data structure</h5>
                                    <p class="card-text">JavaScript often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLdo5W4Nhv31bbKJzrsKfMpo_grxuLl8LU&si=x7hgAaqoBnRC_gJC" class="card-link text-dark">Jennys lecture</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&si=32_B16xoxWfClASj" class="card-link text-dark">Love Babber</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&si=6UM1baOn7V8SPgGH" class="card-link text-dark">Kunal Kushwaha</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 p-5">
                            <div class="card" style="width: 18rem;">
                                <img src="./images/jquery.png" class="card-img-top" alt="..." class="img-fluid" height="150px">
                                <div class="card-body">
                                    <h5 class="card-title">jquery</h5>
                                    <p class="card-text">JavaScript often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><a href="https://youtu.be/Yofox_h4zGQ?si=qSKKDUnYGLHwa-Wj" class="card-link text-dark">Tech blog</a></li>
                                    <li class="list-group-item"><a href="https://youtube.com/playlist?list=PL0b6OzIxLPbzSyiC0PFaqeabe1aGhfrbW&si=YBhxTrwW1OfiKjpA" class="card-link text-dark">Yahoo Baba</a></li>
                                     <li class="list-group-item"><a href="https://www.youtube.com/live/Rkvn_MA04fo?si=7DJyjzVLxaFwKNDX" class="card-link text-dark">Simplelearn</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="container text-center">
                	<div class="row">
                			<div class="col-lg-2 col-6  p-4">
                				<div class="card" style="width: 10rem;">
  									<a href="https://www.programiz.com/" class="card-link text-dark"><img src="./images/programmize.jpg" class="card-img-top" alt="..." width="100%"></a>
								</div>
                			</div>
                			
                			<div class="col-lg-2 col-6  p-4">
                				<div class="card" style="width: 10rem;">
  									<a href="https://www.geeksforgeeks.org/" class="card-link text-dark"><img src="./images/gfg.jpg" class="card-img-top" alt="..." width="100%"></a>
								</div>
                			</div>
                			
                			<div class="col-lg-2 col-6  p-4">
                				<div class="card" style="width: 10rem;">
  									<a href="https://www.javatpoint.com/" class="card-link text-dark"><img src="./images/tpoint.png" class="card-img-top" alt="..." width="100%"></a>
								</div>
                			</div>
                			
                			<div class="col-lg-2 col-6  p-4">
                				<div class="card" style="width: 10rem;">
  									<a href="https://www.w3schools.com/" class="card-link text-dark"><img src="./images/w3s.png" class="card-img-top" alt="..." width="100%"></a>
								</div>
                			</div>
                			
                			<div class="col-lg-2  col-6  p-4">
                				<div class="card" style="width: 10rem;">
  									<a href="https://www.tutorialspoint.com/index.htm" class="card-link text-dark"><img src="./images/tutorials.png" class="card-img-top" alt="..." width="100%"></a>
								</div>
                			</div>
                			
                			<div class="col-lg-2  col-6  p-4">
                				<div class="card" style="width: 10rem;height: 10rem;">
  									<a href="https://www.hackerrank.com/" class="card-link text-dark"><img src="./images/hacker.jpg" class="card-img-top" alt="..."  style="width:100%; height:fit-content;"></a>
								</div>
                			</div>
                			
                	</div>
                </div>
                
                <div class="container mb-5 text-center">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card bg-dark text-white">
                                <img src="./images/p.jpg" class="card-img" alt="..." height="350px">
                                <div class="card-img-overlay">
                                    <h5 class="card-title">Projects</h5>
                                    <p class="card-text">Simply put, a project is a series of tasks that need to be completed to reach a specific outcome. </p>
                                    <p>Frontend projects: <a href="https://youtube.com/playlist?list=PL9fjioyw5JU5sMf8I51K4NWON869Ps01T&si=SRu-1Qg4bKzV6FkM">Click here</a></p>
                                     <p>Javascript projects: <a href="https://youtube.com/playlist?list=PLajjpPyc2dmbt0KebBvT9VQV8y2R_IO7j&si=hsH1rTmP2sadeMh-">Click here</a></p>
                                     <p>Core java projects: <a href="https://youtu.be/GEKF890oQYc?si=STfXsTboh6Aw8Nm8">Click here</a></p>
                                      <p>Advanced java projects: <a href="https://youtube.com/playlist?list=PLQTYNpk8jwk33-kHcV0xdBy4L617EVnAt&si=h7I6S08CKnANGw49">play list 1</a>
                                      	 <a href="https://youtube.com/playlist?list=PL0zysOflRCekMr91amXBNwWku4PmeFaFD&si=HOX-IuF2Tewh9x5-">play list 2</a>
                                      	  <a href="https://youtube.com/playlist?list=PL0zysOflRCekb_ggXQYQSu-g-kWKgudBf&si=YufWg7G298zIzIP3">play list 3</a></p>
                                       <p>Python projects: <a href="https://youtube.com/playlist?list=PLjVLYmrlmjGfAUdLiF2bQ-0l8SwNZ1sBl&si=Fc067Bce35rXOzCB">Click here</a></p>
                                </div>
                            </div>
                        </div>
                
                    </div>
                </div>
                <br>
            </div>
        </div>

	<!-- profile model -->
    
   
		<!-- profile model -->
    
    <!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#profile-model">
  Launch demo modal
</button> -->

<!-- Modal -->
<div class="modal fade" id="profile-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
        <h5 class="modal-title" id="exampleModalLabel">  SoloLearn</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
            <div class="container text-center">
                     <img src="pictures/<%= user.getProfile() %>" class="img-fluid"  style="border-radius:50%;max-width: 110px">
                     <h5 class="modal-title mt-3" id="exampleModalLabel"><%= user.getName() %></h5>
            
            <!-- details -->
            <div id="profile-details">
            			<table class="table">
  							<tbody>
    							<tr>
      								<th>ID</th>
    								  <td><%= user.getId()  %></td>
  							  </tr>
  								  <tr>
     									 <th>Email</th>
     									 <td><%= user.getEmail()  %></td>
  								  </tr>
   								 <tr>
   										   <th>Gender</th>
    										 <td><%= user.getGender()  %></td>
 								   </tr>
   								  <tr>
      										<th>Status</th>
     										 <td><%= user.getAbout()  %></td>
 								   </tr>
 								 </tbody>
							</table>
						</div>
						
						<!-- profile edit -->
						<div id="profile-edit" style="display:none;">
										<br>
										<h6 class="nt-2" style="color:red;">Please edit carefully</h6>
						                <form action="EditServlet" method="POST" enctype="multipart/form-data">
						                  			<table class="table">
						                  						<tr>
						                  								<th>ID</th>
    								 									 <td><%= user.getId()  %></td>
						                  						</tr>
						                  						<tr>
						                  								<th>Email</th>
    								 									 <td><input type="email" class="form-control" name="user-email" value="<%= user.getEmail()  %>"></td>
						                  						</tr>
						                  						<tr>
						                  								<th>Password</th>
    								 									 <td><input type="password" class="form-control" name="user-password" value="<%= user.getPassword()  %>"></td>
						                  						</tr>
						                  						<tr>
						                  								<th>Profile Pic</th>
    								 									 <td><input type="file" class="form-control" name="image"></td>
						                  						</tr>
						                  						<tr>
						                  								<th>Status</th>
    								 									 <td><textarea class="form-control"  name="user-about"rows="3">
    								 									 		<%= user.getAbout()  %>
    								 									 </textarea></td>
						                  						</tr>
						                  			
						                  			</table>
						                
						                		<div class="container ">
						                					<button type="submit" class="btn btn-outline-primary">Save</button>
						                		</div>
						                </form>
						                
						
						</div>


            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button id="edit-profile-btn" type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>
    
    
    
    <!-- end of profile model -->
    
    <!-- add profile model -->

<!-- Modal -->
<div class="modal fade" id="addPostModel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the post details ......</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      
       			<form id="add-post-form" action="AddPostServlet" method="POST" enctype="multipart/form-data">
       			
       						<div class="form=group">
       									<select  class="form-control" name="cid">
       												<option selected disabled="disabled">-----Select Cetagry-----</option>
       												
       												<%
       														PostDao post=new PostDao(ConnectionProvider.getConnection());
       														ArrayList<Category> list=post.getAllCategories();
       														for(Category c:list)
       														{
       												%>
       												<option value="<%= c.getCid()  %>"><%= c.getName() %></option>
       												<%
       														}
       												%>
       									</select> 
       						</div>
       						<br>
       						<div class="form=group">
       									<input type="text" name="ptitle"  placeholder="Enter Post Title  ." class="form-control">
       						</div>
       						<br>
       						<div class="form=group">
       									<textarea rows="5" name="pcontent" placeholder="Enter Your Content   ."   class="form-control"></textarea>
       						</div>
       						<br>
       						<div class="form=group">
       									<textarea rows="5" name="pcode" placeholder="Enter Your Program(if any ..)   ."   class="form-control"></textarea>
       						</div>
       						<br>
       						<div class="form=group">
       									<label for="pic">Select your pic...</label><br>
       									<input type="file" class="form-control" name="pPic" id="pic">
       						</div>
       						<br>
       						<div class="container text-center">
       							<button type="submit" class="btn btn-outline-primary">Post</button>
       						</div>
       			</form>
       			
      </div>
    </div>
  </div>
</div>

    <!-- end profile model -->
    <!-- Java Script -->
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script src="js/logic.js" type="text/javascript"></script>

<script>
$(document).ready(function(){
	
	/*Edit button toggle logic*/
	
	let editStatus = false;
	
	
	$('#edit-profile-btn').click(function(){
		/* alert("button clicked") */
		
		if(editStatus == false){
			
			$('#profile-details').hide()
			
			$('#profile-edit').show()
			editStatus = true;
			/*It change the text edit to back*/
			$(this).text("Back")
		}
		else{
			
			$('#profile-details').show()
			
			$('#profile-edit').hide()
			editStatus = false;
			/*It change the text back to edit*/
			$(this).text("Edit")
		}
		
	})
});
</script>

<!-- now add post js -->
<script>
$(document).ready(function(e){
	
	$('#add-post-form').on("submit",function(event){
		
		//this code gets called when form is submitted..... 
		event.preventDefault();
		console.log("you have clicked on submit....");
		
		let form=new FormData(this);
		
		//now requesting to server
		$.ajax({
			
			url:"AddPostServlet",
			type:'POST',
			data:form,
			success:function(data, textStatus,jqXHR){
				//success...
				console.log(data);
				
				if(data.trim() == 'done'){
					swal("Good job!", "Saved successfully", "success");
				}
				else{
					swal("Error!", "Something went wrong try again!", "error");
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				//error...
				swal("Error!...", "Something went wrong try again!", "error");
			},
			processData:false,
			contentType:false
		})
	})
})
</script>
        
</body>
</html>