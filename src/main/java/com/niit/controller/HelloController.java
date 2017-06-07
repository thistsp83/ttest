package com.niit.controller;

import java.util.List;

/*import java.io.BufferedOutputStream;
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
import javax.script.ScriptException;*/
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
import com.niit.daoimpl.CartDaoImpl;
import com.niit.model.Supplier;
//import com.niit.dao.*;
import com.niit.model.*;
import com.niit.model.Product;
//@SuppressWarnings("unused")
@Controller

public class HelloController {
	//@Autowired
	private CategoryDaoImpl categorydaoimpl;
	//@Autowired
	private SupplierDaoImpl supplierdaoimpl;
	//@Autowired
	private UserDaoImpl userD;
	@Autowired
	private ProductDaoImpl productdaoimpl;
	@Autowired
	private CartDaoImpl cartdaoimpl; 
@RequestMapping("/productdetails")
public ModelAndView addCarttable(HttpServletRequest request) 
{
	
	int id=Integer.valueOf(request.getParameter("prodid"));
	
	int quan=Integer.valueOf(request.getParameter("prodquantity"));
	
	int price=Integer.valueOf(request.getParameter("prodprice"));
	/*int uid=Integer.valueOf(request.getParameter("userid"));
	int sid=Integer.valueOf(request.getParameter("suplierid"));*/
	
	/*UserModel c=user1.findById(uid);
	SupplierModel s=supplierDAO.findById(sid);*/
	System.out.println(""+id+""+quan+""+price);
	
	Product p=productdaoimpl.findById(id);
	Cart g=new Cart();
	g.setPrices(price);
	g.setQuantity(quan);
	g.setProductid(p);
	/*g.setSuplierid(s);
	g.setUserid(c);*/
	
	
	cartdaoimpl.save(g);
	
	ModelAndView mv = new ModelAndView("productdetails");
	return mv;
}
}
