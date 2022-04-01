/**
 * 
 */
package com.tcs.Application.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.Application.model.Courses;
import com.tcs.Application.model.Grades;
import com.tcs.Application.model.Student;
import com.tcs.Application.model.PayFee;



/**
 * @author springuser22
 *
 */
@Repository
public class StudentDAO {
	
	// Dummy database. Initialize with some dummy values.
		//Here is the all method using dummy values
			private static List<Student> students;
			{
				students = new ArrayList();
				students.add(new Student(10, "Ram", "Mishra", "ram@gmail.com", "121-232-3789", "Kolkata", "Science"));	
				students.add(new Student(11, "Sam", "Mondal", "sam@gmail.com", "567-232-3789", "Delhi", "Arts"));
				students.add(new Student(12, "Raja", "Pal", "raja@gmail.com", "121-890-3789", "Pune", "Commerce"));
			}
			
			/**
			 * List of Student Implementation 
			 * @param 
			 *
			 */
			
			public List list() {
				return students;
			}
			
			
		
			
			/**
			 * create student
			 * @param 
			 *
			 */
			public Student create(Student student) {
				//student.setId(System.currentTimeMillis());
				students.add(student);
				return student;
			}
			
			/**
			 * Delete Student from DB
			 * @param 
			 *
			 */
			
			public Long deleteStudent(Long id) {

				for (Student c : students) {
					if (c.getId().equals(id)) {
						students.remove(c);
						return id;
						
					}
				}
				return null;
	}
			
			/**
			 * Update student in DB 
			 * @param 
			 *
			 */
			public Student update(Long id, Student student) {

				for (Student c : students) {
					if (c.getId().equals(id)) {
						student.setId(c.getId());
						students.remove(c);
						students.add(student);
						return student;
					}
				}

				return null;
			}
			
			/**
			 * Implementation for courses
			 * @param 
			 *
			 */
			private static List<Courses> courses;
			{
				courses = new ArrayList();
				courses.add(new Courses("cse",1,"computer engineer"));
				courses.add(new Courses("ece",2,"electronics engineer"));
				courses.add(new Courses("it",3,"information technology"));
			}
			
			/**
			 * List of course implementation
			 * @param 
			 *
			 */
			public List list1() {
				return courses;
			}
			/**
			 * Get the details for specific course
			 * @param 
			 *
			 */
 
			
			public Courses get(String course) {

				for (Courses e : courses) {
					if (e.getCourses().equals(course)) {
						return e;
					}
				}
				return null;
			}
			/**
			 * Add Courses
			 * @param 
			 *
			 */
			
			public Courses create(Courses course) {
				//course.setCourses(courses);(System.currentTimeMillis());
				courses.add(course);
				return course;
			
			}
			/**
			 * Delete Course
			 * @param 
			 *
			 */

			public String deletecourse(int courseId) 
			{
				
				for(Courses c: courses)
				{
					if(c.getCourseID()== courseId)
					{
						courses.remove(c);
					}
					
					else 
						return "Unsuccessful";
				}
				
				return "Successful";
				
			}
			
			
			/**
			 * GRADES LIST
			 * @param 
			 *
			 */
			private static List<Grades> grades;
			{
				grades = new ArrayList();
				grades.add(new Grades(90.8));
				grades.add(new Grades(95.9));
				grades.add(new Grades(90.0));
				
			}
			
			/**
			 * List of grades implementation
			 * @param 
			 *
			 */
			public List list2() {
				return grades;
			}
			
			/**
			 * Get the details for specific grades
			 * @param 
			 *
			 */
 
			
			public Grades get(double grade) {

				for (Grades e : grades) {
					if (e.getGrade()==(grade)) {
						return e;
					}
				}
				return null;
			}
			

			/**
			 * FEE LIST
			 * @param 
			 *
			 */
			private static List<PayFee> fees;
			{
				fees = new ArrayList();
				
				fees.add(new PayFee("online",800,"debit",1234));
				
			}
			
			public List list3() {
				return fees;
			}
			/*
			 * Payment Details
			 * @Param fee
			 * @Throws
			 */

			public String PayFee(PayFee fee) 
			
			{
				fee.setTransactionId(System.currentTimeMillis());
				fees.add(fee);
				return "Successful";
				
			}
			
			
			


}
