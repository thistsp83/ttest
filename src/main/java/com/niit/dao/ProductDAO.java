package com.niit.dao;

//import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

//import com.niit.OnlineWebBackEnd.model.CategoryModel;
import com.niit.model.Product;


//@Service

public interface ProductDAO
{
 
	
List<Product> getAllProdcutsDetails();
	
	Product getCategoryDetail(String id);
	
	void updateCategoryDetail(Product obj);
	
	void addProducts(Product obj);
	public List<Product> getAllProducts();
	public void delete(Product obj);
	public Product findById(String id);
	public Product findById(int id);
	public List<Product> getFilterProducts(int cid);	
}
