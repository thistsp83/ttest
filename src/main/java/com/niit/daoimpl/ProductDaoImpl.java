package com.niit.daoimpl;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.*;
import com.niit.dao.*;
@Repository
public class ProductDaoImpl implements ProductDAO{
	@Autowired
    SessionFactory sessionFactory;
    public List<Product> getAllProdcutsDetails() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        List<Product> product=sessionFactory.openSession().createCriteria(Product.class).list();
        //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
        
        session.getTransaction().commit();
        
        return product;
    }

   /* public ProductsModel getCategoryDetail(String id) {
    	ProductsModel p=(ProductsModel)sessionFactory.openSession().get(ProductsModel.class, id);

        // TODO Auto-generated method stub
        return p;
    }*/

    public void updateCategoryDetail(Product obj) {
        // TODO Auto-generated method stub
    	   Session s=sessionFactory.openSession();
           s.beginTransaction();
           s.update(obj);
           s.getTransaction().commit();
           s.close(); 
    }
    public Product findById(int id) {
		
		// TODO Auto-generated method stub
		return sessionFactory.openSession().get(Product.class,id);
	}

    public void addProducts(Product obj) 
    {
        System.out.println("Product Implementation");


        Session s=sessionFactory.openSession();
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
        s.close();
        
    }
 
	public List<Product> getAllProducts() {
		 Session sf =sessionFactory.openSession();
	        sf.beginTransaction();
	        Query query = sf.createQuery("from product");
	        List<Product> slist=query.list();
	        System.out.println(slist);
	        sf.getTransaction().commit();
	        return slist;
	}

	public void delete(Product obj) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(obj);
		s.getTransaction().commit();
		s.close();sessionFactory.openSession().delete(obj);
		
	}
	public List<Product> getFilterProducts(int cid)
	{
		Session s=sessionFactory.openSession();
		
		List<Product> results =s.createQuery("from product where CATEGORYID="+cid).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}
	public Product getCategoryDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}



}
