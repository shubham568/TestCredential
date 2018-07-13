package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcredential.entity.User;

@Transactional
@Repository
public class UserDao implements IUserDao{
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public User getUserByid(int user_id) {
		return entityManager.find(User.class, user_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as ur ORDER BY ur.userId DESC";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public void updateUser(User user) {
		User ur = getUserByid(user.getUser_id());
		ur.setUser_name(user.getUser_name());
		ur.setPassword(user.getPassword());
		entityManager.flush();
	}
	
	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserByid(userId));
	}
	@Override
	public boolean userExists(String User_name, String Password) {
	String hql = "FROM User as ur WHERE ur.User_name = ? and ur.Password = ?";
		int count = entityManager.createQuery(hql).setParameter(1, User_name)
		              .setParameter(2, Password).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public User findByEmail(String email_Id) {
		// TODO Auto-generated method stub
		String hql = "FROM User as ur WHERE ur.email_Id = ? ";
		User user = (User) entityManager.createQuery(hql).setParameter(1, email_Id).getResultList().get(0);
		return user;
		
	}

	@Override
	public User findByConfirmationToken(String confirmation_Token) {
		// TODO Auto-generated method stub
		String hql = "FROM User as ur WHERE ur.Confirmation_Token = ? ";
		User user = (User) entityManager.createQuery(hql).setParameter(1,confirmation_Token).getResultList().get(0);
		return user;
	}
}
