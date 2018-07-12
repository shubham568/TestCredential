package com.digitalcredential.entity;

import java.io.Serializable;
import java.time.Year;

@SuppressWarnings("serial")
public class Subject_Marks implements Serializable {

		public Subject_Marks() {
		super();
	}
	
	private int Learner_Id;
	private int Subject_Id;
	private int Course_Id;
	private Year Year;
	private int Grade_Id;
	private String Marks;
	
	public Year getYear() {
		return Year;
	}
	public void setYear(Year year) {
		Year = year;
	}
	public String getMarks() {
		return Marks;
	}
	public void setMarks(String marks) {
		Marks = marks;
	}
	public int getLearner_Id() {
		return Learner_Id;
	}
	public int getSubject_Id() {
		return Subject_Id;
	}
	public int getCourse_Id() {
		return Course_Id;
	}
	public int getGrade_Id() {
		return Grade_Id;
	}
	
   @Override
	public String toString() {
		return "Subject_Marks  [Learner_Id =" + Learner_Id + "Subject_Id =" + Subject_Id + "Course_Id =" +Course_Id + 
				"Grade_Id" + Grade_Id + "Year" + Year + "Marks" + Marks+"]";
	}
}
