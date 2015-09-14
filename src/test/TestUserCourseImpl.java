package test;

import java.sql.SQLException;

import org.nazar.dao.CourseDAO;
import org.nazar.service.ApplicationService;
import org.nazar.service.LoginService;
import org.nazar.user.Course;
import org.nazar.user.User;
import org.nazar.user.UserCourse;

public class TestUserCourseImpl {
	private static LoginService service = new LoginService();
	private static User user;
	private static Course course;
	private static CourseDAO cDao = new CourseDAO();
	private static UserCourse userCourse;
	
	
	
	
	
	public static UserCourse testUserdata(String userData) throws SQLException{
		
		user = service.getUserData(userData);
		System.out.println("user: "+user);
		course = cDao.getCourseByUser(user);
		System.out.println("Course: "+course);
		userCourse=ApplicationService.returnApliedCourseDetailsForUser(course, user);
		
		return userCourse;
		
	}
	

	public static void main(String [] args) throws SQLException {
		
		String userData ="user89";
		
		
		userCourse = testUserdata(userData);
		
		System.out.println(userCourse);
	}

}
