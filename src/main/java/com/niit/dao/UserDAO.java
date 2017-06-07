package com.niit.dao;

import java.util.ArrayList;


import com.niit.model.User;

public interface UserDAO 
{
	//create 
	 	public void save(User u);
		//read
		public  void getId(int id);
		//update
		public void update(User u);
		//deleted
		public void deleteById(int id);
		//Get All
		public ArrayList<User> getAll();
}
