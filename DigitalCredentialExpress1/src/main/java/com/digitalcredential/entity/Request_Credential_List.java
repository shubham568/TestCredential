package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Request_Credential_List implements Serializable {

	public Request_Credential_List() {
		super();
		
	}
	
	private int Request_Id;
	private int Credential_Id;
	public int getRequest_Id() {
		return Request_Id;
	}
	public int getCredential_Id() {
		return Credential_Id;
	}
	
	@Override
	public String toString() {
		return "Request_Credential_List [ Request_Id "+Request_Id+ "Credential_Id"+ Credential_Id+ "]";
	}

}
