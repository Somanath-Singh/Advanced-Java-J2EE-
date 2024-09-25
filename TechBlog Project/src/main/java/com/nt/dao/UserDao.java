package com.nt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.entities.UserData;

public class UserDao {

	private Connection con;
	//constructor
	public UserDao(Connection con) {
		this.con = con;
	}
	//method to insert user to database
	public boolean addUser(UserData user) {
		boolean f=false;
		try {
			//user -->DataBase
			String query="insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
			PreparedStatement ps=this.con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAbout());
			//execute the query
			ps.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	//get user by useremail and userpassword
	
	public UserData getUserByEmailAndPassword(String email, String password) {
		UserData user=null;
		try {
			String query="select * from user where email= ? and password= ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			//execute the query
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user=new UserData();
				//data from db
				String name=rs.getString("name");
				//set data into user object
				user.setId(rs.getInt("id"));
				user.setName(name);
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setAbout(rs.getString("about"));
				user.setProfile(rs.getString("profile"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

//update user data
	public boolean updateUser(UserData user) {
		boolean f=false;
		try {
			String query="update user set email=?  ,  password=?   ,   about=? ,  profile=?  where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			//set the value to database
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAbout());
			ps.setString(4, user.getProfile());
			ps.setInt(5, user.getId());
			
			//execute the query
			ps.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public UserData getUserByUserId(int userId) {
		 
		 UserData user=null;
		 try {
			 String query="select * from user where Id = ?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					user=new UserData();
					
					//data from db
					String name=rs.getString("name");
					
					//set data into user object
					user.setId(rs.getInt("id"));
					user.setName(name);
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setAbout(rs.getString("about"));
					user.setProfile(rs.getString("profile"));
				}
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
		 return user;
	 }
}

