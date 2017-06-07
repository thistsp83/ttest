package com.niit.dao;
import com.niit.model.*;
import java.util.List;

public interface SupplierDAO {
	public void addSupplier(Supplier supplier);
	//read
	public Supplier getId(int id);
	//update
	public void update(Supplier supplier);
	//deleted
	public void deleteById(int id);
	//Get All
	public List<Supplier> getSave();
	
	public Supplier findById(int id);

}
