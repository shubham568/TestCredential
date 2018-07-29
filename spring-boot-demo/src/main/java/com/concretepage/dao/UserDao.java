package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;

import com.concretepage.entity.User;
import com.concretepage.entity.UserState;

@Transactional
@Repository
public class UserDao implements UserRepository{
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	
	
	@Override
	public List<User> getUserById(long userId) {
		String hql = "FROM User as atcl where atcl.userId= ? ORDER BY atcl.userId DESC";
		return (List<User>) entityManager.createQuery(hql).setParameter(0, userId).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as atcl ORDER BY atcl.userId DESC";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	

	@SuppressWarnings("rawtypes")
	@Override
	public void addUser(User user) {
		
		entityManager.persist(user);
		
	}
	
	@Override
	public void updateUser(User user) {
	
		User users =  findById(user.getUserId());
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setEnable(user.getEnable(UserState.TRUE));
		entityManager.flush();
		
	}
	
	@PreRemove
	@Override
	public void deleteUser(User user) {
		//log.info("Set state to be DELETED");
		//user.setEnable(user.getEnable());
		//String hql = "user as u set u.enable=FALSE where u.user_id=? ";
		String hql="update User u set u.enable='FALSE' where u.userId="+user.getUserId();
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		//update Student s set e=s.marks=50 where s.studentId=?;
	//entityManager.remove(user);
	}

	
	
	
	@Override
	public boolean userExists(String username, String password) {
		String hql = "FROM User as atcl WHERE atcl.username = ? and atcl.password = ?";
		int count = entityManager.createQuery(hql).setParameter(0, username)
		              .setParameter(1, password).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public User findById(long userId) {
		// TODO Auto-generated method stub
		//String sql = "select * FROM User as atcl where atcl.userId= ?";
		//SqlParameterSource hql=
		//return  (User) entityManager.createQuery(hql).getSingleResult();
		return entityManager.find(User.class, userId);

	}

	

	
	
	

	
}
