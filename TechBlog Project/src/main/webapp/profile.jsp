<%@page import="com.nt.entities.Message" %>
<%@page import="com.nt.entities.UserData" %>
<%@page import="com.nt.entities.Category" %>
<%@page import="com.nt.dao.PostDao" %>
<%@page import="com.nt.helper.ConnectionProvider" %>
<%@page import="java.util.ArrayList" %>

<!-- if any error then it open error page -->
<%@page errorPage="error-page.jsp" %>

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
<meta charset="ISO-8859-1">
<title>Profile</title>

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

.clip-path{
	clip-path: polygon(64% 36%, 100% 13%, 100% 100%, 0 100%, 0 42%, 35% 15%);
}

</style>

</head>
<body>
    
   <!-- navbar -->
   
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-background fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand"href="#"><span class="fa fa-cogs"></span>  SoloLearn</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><span class="fa fa-500px"></span>  Learn with Somanath</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="contact.jsp"><span class="fa fa-address-book"></span>  Contacts</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#addPostModel"><span class="fa fa-asterisk"></span>  Post </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="sololearn.jsp"><span class="fa"></span> SoloLearn</a>
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
   <br><br>
   <!-- navbar end -->
   
    <!-- message shown in webpage -->
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
   
   
<%-- 
    <%= user.getName()  %>
    <br>
    <%= user.getEmail() %>
    <br>
    <%= user.getAbout() %> --%>
    
    <!-- main body of the page -->
    
    <main>
    
     			<div class="container">
    
    					<div class="row mt-4">
    					
    							<!-- first column -->
    							<div class="col-lg-4">
    								<!-- categories -->
    								<div class="list-group">
  											<a href="#" onclick="getPosts(0 , this)"  class="c-link list-group-item list-group-item-action active " aria-current="true">All Posts..</a>
  											<!-- categories -->
  											       <%
       														PostDao p=new PostDao(ConnectionProvider.getConnection());
       														ArrayList<Category> list1=p.getAllCategories();
       														for(Category cc:list1)
       														{
       												%>
       												<a href="#" onclick="getPosts(<%=cc.getCid() %> , this)"  class="c-link list-group-item list-group-item-action "><%= cc.getName() %></a>
       												<%
       														}
       										        %>										  
  											
									</div>
    							
    							</div>
    							
    							<!-- second column -->
    							<div class="col-lg-8 col-12" id="post-container">
    								<!-- posts -->
									<div class="container text-center" id="loader">	
											<i class="fa fa-refresh fa-4x fa-spin"></i>
											<h3 class="mt-2">Loading...</h3>
									</div>
									
									<div class="container-fluid" id="post-container">
									
									
									</div>
									
    							
    							</div>
    					
    					</div>
    
   				 </div>
    
    </main>
    
    
    
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
        <h5 class="modal-title" id="exampleModalLabel">SoloLearn</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
            <div class="container text-center">
                     <img src="./pictures/<%= user.getProfile() %>" class="img-fluid"  style="border-radius:50%;max-width: 110px">
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
       												<option selected disabled>-----Select Cetagry-----</option>
       												
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
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="  crossorigin="anonymous"></script>
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


<!-- loading post using ajax -->
<script>

function getPosts(catId , temp){
	
	$("#loader").show();
	$('#post-container').hide()
	
	 $(".c-link").removeClass('active')
	
$.ajax({
		
		url:"load-post.jsp",
		data:{cid : catId}, 
		success:function(data, textStatus,jqXHR){
			//success...
			console.log(data);
			$("#loader").hide();
			$('#post-container').show();
			$('#post-container').html(data)
			$(temp).addClass('active')
		}
   })
}
$(document).ready(function(e){
	//call the function
	let allPostref=$('.c-link')[0]
	getPosts(0,allPostref)

})
</script>
<br>  <br>  <br>  <br>  <br>  <br>  <br>
	 <div class=" clip-path primary-background fixed-bottom" >
   <br>  <br>  <br>  
   	<div class="container text-center text-white"><span class="fa"><h1 style="color:#fa4b2c">{ Create your post ......} </h1></span></div>
   <br>  <br>  <br>  
   </div>
   
</body>
</html>