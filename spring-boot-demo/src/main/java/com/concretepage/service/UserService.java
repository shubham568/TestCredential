package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.User;


public interface UserService {

	boolean save(User user);

	

	List<User> getUsersById(Long parseInt);

	List<User> getAllUsers();

	

	

		User findByID(long userId);

	void add(User user);


	

	void updateUser(User user);



	//void softdeleteUser(Long id);



	void softdeleteUser(User user);



	
	
	

}
