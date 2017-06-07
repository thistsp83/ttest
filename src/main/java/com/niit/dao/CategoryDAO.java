package com.niit.dao;
import java.util.List;
import com.niit.model.*;

public interface CategoryDAO {
	public void addCategory(Category category1);
	//read
	public Category getId(int id);
	//update
	public void update(Category category);
	//deleted
	public void deleteById(int id);
	//Get All
	public List<Category> getAll();
	
	public Category findById(int id);

}
