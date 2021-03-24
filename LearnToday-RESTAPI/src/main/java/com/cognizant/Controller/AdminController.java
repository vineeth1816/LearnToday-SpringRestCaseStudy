package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Course;
import com.cognizant.Model.Message;
import com.cognizant.Services.CourseDao;

@RestController
public class AdminController {
	
	@Autowired
	private CourseDao course;
	
	@GetMapping("/api/Admin")
	public ResponseEntity<List<Course>> allCourses(){
		List<Course> courseList=course.getAllCourses();
		
		return new ResponseEntity(courseList,HttpStatus.OK);
	}
	
	@GetMapping("/api/Admin/{id}")
	public ResponseEntity<Object> getCourseById(@PathVariable int id){
		Course c = course.getCourseById(id);
		
		if(c==null) {
			Message m=new Message();
			m.setMessage("Searched Data not Found");
			return new ResponseEntity<Object>(m,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(c,HttpStatus.OK);
	}

}
