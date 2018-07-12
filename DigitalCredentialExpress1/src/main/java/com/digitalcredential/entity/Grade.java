package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Grade implements Serializable {

	public Grade() {
		super();
	}

	private int Grade_Id;
	private String Grade_Name;
	private String Description;
	public int getGrade_Id() {
		return Grade_Id;
	}
	public String getGrade_Name() {
		return Grade_Name;
	}
	public String getDescription() {
		return Description;
	}
	
	@Override
	public String toString() {
		return "Grade [ Grade_Id "+Grade_Id+ "Grade_Name"+ Grade_Name+ "Description"+Description+ "]";
	}
}
