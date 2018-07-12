package com.digitalcredential.dao;

import java.util.List;

import com.digitalcredential.entity.User;

public interface IUserDao {
	List<User> getAllUsers();
	User getUser_Id(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(String User_name, String Password);

}
