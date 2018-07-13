package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Learner_Credential_Resourse implements Serializable {

	public Learner_Credential_Resourse() {
		super();
	}

	private int Learner_Credential_Id;
	private int Resourse_Id;
	private String Resourse;
	public int getResourse_Id() {
		return Resourse_Id;
	}
	public void setResourse_Id(int resourse_Id) {
		Resourse_Id = resourse_Id;
	}
	public String getResourse() {
		return Resourse;
	}
	public void setResourse(String resourse) {
		Resourse = resourse;
	}
	public int getLearner_Credential_Id() {
		return Learner_Credential_Id;
	}
	
	@Override
	public String toString() {
		return "Learner_Credential_Resource [ Learner_Credential_Id "+Learner_Credential_Id+ "Resourse_Id"+ Resourse_Id+ 
				"Resourse"+ Resourse+"]";
		
		
	}
}
