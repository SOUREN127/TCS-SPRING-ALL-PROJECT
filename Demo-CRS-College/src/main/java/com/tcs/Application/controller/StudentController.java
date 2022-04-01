/**
 * 
 */
package com.tcs.Application.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.Application.dao.StudentDAO;
import com.tcs.Application.model.Courses;
import com.tcs.Application.model.PayFee;
import com.tcs.Application.model.Student;

@RestController
public class StudentController {
	
	@Autowired //The meaning of @Autowired is put the dependency injection at the Dao layer
	private StudentDAO crsDAO;
	
	
	/**
	 * Using This Api to Post student data
	 * @param 
	 *
	 */
	
		@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			    method = RequestMethod.POST,
			    value = "/post/registration")
			@ResponseBody	
			public ResponseEntity createStudent(@RequestBody Student student) {
			
		//Student response = null;

			 crsDAO.create(student);

			return new ResponseEntity(student, HttpStatus.OK);
		}
		/**
		 * This method is using to delete the student
		 * @param 
		 *
		 */
		
		@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			    method = RequestMethod.DELETE,
			    value = "/delete/registration/{id}")
			@ResponseBody	
		public ResponseEntity deleteStudent(@PathVariable Long id) {

			if (null == crsDAO.deleteStudent(id)) {
				return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity(id, HttpStatus.OK);

		}
		
		/**
		 * This method is using to update the student
		 * @param 
		 *
		 */
		
		@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			    method = RequestMethod.PUT,
			    value = "/put/registration/{id}")
			@ResponseBody	
		public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student student) {

			student = crsDAO.update(id, student);

			if (null == student) {
				return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity(student, HttpStatus.OK);
		}
		/**
		 * Using This Api to Get courses data
		 *@param
		 */
		 
		
		@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			    method = RequestMethod.GET,
			    value = "/course")
			@ResponseBody
			public List getCourse() {
			

			
			return crsDAO.list1();
		}
		/**
		 * Using This Api to Post courses data
		 * @param 
		 *
		 */
				@RequestMapping(produces = MediaType.APPLICATION_JSON, 
					    method = RequestMethod.POST,
					    value = "/post/course")
					@ResponseBody	
					public ResponseEntity createCourse(@RequestBody Courses course) {
					
					// String response=null;
					 crsDAO.create(course);

					

					return new ResponseEntity(course, HttpStatus.OK);
				}
				
				/**
				 * This method is using to delete the courses
				 * @param 
				 *
				 */
			
				@RequestMapping(value = "/DeleteCourse/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON )
				@ResponseBody
				public ResponseEntity  DeleteCourse(@PathVariable("id") int id)
				{
					String response = crsDAO.deletecourse(id);
					
					if(response.equals("Successful"))
					{
						return new ResponseEntity("Course Deleted Successfully",HttpStatus.OK) ;
					}
					
					else 
					
						return new ResponseEntity("No Such Course Exists",HttpStatus.NOT_FOUND) ;
				}
				
				/**
				 * Using This Api to Get grades data
				 *@param
				 */
				 
				
				@RequestMapping(produces = MediaType.APPLICATION_JSON, 
					    method = RequestMethod.GET,
					    value = "/grades")
					@ResponseBody
					public List getGrade() {
					

					
					return crsDAO.list2();
				}
				
				/*
				 * Payment Details
				 * @Param fee
				 * @Throws
				 */
				@RequestMapping(value ="/PayFee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
				@ResponseBody
				public ResponseEntity Fee(PayFee fee)
				{
					String response = null;
					response = crsDAO.PayFee(fee);
					
					if(response.equals("Successful"))
					{
						return new ResponseEntity("Loading...",HttpStatus.OK);
					}
					
					 return new ResponseEntity("Server Busy. Try Again Later",HttpStatus.NOT_FOUND);
				}
				
				

}
