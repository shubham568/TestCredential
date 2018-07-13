package com.digitalcredential.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Course implements Serializable {

	public Course() {
		super();
	}
	private int Course_Id;
	private String Course_Name;
	private String Short_Name;
	private String Description;
	private int Institution_Id;
	private String Course_Period;
	public int getCourse_Id() {
		return Course_Id;
	}
	public void setCourse_Id(int course_Id) {
		Course_Id = course_Id;
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	public String getShort_Name() {
		return Short_Name;
	}
	public void setShort_Name(String short_Name) {
		Short_Name = short_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCourse_Period() {
		return Course_Period;
	}
	public void setCourse_Period(String course_Period) {
		Course_Period = course_Period;
	}
	public int getInstitution_Id() {
		return Institution_Id;
	}

	@Override
	public String toString() {
		return "Course  [Course_Id =" + Course_Id + "Course_Name =" + Course_Name + "Short_Name =" +Short_Name + 
				"Description" + Description + "Course_Period" + Course_Period + "Institution_Id" + Institution_Id+ 
				"]";
	}
}
