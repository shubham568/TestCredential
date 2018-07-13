package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role implements Serializable {

	public Role() {
		super();
	}
	
	private int role_id;
	private String role_name;
	private String role_desc;
	
	
	public int getRole_id() {
		return role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	
	@Override
	public String toString() {
		return "Role [ role_id"+ role_id + "role_name"+ role_name + "role_desc"+ role_desc+  "]";
	}
	

}
