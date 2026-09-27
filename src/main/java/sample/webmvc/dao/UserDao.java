package sample.webmvc.dao;

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

}