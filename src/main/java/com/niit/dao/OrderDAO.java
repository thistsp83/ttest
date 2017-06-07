package com.niit.dao;
import com.niit.model.*;
import java.util.*;
public interface OrderDAO {
	 public void save(Order cart);
	    //read
			public  Order getId(int id);
			//update
			public void update(Order cart);
			//deleted
			public void deleteById(int id);
			//Get All
			public List<Order> getAll();

}
