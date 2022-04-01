/**
 * 
 */

package com.tcs.Application.model;

public class Courses {

	private String courses;
    private int courseID;
    private String courseDes;
    
    
	public Courses(String courses, int id, String courseDes) {
		super();
		this.courses = courses;
		this.courseID = id;
		this.courseDes = courseDes;
	}

	public Courses() {
		
	}
	public String getCourses() {
		return courses;
	}


	public void setCourses(String courses) {
		this.courses = courses;
	}


	public int getCourseID() {
		return courseID;
	}


	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}


	public String getCourseDes() {
		return courseDes;
	}


	public void setCourseDes(String courseDes) {
		this.courseDes = courseDes;
	}
	
	
	
	//toString to be used...
}