package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Role;


public interface IRoleDao {
	List<Role> getAllRoles();
	Role getRoleByid(int role_Id);
    void deleteRole(int role_Id);
    boolean roleExists(String role_name, String role_desc);
}
