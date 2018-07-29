package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Role implements Serializable {

	public Role() {
		super();
	}
	
	
	
	@Id
	@Column(name="role_id",insertable=false,updatable=false)
	private long role_id;
	@Column(name="role_name")
	private String role_name;
	@Column(name="role_desc")
	private String role_desc;
	
	
	
	
   	public long getRole_id() {
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
