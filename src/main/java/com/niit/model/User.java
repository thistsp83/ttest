package com.niit.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.niit.model.User;

@Entity	
@Table(name="USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	//@Id
//	@Column(name="userid")//defining the database column
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="userpassword")
	private String userpassword;
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	@Column(name="age")
	private int age;
	
	@Column(name="address")
	private String useraddress;
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	@Column(name="city")
	private String city;
	@Column(name="phone")
	private String phone;
	@Column(name="gender")
	private String gender;
	@Column(name="enabled")
	private boolean enabled;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid") 
	private Cart cartid;
	
	 public Cart getCartid() {
		return cartid;
	}
	public void setCartid(Cart cartid) {
		this.cartid = cartid;
	}*/
	//@OneToMany(targetEntity=Order.class, mappedBy="userid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//private Set<Order> setoforders;
	@Column(name="role") 
	private String role;
	
	 public User() {
			super();
		}
	public User(String email, String userpassword, String username, String useraddress, int age, String city,
			String phone, String gender, String role, boolean enabled) {
		super();
		//this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.useraddress = useraddress;
		this.email = email;
		this.age = age;
		this.city = city;
		this.phone = phone;
		this.gender = gender;
		//this.cartid = cartid;
		this.role = role;
	//	this.setoforders = setoforders;
	}
	//@Id
		
	@Column(name="enabled")
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	 
	//In One User we have onecart
	
	/*public CartModel getCartid() {
		return cartid;
	}
	
	public void setCartid(CartModel cartid) {
		this.cartid = cartid;
	}*/
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//One user have multiple setoforders
		
			//@Column(name="setoforders")
	/*public Set<Order> getSetoforders() {
		return setoforders;
	}
	public void setSetoforders(Set<Order> setoforders) {
		this.setoforders = setoforders;
	}*/


}
