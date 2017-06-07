package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.model.Category;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.model.Supplier;
//import com.niit.dao.*;
import com.niit.model.*;
import com.niit.model.Product;
@SuppressWarnings("unused")
@Controller
public class HomeController {
	@Autowired
	private CategoryDaoImpl categorydaoimpl;
	@Autowired
	private SupplierDaoImpl supplierdaoimpl;
	@Autowired
	private UserDaoImpl userD;
	@Autowired
	private ProductDaoImpl productdaoimpl;
	private static final String UPLOAD_DIRECTORY ="/resources/images/";
	@RequestMapping(value="/")
	public ModelAndView homepage()
	{
		ModelAndView m1=new ModelAndView("index");
		return m1;
		
	}
	@RequestMapping(value="/home")
	public ModelAndView home()
	{
		ModelAndView m1=new ModelAndView("index");
		return m1;
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() 
	{
		 ModelAndView mv = new ModelAndView("signup");
		  return mv;
	}
	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request)
	{
		User um=new User();
		um.setEmail(request.getParameter("useremail"));
		um.setAge(Integer.parseInt(request.getParameter("userage")));
		um.setCity(request.getParameter("usercity"));
		um.setEnabled(false);
		um.setGender(request.getParameter("usergender"));
		um.setPhone(request.getParameter("userphone"));
		um.setRole("ROLE_USER");
		um.setUseraddress(request.getParameter("useraddress"));
		um.setUsername(request.getParameter("username"));
		um.setUserpassword(request.getParameter("userpassword"));
				
		userD.save(um);
		 ModelAndView mv = new ModelAndView("index");
		  return mv;
		
	}

	@RequestMapping(value="/index")
	public ModelAndView indexpage()
	{
		ModelAndView m1=new ModelAndView("index");
		return m1;
		
	}
	

   @RequestMapping(value="/login")
	public ModelAndView loginpage()
	{
		ModelAndView m2=new ModelAndView("login");
		return m2;
		
	}
@RequestMapping(value="/registerpage")
  public ModelAndView registerpage()
  {
	ModelAndView m3=new ModelAndView("login");
	return m3;
  }

@RequestMapping(value="/productdescription")
public ModelAndView product_detail()
{
	ModelAndView m3=new ModelAndView("productdescription");
	return m3;
}
@RequestMapping("/individualitem")
public ModelAndView productListView() {
	List<Product> plist=productdaoimpl.getAllProdcutsDetails();
	ModelAndView model=new ModelAndView("individualitem");
	 model.addObject("productli", plist);
	 return model;	
	
}
/*@RequestMapping("/categoryadd")
public ModelAndView addCategory(HttpServletRequest request) {
	int c_id=Integer.valueOf(request.getParameter("c_id"));
	String str=request.getParameter("c_name");
	System.out.println(c_id+str);
	Category cat = new Category(c_id, str);
	categorydaoimpl.addCategory(cat);
	ModelAndView mv = new ModelAndView("adding");
	
	return mv;
}*/
/*@RequestMapping("/CategoryList")
public ModelAndView listCategory(HttpServletRequest request) {
	categorydaoimpl.getAll();
	ModelAndView mv = new ModelAndView("CategoryList");
	
	return mv;
}
@RequestMapping("/supplieradd")
public ModelAndView addSupplier(HttpServletRequest request) {
	int c_id=Integer.valueOf(request.getParameter("s_id"));
	String str=request.getParameter("s_name");
	System.out.println(c_id+str);
	Supplier sup = new Supplier(c_id, str);
	supplierdaoimpl.addSupplier(sup);
	ModelAndView mv = new ModelAndView("adding");
	
	return mv;
}*/
@RequestMapping(value ="/CategoryList")
public ModelAndView CategoryListData() {
    
 ModelAndView model=new ModelAndView("CategoryList");
 model.addObject("categoryList", categorydaoimpl.getAll());
 return model;
}
@RequestMapping("/supplierlist")
public ModelAndView listSupplier() {
	//supplierdaoimpl.getSave();
	ModelAndView mv = new ModelAndView("supplierlist");
	mv.addObject("slist", supplierdaoimpl.getSave());

	return mv;
}
@RequestMapping("/productlist")
public ModelAndView listProdduct() {
	//supplierdaoimpl.getSave();
	ModelAndView mv = new ModelAndView("productlist");
	mv.addObject("prolist", productdaoimpl.getAllProducts());
    
	return mv;
}
@RequestMapping("admin/adding")
public ModelAndView product() {
	//List<Category> list=categorydaoimpl.getAll();
	//List<Supplier> list1=supplierdaoimpl.getSave();
	ModelAndView mv = new ModelAndView("adding");
	mv.addObject("category",categorydaoimpl.getAll());
	mv.addObject("supplier",supplierdaoimpl.getSave());
	return mv;
}

/*
@RequestMapping(value="/actionCat", method = RequestMethod.POST)
public ModelAndView addCategory(@RequestParam("cid") int cid, @RequestParam("cname") String cname) 
{
	

	Category c=new Category(cid,cname);
	c.setCategoryid(cid);
	c.setCategoryname(cname);
	
	//pr.addCategory(c);
	categorydaoimpl.addCategory(c);
	//return new ModelAndView("Adding"); 
	return new ModelAndView("modeldialogc");

}
	
@RequestMapping(value="/actionSup", method = RequestMethod.POST)
public ModelAndView addSupplier(@RequestParam("sid") int sid, @RequestParam("sname") String sname) 
{
	Supplier c=new Supplier();
	
	c.setSuplierid(sid);
	c.setSuppliername(sname);
	
	supplierdaoimpl.addSupplier(c);
	return new ModelAndView("modeldialogs"); 
}

@RequestMapping(value="/actionProd", method = RequestMethod.POST)
public ModelAndView addProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request)
{

	System.out.println("in Products Controller");
	int id=Integer.parseInt(request.getParameter("pid"));
	String pname=request.getParameter("pname");
	Double price=Double.parseDouble(request.getParameter("pprice"));
	int cid=Integer.parseInt(request.getParameter("categoryitems"));
	int sid=Integer.parseInt(request.getParameter("supplieritems"));
	String filename=id+file.getOriginalFilename();
	System.out.println(id+"-"+pname+"-"+price+"-"+cid+"-"+sid+"---");
	Category c=categorydaoimpl.getId(cid);
	Supplier s=supplierdaoimpl.getId(sid);
	
	productdaoimpl.addProduct(new Product(id, pname, price, c, s,filename));
	
	String path =request.getSession().getServletContext().getRealPath(UPLOAD_DIRECTORY);  
    
    System.out.println(path+""+filename);  
  
    byte[] bytes;
	try {
		bytes = file.getBytes();
		 BufferedOutputStream stream;
		stream = new BufferedOutputStream(new FileOutputStream(path+filename));
		stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   // callScript();
	ModelAndView mv = new ModelAndView("modeldialogp");
	
	return mv;
}

@SuppressWarnings("restriction")
private void callScript() 
{
//	@SuppressWarnings("restriction")
	ScriptEngineManager manager = new ScriptEngineManager();
	//@SuppressWarnings("restriction")
	ScriptEngine engine = manager.getEngineByName("JavaScript");
	// read script file
	try {
		engine.eval(Files.newBufferedReader(Paths.get("/resources/javascript/getDetails.js"), 

		StandardCharsets.UTF_8));
	} catch (ScriptException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Invocable inv = (Invocable) engine;
	// call function from script file
	try {
		inv.invokeFunction("dialogBox");
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ScriptException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/

}
