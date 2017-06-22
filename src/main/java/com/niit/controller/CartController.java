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
//@RequestMapping("/user")
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
	@RequestMapping("/cartview")
	public ModelAndView viewCart(){
		
		ModelAndView mv=new ModelAndView("cartview");
		List<Cart> cartList=cartdaoimpl.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	@RequestMapping("/viewcart")
	public ModelAndView viewCartview(){
		
		ModelAndView mv=new ModelAndView("viewcart");
		List<Cart> cartList=cartdaoimpl.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	/*@RequestMapping("/productsdetails")
	public ModelAndView viewProduct(){
		
		ModelAndView mv=new ModelAndView("productsdetails");
		List<Product> plist=productdaoimpl.getAllProdcutsDetails();
		
		mv.addObject("plist", plist);
		return mv;
	}*/
	
	
	@RequestMapping(value="/cart",method = RequestMethod.POST)
	public ModelAndView addCart(HttpServletRequest request){
		int id=Integer.valueOf(request.getParameter("id"));
		int q=Integer.valueOf(request.getParameter("q"));
		
		Product p=productdaoimpl.findById(id);
		double price=p.getProductprice();
		Cart c=new Cart();
	    c.setPrices((int)price); 
		c.setQuantity(q);
		 
		c.setProductid(p);
		c.setCartid(1);
		
		List<Cart> list=cartdaoimpl.checkExistance(id);
		int count=list.size();
		System.out.println("No of times: "+count);
		if(count==0)
		{
		
		cartdaoimpl.save(c);
		}
		else
		{

        Cart cart=cartdaoimpl.findById(list.get(0).getCartid());
        double ex=cart.getQuantity();
        System.out.println("-----------Existance Count ="+ex+"\n current Count = "+q+"------------\n---Total =-"+(ex+q));
        double tot=ex+q;
        cart.setQuantity(count);
        cartdaoimpl.update(cart);
		}
		
		System.out.println(c);
		
		ModelAndView mv=new ModelAndView("cartview");
		List<Cart> cartlist=cartdaoimpl.getAllCarts();
		
		mv.addObject("cartlist", cartlist);
		return mv;
		
	}
	
	@RequestMapping("/customerdetails")
	public ModelAndView customer(HttpServletRequest request)
	{
		double tot=Double.parseDouble(request.getParameter("tot"));
		
		ModelAndView mv=new ModelAndView("customerdetails");
		mv.addObject("tot", tot);
		return mv;
	}
   
   @RequestMapping("/invoice")
	public ModelAndView invoice(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		String phone=request.getParameter("contact_no");
		String email=request.getParameter("email");
		String tot=request.getParameter("tot");
		ModelAndView mv=new ModelAndView("invoice");
		mv.addObject("name", name);
		mv.addObject("add", add);
		mv.addObject("phone", phone);
		mv.addObject("email", email);
		mv.addObject("tot", tot);
		return mv;
	}

   
   @RequestMapping("/cart_delete")
	public ModelAndView deleteCart(HttpServletRequest request)
	{
		int cid=Integer.valueOf(request.getParameter("id"));
		Cart c=cartdaoimpl.getId(cid);
		cartdaoimpl.deleteById(cid);
		
		ModelAndView mv=new ModelAndView("cartview");
		List<Cart> cartList=cartdaoimpl.getAllCarts();
		
		mv.addObject("cartlist", cartList);
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
