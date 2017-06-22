package com.niit.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//Entity Mapped to the table
@Entity	
@Table(name="ORDER")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
	@Column(name="orderid")
    private int orderid;
   // private int userid;
    @Column(name="payment")
    private String payment;
    @Column(name="ordertotal")
    private int ordertotal;
    @ManyToOne
	@JoinColumn(name="email")
    private User email;
    public User getEmail() {
		return email;
	}
	public void setEmail(User email) {
		this.email = email;
	}
	//defining the database column
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	//In ManyOrder given by one user
	
	
	//@Column(name="payment")
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	//@Column(name="ordertotal")
	public int getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}

}
