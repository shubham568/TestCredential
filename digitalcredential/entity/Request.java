package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Request implements Serializable {

	public Request() {
		super();
	}
	
	private int Request_Id;
	private int Requester_Id;
	private int Learner_Id;
	private String Status_Id;
	public int getLearner_Id() {
		return Learner_Id;
	}
	
	public String getStatus_Id() {
		return Status_Id;
	}
	public void setStatus_Id(String status_Id) {
		Status_Id = status_Id;
	}
	public int getRequest_Id() {
		return Request_Id;
	}
	public int getRequester_Id() {
		return Requester_Id;
	}
	
	@Override
	public String toString() {
		return "Request [ Request_Id "+Request_Id+ "Requester_Id"+ Requester_Id+ "Learner_Id"+ Learner_Id+ "Status_Id"+ Status_Id+"]";
	}

}
