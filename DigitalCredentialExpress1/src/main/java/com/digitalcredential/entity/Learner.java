package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Learner implements Serializable {
	
	private int Learner_id;
	private int user_id;
	private int contact_id;
	
	public Learner() {
		super();
	}
	
	
	public int getLearner_id() {
		return Learner_id;
	}
	public void setLearner_id(int learner_id) {
		Learner_id = learner_id;
	}
	public int getUser_id() {
		return user_id;
	}
	
	public int getContact_id() {
		return contact_id;
	}
	
	@Override
	public String toString() {
		return  "Learner  [Learner_id =" + Learner_id + "user_id =" + user_id + "contact_id =" +contact_id + "]";
	}
	
	
	
	

}
