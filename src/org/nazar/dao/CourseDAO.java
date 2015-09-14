package org.nazar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import org.nazar.dao.interfaces.ApplicationInterface;
import org.nazar.dao.interfaces.CourseAppInterface;
import org.nazar.dbconex.DBConnection;
import org.nazar.user.*;

public class CourseDAO implements ApplicationInterface<Course, User>,
		CourseAppInterface<Course, User, UserCourse> {
	
	private static Connection connection;
	private static List<Course> courses;
	private static Course course;
	private static Statement statement;
	private static UserCourse userCourse = new UserCourse();
	
	
	
	
	public static List<Course> getCourses() throws SQLException{
		
		courses=new ArrayList<Course>();
		
		connection = DBConnection.getConnection();
		
		statement = (Statement)connection.createStatement();
		
		String selectSQL = "Select * FROM courses";
		
		ResultSet rs = statement.executeQuery(selectSQL);
		
		while(rs.next()){
			
			int coursesId = rs.getInt("id");
			String courseNumber = rs.getString("course_number");
			String courseName = rs.getString("course_name");
			Date courseDate = rs.getDate("course_date");
			
			course  = new Course(coursesId, courseNumber, courseName, courseDate);
			courses.add(course);
			
		}
		
		
		return courses;
	}




	@Override
	public Course getDataByName(Object t) throws SQLException {
	
		String dataVal=null;
		
		if(t==null){
			
			throw new IllegalArgumentException("null");
		}
		
		if(t instanceof String){
			
			
			dataVal= (String)t;
			
		}
	
		
		
		connection=  DBConnection.getConnection();
		
		String sqlGet = "select * from courses where course_name=?";
		
		PreparedStatement pr = (PreparedStatement) 
				connection.prepareStatement(sqlGet);
		
		pr.setString(1, dataVal);
		
		ResultSet result = pr.executeQuery();
		
		while(result.next()){
			
			int primary_id = result.getInt("id");
			String courseNumber = result.getString("course_number");
			String courseName = result.getString("course_name");
			Date courseDate = result.getDate("course_date");
			
			course= new Course(primary_id, courseNumber, courseName, courseDate);
		
	
		}
		
		return course;
		
	}




	@Override
	public UserCourse getUserCourse(Course course, User user) throws SQLException {
		
		String sql ="Select userId, userName, userEmail, course_number, course_name, course_date from user Inner join user_courses on (user.id=user_courses.user_id) Inner join courses on (user_courses.course_id=courses.id)";
		
		connection=  DBConnection.getConnection();
		
		statement =(Statement) connection.createStatement();
	
		
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
			
			String userId = result.getString("userId");
			String userName = result.getString("userName");
			String userEmail = result.getString("userEmail");
			String courseNumber = result.getString("course_number");
			String courseName = result.getString("course_name");
			Date courseDate = result.getDate("course_date");
			
			if(user.getUserId().equals(userId)
					&& course.getCourseNumber().equals(courseNumber)){
				
				userCourse = new UserCourse(userId, userName, userEmail, courseNumber, courseName, courseDate );
				
				
				return userCourse;
				
			}else{
				
				
				continue;
			}
			
			
			
		}
		
		return userCourse;
		
	
	}




	@Override
	public Course getCourseByUser(User user) throws SQLException {
		
	connection = DBConnection.getConnection();
	
	String sqlQuery = "Select courses.id, course_number, course_name, course_date from courses inner join user_courses on (courses.id=user_courses.course_id) inner join user on (user.id=user_courses.user_id) where user.id=?";	
		
	PreparedStatement pr = (PreparedStatement) 
			connection.prepareStatement(sqlQuery);
	
	pr.setInt(1, user.getId());
	
	ResultSet result = pr.executeQuery();	
		
	while(result.next()){
		
		int primary_id = result.getInt("id");
		String courseNumber = result.getString("course_number");
		String courseName = result.getString("course_name");
		Date courseDate = result.getDate("course_date");
		
		Course course = new Course(primary_id, courseNumber, courseName, courseDate);
		
		System.out.println(course);
		return course;
		
		
	}
	
	return course;
	}



	

}
