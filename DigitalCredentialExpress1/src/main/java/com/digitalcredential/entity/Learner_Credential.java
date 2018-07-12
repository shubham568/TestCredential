package com.digitalcredential.entity;

import java.io.Serializable;
import java.sql.*;

@SuppressWarnings("serial")
public class Learner_Credential implements Serializable {

	public Learner_Credential() {
		super();
	}

	private int Learner_Credential_Id;
	private int Learner_Id;
	private int Credential_Id;
	private int Course_Id;
	private int Grade_Id;
	private String Marks;
	private Date Issued_date;
	
	public int getLearner_Credential_Id() {
		return Learner_Credential_Id;
	}
	public void setLearner_Credential_Id(int learner_Credential_Id) {
		Learner_Credential_Id = learner_Credential_Id;
	}
	public String getMarks() {
		return Marks;
	}
	public void setMarks(String marks) {
		Marks = marks;
	}
	public Date getIssued_date() {
		return Issued_date;
	}
	public void setIssued_date(Date issued_date) {
		Issued_date = issued_date;
	}
	public int getLearner_Id() {
		return Learner_Id;
	}
	public int getCredential_Id() {
		return Credential_Id;
	}
	public int getCourse_Id() {
		return Course_Id;
	}
	public int getGrade_Id() {
		return Grade_Id;
	}
	
	
    @Override
	public String toString() {
		return "Learner_Credential  [Learner_Credential_Id =" + Learner_Credential_Id + "Learner_Id =" + Learner_Id + "Credential_Id =" +Credential_Id + 
				"Course_Id" + Course_Id + "Grade_Id" + Grade_Id + "Marks" + Marks+ 
				"Issued_date"+Issued_date+ "]";
	}
	
	
}
