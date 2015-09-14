package test;

import java.sql.SQLException;

import org.nazar.dao.CourseDAO;
import org.nazar.user.Course;

public class TestFindCourseByName {
	
	private static CourseDAO cdao= new CourseDAO();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String expValue ="java for begginers";
		
		
		Course course = TestFindCourseByName.cdao.getDataByName(expValue);
		
		String actualVal = course.getCourseName();
		
		if(expValue.equals(actualVal)){
			
			System.out.println("OK");
		}else{
			
			throw new AssertionError("wrong data output");
		}

	}

}
