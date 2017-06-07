package com.niit.daoimpl;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.*;
import com.niit.model.*;
@Repository
public class UserDaoImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
//public UserDAOImpl(){}

/*public SessionFactory getSessionFactory(){
	return sessionFactory;
}*/	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
public void save(User u) 
{
	Session s=sessionFactory.openSession();
	s.beginTransaction();
	s.save(u);
	s.getTransaction().commit();
	s.close();
}

public void getId(int id) {
	// TODO Auto-generated method stub
	
}

public void update(User User) {
	// TODO Auto-generated method stub
	
}

public void deleteById(int id) {
	// TODO Auto-generated method stub
	
}

public ArrayList<User> getAll() {
	// TODO Auto-generated method stub
	return null;
}
public User getUserDetail(String email) {
	User user = (User)sessionFactory.openSession().get(User.class,email);

    return user;
}


}
