<%@page import="com.nt.entities.Post" %>
<%@page import="java.util.List" %>
<%@page import="com.nt.helper.ConnectionProvider" %>
<%@page import="com.nt.dao.PostDao" %>
<%@page import="java.io.PrintWriter" %>

<link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    
<div class="row mt-1">
<%
Thread.sleep(1000);
PostDao d=new PostDao(ConnectionProvider.getConnection());

//if catId==0 then fetch all posts
//if catId>0 then fetch all posts of catId
int cid=Integer.parseInt(request.getParameter("cid"));
List <Post> Posts=null;

if(cid==0){
	Posts=d.getAllPosts();
}
else{
	Posts=d.getPostByCatId(cid);
}

if(Posts.size() == 0){
	//get the printwriter stream
	PrintWriter pw=response.getWriter();
	pw.println("<h3 class='display-3 text-center'>No post in this category ..</h3>");
	return;
}

for(Post p : Posts)
{
%>

<div class="col-lg-4 col-md-12 mt-2">

		<div class="card"  style="width: 18rem;height:25rem">
				<img src="post-pics/<%= p.getpPic() %>" class="card-img-top" alt="Card image cap" style="width: 100%;height:12rem;">
				<div class="card-body">
				
						<h5 class="card-title"><%= p.getpTitle() %></h5>
						<p class="card-text"><%= p.getpContent() %></p>
						
				</div>
				
				<div class="card-footer primary-background text-center">
						<a href="show-blog-page.jsp?post-id=<%=p.getPid() %>" class="btn btn-outline-light btn-sm">Read more...</a>
				</div>
		
		</div>

</div>


<%
}
%>
</div>