package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.nt.entities.Category;
import com.nt.entities.Post;
import com.nt.entities.UserData;

public class PostDao {

	Connection con;

	public PostDao(Connection con) {
		this.con = con;
	}
	
	public ArrayList<Category>  getAllCategories(){
		
		ArrayList<Category> list=new ArrayList<>();
		
		try {
			
			String query="select * from categories";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery(query);
			
			while(rs.next()) {
				int cid=rs.getInt("cid");
				String name=rs.getString("name");
				String description=rs.getString("description");
				
				//create the object of category class
				Category c=new Category(cid,name,description);
				
				//add all object into list
				list.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	//get all the posts
	public boolean savePost(Post p) {
		
		boolean f=false;
		
		try {
			String query="insert into posts(pTitle, pContent, pCode, pPic, catId, userId) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getpTitle());
			ps.setString(2, p.getpContent());
			ps.setString(3, p.getpCode());
			ps.setString(4, p.getpPic());
			ps.setInt(5, p.getCatId());
			ps.setInt(6, p.getUserId());
			//execute the query
			ps.executeUpdate();
			
			f = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

    public List<Post> getAllPosts(){
	
    	List<Post> list= new ArrayList<>();
    	//fetch all the post
    	try {
    		String query="select * from posts order by pid desc";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String pTitle=rs.getString("pTitle");
				String pContent=rs.getString("pContent");
				String pCode=rs.getString("pCode");
				String pPic=rs.getString("pPic");
				Timestamp date=rs.getTimestamp("pDate");
				int catId=rs.getInt("catId");
				int userId=rs.getInt("userId");
				
				//create the post class object and pass the value
				Post post=new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);
				
				//add all object into list
				list.add(post);
			}
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
		return list;
	
      }

    
    public List<Post> getPostByCatId(int catId){
    	
    	List<Post> list= new ArrayList<>();
    	//fetch all the post by id
    	try {
    		String query="select * from posts where catId = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, catId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String pTitle=rs.getString("pTitle");
				String pContent=rs.getString("pContent");
				String pCode=rs.getString("pCode");
				String pPic=rs.getString("pPic");
				Timestamp date=rs.getTimestamp("pDate");
				
				int userId=rs.getInt("userId");
				
				//create the post class object and pass the value
				Post post=new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);
				
				//add all object into list
				list.add(post);
			}
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
      }
    
    
 public Post getPostByPostId(int postId){
    	
    	Post post=null;
    	//fetch all the post by id
    	try {
    		String query="select * from posts where pId = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, postId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String pTitle=rs.getString("pTitle");
				String pContent=rs.getString("pContent");
				String pCode=rs.getString("pCode");
				String pPic=rs.getString("pPic");
				Timestamp date=rs.getTimestamp("pDate");
				int catId=rs.getInt("catId");
				int userId=rs.getInt("userId");
				
				//create the post class object and pass the value
				post=new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);
				
			}
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return post;
      }
    
    }
    
   
