package com.niit.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.dao.*;
import com.niit.model.Cart;

@Repository
public class CartDaoImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	public Cart getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
