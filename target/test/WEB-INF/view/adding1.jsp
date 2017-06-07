<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Category</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
  <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="./resources/css/Details.css" rel="stylesheet" type="text/css"/>
  <link href="./resources/css/adding.css" rel="stylesheet" type="text/css"/>
  <style>.carousel-inner > .item > img { width:100%; height:350px; } </style>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"/>
 <%@page import="com.niit.model.Category" %>
   
    <%@page import="java.util.List" %>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h3>Category Table</h3>
	<form action="categoryadd" class="form-horizontal" role="form">
        <div class="container">
            <div class="form-group">
		        <label for="name" class ="control-label col-sm-3"><b>Category_Id</b></label>
		    <div class="col-sm-8">
		         <input type="text" class="form-control" name="C_ID" /></div></div>
		    <div class="form-group">
		         <label for="name" class ="control-label col-sm-3"><b>Category_Name</b></label>
		    <div class="col-sm-8">
		         <input type="text"  class="form-control" name="C_NAME" /></div></div>
		   <a href="listcategory"><button type="submit">Add</button></a> 
		        <button type="button" class="cancelbtn">Cancel</button>
	      </div>
	  </form>
 <h3>Supplier Table</h3>
	  <form action="supplieradd" class="form-horizontal" role="form">
	     <div class="container">
	           <div class="form-group">
			        <label for="name" class ="control-label col-sm-3"><b>Supplier_Id</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="S_ID" /></div></div>
			   <div class="form-group">
			       <label for="name" class ="control-label col-sm-3"><b>Supplier_Name</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control"name="S_NAME" /></div></div>
			   <button type="submit">Add</button>
			        <button type="button" class="cancelbtn">Cancel</button>
	     </div>
	 </form>
	  
	   <h3>Product Table</h3>
	  <!-- <form action="add_product" class="form-horizontal" role="form" method="post" enctype="multipart/form-data"> -->
	  <form action="productadd" class="form-horizontal" role="form">
	           <div class="form-group">
			        <label for="pId" class ="control-label col-sm-3"><b>Product_Id</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pId" /></div></div>
			   <div class="form-group">
			       <label for="pName" class ="control-label col-sm-3"><b>Product_Name</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pName" /></div></div>
			    <div class="form-group">
			       <label for="pPrice" class ="control-label col-sm-3"><b>Product_Price</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pPrice" /></div></div>
			   
			    <div class="form-group">
		            <label for="pCategory" class ="control-label col-sm-3"><b>Product_Category</b></label>
		         <div class="col-sm-4">
		             <select class="form-control" name="pCategory">
		                  <option value="0">Select</option>
		                    <%
             	  /* List<Category> clist=(List<Category>) request.getAttribute("list");
    			   for(Category c : clist){
    				out.println("<option value='"+ c.getCategoryid() +"'>"+ c.getCategoryname() + "</option>");
    			}*/
    			
             %>
	                </select></div></div>
		              
		         <div class="form-group">
		            <label for="pSupplier" class ="control-label col-sm-3"><b>Product_Suppliers</b></label>
		         <div class="col-sm-4">
		             <select class="form-control" name="pSupplier">
		                  <option value="0">Select</option>
		                <%
             	/*List<Supplier> slist=(List<Supplier>) request.getAttribute("slist");
    			for(Supplier c : slist){
    				out.println("<option value='"+ c.getS_id() +"'>"+ c.getS_name() + "</option>");
    			}*/
    			
             %>      
                   
                     </select></div></div>
                    <!-- <div class="form-group">   
                        <label for="img" class ="control-label col-sm-3"><b>Product_Image</b></label>
                     <div class="col-sm-4">
                          <input type="file" name="img">
                          <br>
                          <button onclick="myFunction()">Upload</button></div></div> -->
			   <button type="submit">Add</button>
			        <button type="button" class="cancelbtn">Cancel</button>
	     </div>
	 </form>
	 <script>
function myFunction() {
    var x = document.getElementById("myFile");
    x.disabled = true;
}
</script>
	  
</div>
<br>
<br>

	  

</body>
</html>