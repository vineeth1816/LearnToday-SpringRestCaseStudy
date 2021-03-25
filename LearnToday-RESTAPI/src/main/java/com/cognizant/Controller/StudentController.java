package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Course;
import com.cognizant.Model.Message;
import com.cognizant.Model.Student;
import com.cognizant.Services.StudentDao;
@RestController
public class StudentController {
	
	
	
	@Autowired
	StudentDao studentDao;
	
	@GetMapping("/api/Student")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allCourses=studentDao.getAllCourses();
		return new ResponseEntity<List<Course>>(allCourses,HttpStatus.OK);
	}
	
	@PostMapping("/api/Student")
	public ResponseEntity<Object> postStudent(@RequestBody Student student){
		boolean inserted;
		try {
			inserted=studentDao.doEnroll(student);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<Object>("Not inserted",HttpStatus.BAD_REQUEST);
		}
		
			return new ResponseEntity<Object>(student,HttpStatus.CREATED);
		
		
		
	}
	
	@DeleteMapping("/api/Student/{EnrollmentId}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable int EnrollmentId){
		boolean updated;
		try{
			updated=studentDao.deleteEnrollment(EnrollmentId);
		}
		catch(RuntimeException e) {
			return new ResponseEntity<Object>(e,HttpStatus.BAD_REQUEST);
		}
		if(updated)
			return new ResponseEntity<Object>("",HttpStatus.OK);
		Message m=new Message();
		m.setMessage("No enrollment information found");
		return new ResponseEntity<Object>(m,HttpStatus.NOT_FOUND);
	}
	
}
