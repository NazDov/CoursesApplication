package org.nazar.user;

import java.util.Date;

public class UserCourse {
	
	@Override
	public String toString() {
		return "UserCourse [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", courseNumber=" + courseNumber
				+ ", courseName=" + courseName + ", courseDate=" + courseDate
				+ "]";
	}





	private String userId;
	private String userName;
	private String userEmail;
	private String courseNumber;
	private String courseName;
	private Date courseDate;
	
	
	
	

	public UserCourse(String userId, String userName, String userEmail,
			String courseNumber, String courseName, Date courseDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.courseDate = courseDate;
	}





	public UserCourse() {
		// TODO Auto-generated constructor stub
	}





	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getUserEmail() {
		return userEmail;
	}





	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}





	public String getCourseNumber() {
		return courseNumber;
	}





	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}





	public String getCourseName() {
		return courseName;
	}





	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}





	public Date getCourseDate() {
		return courseDate;
	}





	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
	
	

}
