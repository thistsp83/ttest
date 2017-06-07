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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/user")
@Controller
public class CartController {
	@Autowired
	private CartDaoImpl cartdaoimpl;
	@Autowired
	private ProductDaoImpl productdaoimpl;
	@RequestMapping("user/ulogin")
	public ModelAndView signup() 
	{
		 ModelAndView mv = new ModelAndView("ulogin");
		  return mv;
	}
/*	@RequestMapping("user/addcart")
	public ModelAndView addToCart(@PathVariable("id") int Productid, @PathVariable("userId") int userId,
			@RequestParam("quantity") int q, HttpSession session) throws Exception
	{
		if (cartdaoimpl.getAll() != null) {
			Cart item = cartDAO.getitem(Product id, userId);
			item.setQuantity(item.getQuantity() + q);
			Product p = productDAO.get(item.getProductid());
			item.setPrice(item.getPrice() + (q * p.getPrice()));
			cartDAO.saveOrUpdate(item);
			session.setAttribute("cartsize", cartDAO.cartsize( (int) session.getAttribute("userId")));
			return "redirect:/view/"+p.getCategoryid();
		} else {
			/*Cart item = new Cart();
			Product product = productDAO.get(Productid);
			item.setProductname(product.getName());
			item.setUserid(userId);
			item.setQuantity(q);
			item.setPrice(q * product.getPrice());
			item.setStatus("C");
			item.setProductid(Productid);
			cartDAO.saveOrUpdate(item);
			session.setAttribute("cartsize", cartDAO.cartsize((int) session.getAttribute("userId")));
			return "redirect:/Welcome/"+product.getCategoryid();}
		ModelAndView mv = new ModelAndView("cart");
		  return mv;

	}*/
	
}
