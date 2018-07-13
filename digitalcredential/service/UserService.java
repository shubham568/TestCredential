package com.digitalcredential.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.digitalcredential.entity.User;
import com.digitalcredential.dao.*;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDAO;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage mailMessage;
	@Override
	public User getUserById(int user_id) {
		User user = userDAO.getUserByid(user_id);
		return user;
	}	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	@Override
	public synchronized boolean addUser(User user){
       if (userDAO.userExists(user.getUser_name(), user.getPassword())) {
    	   return false;
       } else {
    	   userDAO.addUser(user);
    	   return true;
       }
	}
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	@Override
	public void deleteUser(int user_id) {
		userDAO.deleteUser(user_id);
	}

	
    
	
	public User findByEmail(String Email_Id) {
		return userDAO.findByEmail(Email_Id);
	}
	
	public User findByConfirmationToken(String confirmation_Token) {
		return userDAO.findByConfirmationToken(confirmation_Token);
	}
	
	public void saveUser(User user) {
		userDAO.addUser(user);
	}

	@Autowired
	  public UserService(JavaMailSender mailSender) {
	    this.mailSender = mailSender;
	  }
	  
	  @Async
	  public void sendEmail(SimpleMailMessage email) {
		  mailMessage.copyTo(email);
	  }

}
