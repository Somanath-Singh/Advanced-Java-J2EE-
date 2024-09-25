
<%!
		public void jspinit(){
			// System.out.println("config object class name :"+config.getClass());
			//System.out.println("application object class name :"+application.getClass()); 
			
			ServletConfig cg=getServletConfig();
			ServletContext sc=getServletContext();
			System.out.println("cg object class name :"+cg.getClass());
			System.out.println("sc object class name :"+sc.getClass()); 
			
			System.out.println("init param value :"+cg.getInitParameter("p1")+"   "+cg.getInitParameter("p2")); 
			System.out.println("init param value :"+sc.getInitParameter("c1")+"   "+sc.getInitParameter("c2")); 
}


%>

<%
	out.println("init param value :"+config.getInitParameter("p1")+"   "+config.getInitParameter("p2"));
	out.println("context param value :"+application.getInitParameter("c1")+"   "+application.getInitParameter("c2"));

%>
<h1>Welcome to server page</h1>

 