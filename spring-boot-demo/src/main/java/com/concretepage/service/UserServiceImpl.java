package com.concretepage.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.dao.UserRepository;
import com.concretepage.entity.User;

@Service
public class UserServiceImpl implements UserService {
    	
	@Autowired
	private UserRepository userRepository;
	
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    
      
    
    @Override
    public synchronized boolean save(User user) {
    	if(userRepository.userExists(user.getUsername(), user.getPassword())) {
    		return false;
    	}
    	else {
    	
        
        userRepository.addUser(user);
        return true;
    }
    }


	@Override
	public List<User> getUsersById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
		
	}

	


	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userRepository.addUser(user);
	}

	public User findByID(long userId) {
		return userRepository.findById(userId);
	}


	@Override
	public void  softdeleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(user);
	}

	


	
}

