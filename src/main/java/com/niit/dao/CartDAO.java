package com.niit.dao;
import java.util.List;
import com.niit.model.*;

public interface CartDAO {
	public void save(Cart cart);
    //read
		public Cart getEmail(String email);
		//update
		public void update(Cart cart);
		//deleted
		public void deleteById(int id);
		//Get All
		public List<Cart> getAll();

}
