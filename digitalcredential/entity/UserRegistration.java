package com.digitalcredential.entity;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRegistration {

	public UserRegistration() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("DigitalUnit");
		EntityManager entityManager= factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		User newuser=new User();
		newuser.setUser_name("Laxman");
		newuser.setPassword("lax@123");
		newuser.setEmail_Id("laxman@dgenx.com");
		newuser.setCreated_Date(new Date(2016-05-2018));
		newuser.setSocial_Id("lax@insta.com");
		newuser.setStatus_Id("Initiated");
		
		entityManager.persist(newuser);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	
	

}
