package com.digitalcredential.entity;

import java.io.Serializable;
import java.sql.*;
import java.time.Year;

@SuppressWarnings("serial")
public class Credential implements Serializable {

	public Credential() {
		super();
	}

	private int Credential_Id;
	private String Credential_Name;
	private Year Credential_Year;
	private int Course_Id;
	private int Institution_Id;
	private Date Issued_Date;
	public int getCredential_Id() {
		return Credential_Id;
	}
	public void setCredential_Id(int credential_Id) {
		Credential_Id = credential_Id;
	}
	public String getCredential_Name() {
		return Credential_Name;
	}
	public void setCredential_Name(String credential_Name) {
		Credential_Name = credential_Name;
	}
	public Year getCredential_Year() {
		return Credential_Year;
	}
	public void setCredential_Year(Year credential_Year) {
		Credential_Year = credential_Year;
	}
	public Date getIssued_Date() {
		return Issued_Date;
	}
	public void setIssued_Date(Date issued_Date) {
		Issued_Date = issued_Date;
	}
	public int getCourse_Id() {
		return Course_Id;
	}
	public int getInstitution_Id() {
		return Institution_Id;
	}
	
	@Override
	public String toString() {
		return "Credential  [Credential_Id =" + Credential_Id + "Credential_Name =" + Credential_Name + "Credential_Year =" +Credential_Year + 
				"Issued_Date" + Issued_Date + "Course_Id" + Course_Id + "Institution_Id" + Institution_Id+"]";
	}
}
