package com.niit.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="product", uniqueConstraints = { @UniqueConstraint(columnNames = "productid") })
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	  @Column(name="productid")
		private int productid;
	  @Column(name="productbrand")
	  private String productbrand;
	  public String getProductbrand() {
		return productbrand;
	}
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	@Column(name="productname")
	  private String productname;
	  @Column(name="productdescription")
	  private String productdiscription;
	  public String getProductdiscription() {
		return productdiscription;
	}







	public void setProductdiscription(String productdiscription) {
		this.productdiscription = productdiscription;
	}

	@Column(name="productprice")
	  private double productprice;
	  //private int productquantity;
	 
	  @ManyToOne
	  @JoinColumn(name="categoryid")
	  private Category  categoryid;
	  @ManyToOne
	  @JoinColumn(name="suplierid")
	  private Supplier suplierid;
	  @Column(name="image")
	  private String p_image;
	  /*private byte[] productImage;
	  private MultipartFile images;
	  
	  @Transient
		MultipartFile defaultimage;
		
		@Transient
		List<MultipartFile> detailimage;*/


	public Product() {
			super();
			
		}

	//@Id

	//@Column(name="productid")//defining the database column

	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	//@Column(name="productname")
	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	//@Column(name="productprice")
	public double getProductprice() {
		return productprice;
	}


	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}





	//In One category we have MultipleProducts
	@ManyToOne
	@JoinColumn(name="categoryid")
	public Category getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}

	//In One supplier can have MultipleProducts
	@ManyToOne
	@JoinColumn(name="suplierid")
	public Supplier getSuplierid() {
		return suplierid;
	}


	public void setSuplierid(Supplier suplierid) {
		this.suplierid = suplierid;
	}



	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}


	public Product(int productid, String productbrand, String productname, String productdiscription,
			double productprice, Category categoryid, Supplier suplierid, String p_image) {
		super();
		this.productid = productid;
		this.productbrand = productbrand;
		this.productname = productname;
		this.productdiscription = productdiscription;
		this.productprice = productprice;
		this.categoryid = categoryid;
		this.suplierid = suplierid;
		this.p_image = p_image;
	}
	public Product(int productid, String productname, double productprice, Category categoryid, Supplier suplierid, String p_image) {
		super();
		this.productid = productid;
		//this.productbrand = productbrand;
		this.productname = productname;
		//this.productdiscription = productdiscription;
		this.productprice = productprice;
		this.categoryid = categoryid;
		this.suplierid = suplierid;
		this.p_image = p_image;
	}
	/*public Product(String productid, String productbrandname, String productname, String productdescription,
			Category prodCategory, Supplier prodSupplier, String productprice, String productimage) {
		super();
		this.prodId = prodId;
		this.prodBrand = prodBrand;
		this.prodName = prodName;
		this.prodDescription = prodDescription;
		this.prodCategory = prodCategory;
		this.prodSupplier = prodSupplier;
		this.prodPrice = prodPrice;
		this.proImage = proImage;
	}*/

	

	@Override
	public String toString() {
		return "ProductsModel [prodId=" + productid + ", prodbrand=" + productbrand + ", prodName=" + productname
				+ ", prodDescription=" + productdiscription + ", prodCategory=" + categoryid + ", prodSupplier="
				+ suplierid + ", prodPrice=" + productprice + ", proImage=" + p_image + "]";
	}


}
