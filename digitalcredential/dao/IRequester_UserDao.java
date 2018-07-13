package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Requester_User;

public interface IRequester_UserDao {

	List<Requester_User> getAllRequester_Users();
	Requester_User getRequester_UserByid(int requester_Id);
    void createRequester_User(Requester_User requester_user);
    void updateRequester_User(Requester_User requester_user);
    void deleteRequester_User(int requester_Id);
    boolean requester_UserExists(int User_Id, int Contact_Id);
	
}
