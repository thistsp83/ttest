package com.niit.daoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.niit.dao.*;
import com.niit.model.Category;
import com.niit.model.Supplier;
@Repository
public class SupplierDaoImpl implements SupplierDAO{
	private Session currentSession;
	private Transaction currentTransaction;
	@Autowired
    private SessionFactory sessionFactory;
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
//		getCurrentSession().save(supplier);
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(supplier);
		s.getTransaction().commit();
		s.close();
	}

	public Supplier getId(int id) {
		// TODO Auto-generated method stub
		Supplier supplier = (Supplier) sessionFactory.openSession().get(Supplier.class, id);

        return supplier;

		//return null;
	}

	public void update(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(id);
	}

	public List<Supplier> getSave() {
		// TODO Auto-generated method stub
		//return null;
	//	List<Supplier> suppliers = (List<Supplier>) getCurrentSession().createQuery("from Supplier").list();
		Session session=sessionFactory.openSession();
		List<Supplier> products =null;
		session.beginTransaction();
		products= session.createQuery("from Supplier").list();   
		session.getTransaction().commit();
		  return products;
		//return suppliers;

	}

	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Session openCurrentSession() {
		currentSession = sessionFactory.openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = sessionFactory.openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	//@Autowired
	/*
	public SessionFactory setSessionFactory(SessionFactory sessionFactory){
		return sessionFactory;
	}*/
}
