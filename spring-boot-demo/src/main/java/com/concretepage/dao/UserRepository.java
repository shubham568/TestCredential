package com.concretepage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.User;


@Repository
public interface UserRepository  {


	List<User> getUserById(long userId);

	List<User> getAllUsers();

	User findById(long userId);

	
	void updateUser(User user);

	//void deleteUser(long userId);

	boolean userExists(String username, String password);

	void addUser(User user);

	//void deleteUser(User user);

	//void deleteUser(UserState enabled);

	void deleteUser(User user);

	

	
	
}
