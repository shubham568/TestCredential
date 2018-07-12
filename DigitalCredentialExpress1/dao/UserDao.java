package com.digitalcredential.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcredential.entity.User;

import com.digitalcredential.entity.*;

@Transactional
@Repository
public class UserDao implements IUserDao{
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public User getUser_id(int user_id) {
		return entityManager.find(User.class, user_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as atcl ORDER BY atcl.userId DESC";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public void updateUser(User user) {
		User artcl = setUser_id(user.getUser_id());
		artcl.setUser_name(user.getUser_name());
		artcl.setPassword(user.getPassword());
		entityManager.flush();
	}
	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserById(userId));
	}
	@Override
	public boolean userExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}

}
