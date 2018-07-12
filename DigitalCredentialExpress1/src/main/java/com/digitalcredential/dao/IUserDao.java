package com.digitalcredential.dao;

import java.sql.Date;
import java.util.List;

import com.digitalcredential.entity.User;

public interface IUserDao {
	List<User> getAllUsers();
	User getUserByid(int user_id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(String User_name, String Password);
	User findByEmail(String email_Id);
	User findByConfirmationToken(String confirmation_Token);
	
	
	

}
