package com.digitalcredential.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.User_Role;

public class UserRoleDao implements IUserRolesDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public User_Role getUser_RoleByUserid(int User_Id) {
		return entityManager.find(User_Role.class, User_Id);
	}
	
	@Override
	public User_Role getUser_RoleByRoleid(int role_Id) {
		return entityManager.find(User_Role.class, role_Id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User_Role> getAllUserRoles() {
		String hql = "FROM User_Role as ure ORDER BY ure.user_id DESC";
		return (List<User_Role>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public boolean userroleExists(int user_Id, int role_Id) {
		String hql = "FROM User_Role as ure WHERE ure.user_Id = ? and ure.role_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, user_Id)
		              .setParameter(2, role_Id).getResultList().size();
		return count > 0 ? true : false;
	}




}
