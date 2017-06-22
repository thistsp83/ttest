package com.niit.daoimpl;
import com.niit.dao.*;

import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

import org.hibernate.Criteria;

//import javax.annotation.Resource;

//import javax.sql.DataSource;

//import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.*;

@Repository
public class CategoryDaoImpl implements CategoryDAO{
	 @Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
		//	this.sessionFactory = sf;
		}
	public void addCategory(Category category1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(category1);
		s.getTransaction().commit();
		s.close();
		
	}

	public Category getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Category> getAll() 
	{
		//List<Category> listCategory=new ArrayList<Category>();
		/*List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		//@SuppressWarnings("unchecked")*/
		
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			Query query =s.createQuery("from Category");        
			List<Category> list=query.list();
			System.out.println(list);
			s.getTransaction().commit();
		    //List<Category> c=new ArrayList<Category>();
			return list;
		/*Session session=sessionFactory.openSession();
		List<Category> products =null;
		session.beginTransaction();
		products= session.createQuery("from Category").list();   
		session.getTransaction().commit();
		  return products;*/
		
	}

	
	
		
	public Category findById(int id) 
	{
		
		Category c=(Category)sessionFactory.openSession().get(Category.class, id);
		//Category c=new Category();
		return c;
	}


}