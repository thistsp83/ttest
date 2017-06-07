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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.model.Category;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.model.Supplier;
//import com.niit.dao.*;
import com.niit.model.*;
import com.niit.model.Product;
//@SuppressWarnings("unused")
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private CategoryDaoImpl categorydaoimpl;
	@Autowired
	private SupplierDaoImpl supplierdaoimpl;
	@Autowired
	private UserDaoImpl userD;
	@Autowired
	private ProductDaoImpl productdaoimpl;
	private static final String UPLOAD_DIRECTORY ="/resources/images/";
	
	@RequestMapping("admin/signup")
	public ModelAndView signup() 
	{
		 ModelAndView mv = new ModelAndView("signup");
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
	

	@RequestMapping(value="admin/actionCat", method = RequestMethod.POST)
	public ModelAndView addCategory(@RequestParam("cid") int cid, @RequestParam("cname") String cname,RedirectAttributes attributes) 
	{
		

		Category c=new Category(cid,cname);
		c.setCategoryid(cid);
		c.setCategoryname(cname);
		
		//pr.addCategory(c);
		categorydaoimpl.addCategory(c);
		//RedirectAttributes attributes;
		attributes.addFlashAttribute("Sucessess Message", "Category Added Successfully..");
		//return new ModelAndView("Adding"); 
		return new ModelAndView("admin/adding");
        
	}
		
	@RequestMapping(value="admin/actionSup", method = RequestMethod.POST)
	public ModelAndView addSupplier(@RequestParam("sid") int sid, @RequestParam("sname") String sname) 
	{
		Supplier c=new Supplier();
		
		c.setSuplierid(sid);
		c.setSuppliername(sname);
		
		supplierdaoimpl.addSupplier(c);
		return new ModelAndView("modeldialogs"); 
	}

	@RequestMapping(value="admin/actionProd", method = RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request)
	{

		System.out.println("in Products Controller");
		int id=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		Double price=Double.parseDouble(request.getParameter("pprice"));
		int cid=Integer.parseInt(request.getParameter("categoryitems"));
		int sid=Integer.parseInt(request.getParameter("supplieritems"));
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=id+file.getOriginalFilename();
		System.out.println(id+"-"+pname+"-"+price+"-"+cid+"-"+sid+"---");
		Category c=categorydaoimpl.getId(cid);
		Supplier s=supplierdaoimpl.getId(sid);
		Product p=new Product();
		p.setProductid(id);
		p.setProductname(pname);
		p.setProductprice(price);
		p.setSuplierid(s);
		p.setCategoryid(c);
		
		List<Category> list=categorydaoimpl.getAll();
		List<Supplier> slist=supplierdaoimpl.getSave();
		p.setP_image(filename);
		productdaoimpl.addProducts(p);
		
		//productdaoimpl.addProducts(new Product(id, pname, price, c, s,filename));
		
		//productdaoimpl.addProduct(new Product(id, pname, price, c, s,filename));
		
		String path =request.getSession().getServletContext().getRealPath(UPLOAD_DIRECTORY);  
	    
	    System.out.println(path+""+filename);  
	  
	    byte[] bytes;
		try {
			bytes = file.getBytes();
			 BufferedOutputStream stream;
			stream = new BufferedOutputStream(new FileOutputStream(path+"./resources/image/"+filename));
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
		mv.addObject("clist",list);
		mv.addObject("slist",slist);
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
	}

}
