package com.cognizant.Model;

import java.util.Date;

public class Course {
	private int CourseId;
	private String Title;
	private float Fees;
	private String Description;
	private String Trainer;
	private Date Start_Date;
	
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public float getFees() {
		return Fees;
	}
	public void setFees(float fees) {
		Fees = fees;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTrainer() {
		return Trainer;
	}
	public void setTrainer(String trainer) {
		Trainer = trainer;
	}
	public Date getStart_Date() {
		return Start_Date;
	}
	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}


}
