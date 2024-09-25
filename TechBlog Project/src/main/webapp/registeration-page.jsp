<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>

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

<!-- Register page -->

<main class="primary-background p-5 banner-background" style="padding-bottom:90px;">

      <div class="container">
             
             <div class="col-md-6 offset-md-3">
             
                  <div class="card">
                  
                         <div class="card-header text-center primary-background text-white">
                                    <span class="fa  fa-3x fa-user-circle"></span>
                                    <br>
                                    Register here
                         </div>
                         <div class="card-body">
                                   <form id="reg-form" action="RegisterServlet" method="POST">
                                   
                                              <div class="mb-3">
  											  <label for="user-name" class="form-label">User name</label>
  											  <input type="text" name="user-name" class="form-control" id="user-name" placeholder="Enter name">
  											 </div>                       
                                   
  											<div class="mb-3">
  											  <label for="exampleInputEmail1" class="form-label">Email address</label>
  											  <input type="email" name="user-email"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    										 <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  											 </div>
  											 
  											 <div class="mb-3">
    												<label for="exampleInputPassword1" class="form-label">Password</label>
  													  <input type="password" name="user-pasw" class="form-control" id="exampleInputPassword1">
  											</div>
  											
  											<div class="mb-3">
    												<label for="gender" class="form-label">Select Gender</label>
    												<br>
  													  <input type="radio"  id="gender" name="gender" value="Male">male
  													  <input type="radio"  id="gender" name="gender" value="Female">female
  											</div>
  												
  											<div class="mb-3">
  											       <textarea name="about" class="form-control" rows="5" placeholder="Enter something about your self"></textarea>
  											</div>
  											
  
 											 <div class="mb-3 form-check">
  													  <input type="checkbox" name="check" class="form-check-input" id="exampleCheck1">
  													  <label class="form-check-label" for="exampleCheck1">agree terms and condition</label>
												  </div>
												  
												  <br>
												  <div class="container text-center" id="loader" style="display:none">
												        <span class="fa fa-refresh  fa-spin fa-4x"></span>
												        <h4>Please wait ...</h4>
												  </div>
												  
  												<button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>
										
										</form>
                         </div>
                         <div class="card-footer">
                         
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>


<script>

$(document).ready(function(){
	console.log("loaded ..................")
	
	$('#reg-form').on('submit' , function(event){
		event.preventDefault();
		
		let form=new FormData(this);
		
		$("#submit-btn").hide();
		$("#loader").show();
		
		//send register servlet
		$.ajax({
		   url: "RegisterServlet"	,
		   type:'POST' ,
		   data:form ,
		   success:function(data, textStatus, jqXHR){
				   console.log(data)
				   
				   $("#submit-btn").show();
					$("#loader").hide();
					
					if(data.trim() === 'User Registration is Done ...')
						{
					swal("User Registration is Done ... Successfully .. We  are going to redirect to login page .")
					.then((value) => {
					         window.location ="login-page.jsp"
					});
						}
					else
						{
						swal(data);
						}
		   },
				   error:function(jqXHR, textStatus, errorThrown){
					   
					   $("#submit-btn").show();
						$("#loader").hide();
						
					   swal("Something went wrong .. try again... .");

				   },
						   processData:false,
							contentType:false
		   
		   });
	});
});




</script>
</body>
</html>