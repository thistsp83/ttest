package com.niit.model;
import java.io.Serializable;
import java.util.List;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="categoryid")
	private int categoryid;
	@Column(name="categoryname")
	private String categoryname;
//	 @OneToMany(targetEntity=Product.class, mappedBy="categoryid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//	@Column(name="setofproducts")
	//private Set<Product> setofproducts;
	
	
	
	
	public Category() {
		super();
	}
	public Category(int categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	//@Id
	//@GeneratedValue
	//@Column(name="categoryid")//defining the database column
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	
	//@Column(name="categoryname")
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	//One category have multiple products
	/* @OneToMany(targetEntity=Product.class, mappedBy="categoryid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@Column(name="setofproducts")
		public Set<Product> getSetofproducts() {
			return setofproducts;
		}
		
		public void setSetofproducts(Set<Product> setofproducts) {
			this.setofproducts = setofproducts;
		}*/

}
