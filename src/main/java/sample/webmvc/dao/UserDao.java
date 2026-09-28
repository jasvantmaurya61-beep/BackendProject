package sample.webmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import sample.webmvc.entity.User;

@Repository
public class UserDao {
    
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

    
	public void saveUser(User user) {
		hibernateTemplate.save(user);
		System.out .println("userDao.saveUser");
		
	}


	public  User getUserById(int id) {
		System.out.println("UserDao.getUserById()");
		
		return hibernateTemplate.get(User.class, id);
	}


	public  List<User> getAllUsers() {
		System.out.println("UserDao.getAllUser()");
		return hibernateTemplate.loadAll(User.class);
	}
      
	public void deleteUser(int id) {
		User user = hibernateTemplate.get(User.class,id);
		if(user!=null) {
			hibernateTemplate.delete(user);
		}
		
	}


	public void updateUser(User user) {
		
		hibernateTemplate.update(user);
	}
	
}