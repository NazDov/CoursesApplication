package org.nazar.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nazar.dao.CourseDAO;
import org.nazar.dao.UserDAO;
import org.nazar.dbconex.DBConnection;
import org.nazar.user.Course;
import org.nazar.user.User;
import org.nazar.user.UserCourse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ApplicationService {
	
	private static CourseDAO cDao = new CourseDAO();
	private static UserDAO uDao = new UserDAO();
	private User user;
	private Course course;
	private Connection connect;
	private static final boolean ERROR=false;
	
	
	public static UserDAO getUserDAO(){
		
		return uDao;
	}
	
	
	public static CourseDAO getCourseDAO(){
		
		return cDao;
	}
	
	public static Map<User, Course> getDataList(){
		
		return DataStorage.getData();
	}
	
	
	
	public boolean tableUserCourseUpdate(String userId, String courseName) throws SQLException{
		
		int uId=0;
		int cId=0;
		
		user =uDao.getDataByName(userId);
		course = cDao.getDataByName(courseName);
				
		uId=user.getId();
		cId=course.getId();
		
		connect = DBConnection.getConnection();
		
		String sqlInsert = "insert into user_courses(user_id, course_id) values(?, ?)";
		
		PreparedStatement pr = (PreparedStatement) connect.prepareStatement(sqlInsert);
		
		pr.setInt(1, uId);
		pr.setInt(2, cId);
	
		pr.execute();
		
		pr.close();
		
		return true;
		
	}
	
	
	public boolean isRegistered(User user){
		
		if(getDataList().containsKey(user)){
			
			return true;
		}
		
		return ERROR;
	}
	
	
	public Course findRegisteredCourse(User user){
		
		if(getDataList().containsKey(user)){
			
			course =getDataList().get(user);
		
		}
		
		return course;
	}
	
	
	public static UserCourse returnApliedCourseDetailsForUser(Course course, User user) throws SQLException{
		if(course == null){
			
			throw new IllegalArgumentException("course null");
			
		}
		
		if(user == null){
			
			throw new IllegalArgumentException("user null");
		}
		
		return cDao.getUserCourse(course, user);
	}
	
	

}
