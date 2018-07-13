package com.digitalcredential.service;

import java.util.List;

import com.digitalcredential.entity.User;

public interface IUserService {

	List<User> getAllUsers();
	User getUserById(int userId);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    
	
}
