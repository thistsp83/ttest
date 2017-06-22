package com.niit.daoimpl;
import java.util.List;

//import org.h2.engine.Session;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.dao.*;
import com.niit.model.Cart;

@Repository
public class CartDaoImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Cart cart) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart);
		s.getTransaction().commit();
		s.close();
		
	}

	public Cart getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Cart cart) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(cart);
		s.getTransaction().commit();
		s.close();
		
	}

	public void deleteById(int id) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		Cart cart=(Cart)session.get(Cart.class,id);
		session.delete(cart);
		session.getTransaction().commit();
		
	}

	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cart> getAllCarts() {
		Session s=sessionFactory.openSession();
		List<Cart> clist=s.createCriteria(Cart.class).list();
		s.clear();
		return clist;
		 
	}

	public void delete(Cart cartId) {
		/*Session session=sessionFactory.openSession();
		session.beginTransaction();

		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.delete(cart);
		session.getTransaction().commit();*/
	}

	public Cart findById(int id) {
		
		Cart c=(Cart)sessionFactory.openSession().get(Cart.class, id);
		return c;
		 
		 
	}

	public List<Cart> checkExistance(int id) {
		   Session s=sessionFactory.openSession();		
	        List<Cart> results =s.createQuery("from Cart where cartid="+id).list();		
			s.close();
			return results;

		 
	}

	@Override
	public Cart getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
