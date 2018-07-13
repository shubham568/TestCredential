package com.digitalcredential.entity;
import java.io.*;

@SuppressWarnings("serial")
public class Requester implements Serializable {

	public Requester() {
		super();
	}
	
	private int Request_Id;
	private int Contact_ID;
	public int getRequest_Id() {
		return Request_Id;
	}
	public int getContact_ID() {
		return Contact_ID;
	}
	
	@Override
	public String toString() {
		return "Requester [ Request_Id "+Request_Id+ "Contact_ID"+ Contact_ID+"]";
	}

}
