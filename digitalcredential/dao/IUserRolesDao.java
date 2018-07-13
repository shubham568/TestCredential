package com.digitalcredential.dao;

import java.util.List;

import com.digitalcredential.entity.User_Role;

public interface IUserRolesDao {
	List<User_Role> getAllUserRoles();
	User_Role getUser_RoleByUserid(int user_Id);
	User_Role getUser_RoleByRoleid(int role_Id);
    boolean userroleExists(int user_Id, int role_Id);
}
