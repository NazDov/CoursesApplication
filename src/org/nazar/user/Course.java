package org.nazar.user;

import java.util.Date;

public class Course {
	
	private int id;
	private String courseNumber;
	private String courseName;
	private Date courseDate;
	
	public Course(){
		
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Course(int id, String courseNumber, String courseName,
			Date courseDate) {
		super();
		this.id = id;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.courseDate = courseDate;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseNumber=" + courseNumber
				+ ", courseName=" + courseName + ", courseDate=" + courseDate
				+ "]";
	}
	
	

}
