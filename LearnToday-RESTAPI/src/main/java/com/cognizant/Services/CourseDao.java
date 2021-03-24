package com.cognizant.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.cognizant.Model.Course;

@Service
public class CourseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Course> getAllCourses() {
		List<Course> CourseList=jdbcTemplate.query("select * from Course", new RowMapper<Course>() {

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
		return CourseList;
		
	}

	public Course getCourseById(int id) {
		
		 Course obj=jdbcTemplate.query("select * from Course where CourseId=?", new ResultSetExtractor<Course>() {

			@Override
			public Course extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
				
				Course c = new Course();
				c.setCourseId(rs.getInt("CourseId"));
				c.setDescription(rs.getString("Description"));
				c.setFees(rs.getFloat("Fees"));
				c.setStart_Date(rs.getDate("Start_Date"));
				c.setTitle(rs.getString("Title"));
				c.setTrainer(rs.getString("Trainer"));
				return c;
				}
				return null;
				
			}
			
		}, id);
		 return obj;

	}
	
}
