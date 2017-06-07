package com.niit.controller;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.niit.dao.*;
import com.niit.model.*;
//@Controller
public class LoginController {
	//@Autowired
	//private 
	@RequestMapping(value = "login")
	public String DisplayLogin(Model mv) {
		mv.addAttribute("userDetails", new User());
		/*mv.addAttribute("categoryList", categoryDAO.list());
		mv.addAttribute("productList", productDAO.list());*/
		mv.addAttribute("IfLoginClicked", "true");
		mv.addAttribute("HideOthers","true");
		return "Welcome";
	}

	
	/*  @RequestMapping(value = "loginvalidation", method = RequestMethod.POST)
	  public String LoginValidation(@RequestParam("userName") String
	  userName, @RequestParam("password") String password, HttpSession session)
	  { if(userDAO.isValidUser(userName, password)) { UserDetails
	  user=userDAO.get(userName); if(user.getAdmin()==0) {
	  session.setAttribute("userId",user.getUserId());
	  session.setAttribute("name",user.getName());
	  session.setAttribute("LoggedIn","true");
	  session.setAttribute("UserLoggedIn", "true"); return "Welcome"; } else if
	  (user.getAdmin()==1) { session.setAttribute("userId",user.getUserId());
	  session.setAttribute("name",user.getName());
	  session.setAttribute("LoggedIn","true");
	  session.setAttribute("Administrator", "true"); return "Welcome"; } else {
	  return "redirect:login"; } } else { return "redirect:login"; }
	  
	  return "Welcome"; }
	 
*/
}
