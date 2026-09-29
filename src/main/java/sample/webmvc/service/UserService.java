package sample.webmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.webmvc.dao.UserDao;
import sample.webmvc.entity.User;

@Service

public class UserService {
	
	@Autowired
    private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = false)
	public  User saveUser(User user) {
		return userDao.saveUser(user);
		 
	}
	public User getUserById(int id) {
		System.out.println("UserService.getUserById()");
		return userDao.getUserById(id);
	}

	
	@Transactional(readOnly = false)
	public User updateUser(int id, User user) {
		user.setId(id);
		return userDao.updateuser(user);
	}
	@Transactional(readOnly = false)
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	
}

	
