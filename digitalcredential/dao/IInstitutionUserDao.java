package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Institution_User;

public interface IInstitutionUserDao {

	List<Institution_User> getAllInstitution_Users();
	Institution_User getInstitution_UserByid(int Institution_User_Id);
    void createInstitution_User(Institution_User institution_User);
    void updateInstitution_User(Institution_User institution_User);
    void deleteInstitution_User(int Institution_User_Id);
    boolean institution_UserExists(int Institution_Id, int User_Id,int Contact_Id);
	
}
