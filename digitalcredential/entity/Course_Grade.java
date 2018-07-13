package com.digitalcredential.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Course_Grade implements Serializable {

	public Course_Grade() {
		super();
	}
	
	private int Course_Id;
	private int Grade_Id;
	public int getCourse_Id() {
		return Course_Id;
	}
	public int getGrade_Id() {
		return Grade_Id;
	}
	
	@Override
	public String toString() {
		return "Course_Grade [ Course_Id "+Course_Id+ "Grade_Id"+ Grade_Id+ "]";
	}

}
