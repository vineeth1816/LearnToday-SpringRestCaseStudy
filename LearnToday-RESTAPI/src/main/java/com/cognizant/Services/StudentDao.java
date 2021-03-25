package com.cognizant.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.cognizant.Model.Course;
import com.cognizant.Model.Student;

@Service
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Course> getAllCourses(){
		List<Course> courseList=jdbcTemplate.query("select * from Course order by Start_Date", new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course c=new Course();
				c.setCourseId(rs.getInt("CourseId"));
				c.setDescription(rs.getString("Description"));
				c.setFees(rs.getFloat("Fees"));
				c.setStart_Date(rs.getDate("Start_Date"));
				c.setTitle(rs.getString("Title"));
				c.setTrainer(rs.getString("Trainer"));
				return c;
			}
			
		});
		return courseList;
	}
	
	public boolean doEnroll(Student student) {
		System.out.println( student.getEnrollmentId());
		System.out.println(student.getStudentId());
		System.out.println(student.getCourseId());
	
		int flag=jdbcTemplate.update("insert into Student values(?,?,?)", student.getEnrollmentId(),student.getStudentId(),student.getCourseId());
		
		if(flag>0)
			return true;
		else {
			return false;
		}
	
		
		
		
	}
	
	
	
	
	
	
	
	
	public boolean deleteEnrollment(int id) {
		int flag=jdbcTemplate.update("delete from student where EnrollmentId=?", id);
		if(flag>0)
		{
			return true;
		}
		else
		{	
			return false;
		}
	}
}
