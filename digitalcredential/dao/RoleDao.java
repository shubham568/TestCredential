package com.digitalcredential.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Role;

public class RoleDao implements IRoleDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Role getRoleByid(int role_Id) {
		return entityManager.find(Role.class, role_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		String hql = "FROM Role as rle ORDER BY rle.role_id DESC";
		return (List<Role>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public void deleteRole(int role_Id) {
		entityManager.remove(getRoleByid(role_Id));
	}
	@Override
	public boolean roleExists(String role_name, String role_desc) {
		String hql = "FROM Role as rle WHERE rle.role_name = ? and rle.role_desc = ?";
		int count = entityManager.createQuery(hql).setParameter(1, role_name)
		              .setParameter(2, role_name).getResultList().size();
		return count > 0 ? true : false;
	}



}
