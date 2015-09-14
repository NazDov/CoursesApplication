package org.nazar.dao;

import org.nazar.dao.interfaces.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.nazar.dbconex.*;
import org.nazar.user.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class UserDAO implements  UserAppInterface<User>, ApplicationInterface<User, Course> {
	
	private  Connection connection;
	private Statement statement;
	private User user;
	
	public UserDAO(){
		
	}
		
	
	public List<User> fetchedUserData(){
		
		
		
	  List<User> userList = new ArrayList<>();

		try{
			
		connection=  DBConnection.getConnection();
		
		statement =(Statement) connection.createStatement();
	
		
		ResultSet result = statement.executeQuery("select * from user");
		
		while(result.next()){
			
			int primary_id = result.getInt("id");
			String userId = result.getString("userId");
			String userPassword = result.getString("userPassword");
			String userName = result.getString("userName");
			String userEmail = result.getString("userEmail");
			
			System.out.println(userId+" "+userPassword);
			
			if(userEmail==null){
				
				userEmail="";
			}
			
		user= new User(primary_id, userId, userPassword, userName, userEmail);
		
		System.out.println(user);
		
		userList.add(user);
			
		}
			
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		
		return userList;
	}
	
	
	
	
		public void saveUserData(User user) throws SQLException{
			
			if(null!=user){
				
				
				connection = DBConnection.getConnection();
				
				String sqlInsert = "insert into user(userId, userPassword, userName, userEmail) values(?, ?, ?, ?)";
				
				PreparedStatement pr = (PreparedStatement) connection.prepareStatement(sqlInsert);
				
				pr.setString(1, user.getUserId());
				pr.setString(2, user.getUserPassword());
				pr.setString(3, user.getUserName());
				pr.setString(4, user.getUserEmail());
				
				pr.execute();
				
				pr.close();
				
				
			}else{
				
				new AssertionError("user is undefined");
			}
		}
	
	
	
	
		public boolean updateUserData(String userID, String userData) throws SQLException{
			
				
				connection = DBConnection.getConnection();
				
				String sqlUpdate = "update user set userEmail= ? where userId = ?";
				
				PreparedStatement pr = (PreparedStatement) 
						connection.prepareStatement(sqlUpdate);
				
				pr.setString(1, userData);
				pr.setString(2, userID);
				
				System.out.println(userData+" "+userID);
			
				
				pr.executeUpdate();
				
				pr.close();
				
				return true;
		
				
			
		}
		
		public boolean checkIfhasCourses(User user) throws SQLException{
			
			
			String sql ="Select userId, userName, userEmail, course_number, course_name, course_date from user Inner join user_courses on (user.id=user_courses.user_id) Inner join courses on (user_courses.course_id=courses.id)";
			
			connection=  DBConnection.getConnection();
			
			statement =(Statement) connection.createStatement();
		
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()){
				
				String userId = result.getString("userId");
				
				if(user.getUserId().equals(userId)){
					
					return true;
					
				}else{
					
					
					continue;
				}
				
				
				
			}
			
			return false;
			
		}


		@Override
		public User getDataByName(Object t) throws SQLException {
		
			
			String userVal=null;
			
			if(t==null){
				
				throw new IllegalArgumentException("null");
			}
			
			if(t instanceof String){
				
				
				userVal= (String)t;
				
			}
		
			
			
			connection=  DBConnection.getConnection();
				
			statement =(Statement) connection.createStatement();
			
			String sqlGet = "select * from user where userId=?";
			
			PreparedStatement pr = (PreparedStatement) 
					connection.prepareStatement(sqlGet);
			
			pr.setString(1, userVal);
			
			ResultSet result = pr.executeQuery();
			
			while(result.next()){
				
				int primary_id = result.getInt("id");
				String userId = result.getString("userId");
				String userPassword = result.getString("userPassword");
				String userName = result.getString("userName");
				String userEmail = result.getString("userEmail");
				
			user= new User(primary_id, userId, userPassword, userName, userEmail);
			
		
			}
			
			return user;
	
		}
}
