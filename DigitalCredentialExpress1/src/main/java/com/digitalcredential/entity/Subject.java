package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Subject implements Serializable {

	public Subject() {
		super();
	}
	
	private int Subject_Id;
	private String Subject_Name;
	private int Course_Id;
	public int getSubject_Id() {
		return Subject_Id;
	}
	public void setSubject_Id(int subject_Id) {
		Subject_Id = subject_Id;
	}
	public String getSubject_Name() {
		return Subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		Subject_Name = subject_Name;
	}
	public int getCourse_Id() {
		return Course_Id;
	}

	@Override
	public String toString() {
		return "Subject [ Subject_Id "+Subject_Id+ "Subject_Name"+ Subject_Name+ "Course_Id"+Course_Id+ "]";
	}
}
