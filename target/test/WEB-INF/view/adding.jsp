<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page errorPage = "error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Details</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
  
  <%@page import="com.niit.model.Category" %>
    <%@page import="com.niit.model.Supplier" %>
    <%@page import="java.util.List" %>
    </head>
<body>

<div class="panel panel-primary">
<div class="panel-heading">
  <!-- Header Content -->
   <jsp:include page="header.jsp"/>
</div>
<br>
<br>
<div class="panel-body">
<div class="container">
<form class="form-horizontal" action="actionProd"  method="post" enctype="multipart/form-data" >
 <fieldset>

<legend>Add Product</legend>
<div class="form-group">
  <label class="col-md-4 control-label" for="fn">Product Id</label>  
  <div class="col-md-4">
  <input id="pid" name="pid" type="text" required="required">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Product Name</label>  
  <div class="col-md-4">
  <input id="pname" name="pname" type="text" required="required">
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Product Price</label>  
  <div class="col-md-4">
  <input id="pprice" name="pprice" type="text" required="required">
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Product Category</label> 
  <div class="col-md-4"> 
   <select name="categoryitems" id="categoryitems" style="width:150px;">
    <option  selected="selected">Category</option>
      <c:forEach items="${category}" var="cat">
      
            <option value="${cat.categoryid}">${cat.categoryname}</option>
            
    </c:forEach>
    
      <%--  <%
             	   List<Category> clist=(List<Category>) request.getAttribute("categoryList");
    			   for(Category c : clist){
    				out.println("<option value='"+ c.getCategoryid() +"'>"+ c.getCategoryname() + "</option>");
    			}
    			
             %> --%>
</select>
</div>
</div>
<div class="form-group">
   <label class="col-md-4 control-label" for="ln">Product Supplier</label>
   <div class="col-md-4">
   <select name="supplieritems" id="supplieritems" style="width:150px;">
    <option  selected="selected">Supplier</option>
    <c:forEach items="${supplier}" var="sup">
     
            <option value="${sup.suplierid}">${sup.suppliername}</option>
  
    </c:forEach>
</select>
</div>
  </div>
  <div class="form-group">
  <div class="form-group">
   <label class="control-label" for="productImage">Upload Picture
   </label>
   <input name="file" id="fileToUpload" type="file" />
  
   
  </div>
  <!-- <form method="post" enctype="multipart/form-data">  
<p><label class="col-md-4 control-label" for="image">Upload Image</label></p> 
<div class="col-md-4"> 
<p><input name="file" id="fileToUpload" type="file" /></p>  
</div>
</form> -->
  </div>
  
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-primary">Add</button>
     <button type="reset" class="btn btn-primary">Cancel</button>
  </div>
</div>
</fieldset>
 </form>
</div>
<div class="container">
 <form class="form-horizontal" action="actionCat" method="post">
 <fieldset>

<!-- Form Name -->
<legend>Add Category</legend>
  <div class="form-group">
  <label class="col-md-4 control-label" for="fn">Category Id</label>  
  <div class="col-md-4">
  <input id="cid" name="cid" type="text" required="required">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Category Name</label>  
  <div class="col-md-4">
  <input id="cname" name="cname" type="text" required="required">
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button  type="submit" class="btn btn-primary">Add</button>
     <button type="reset"  class="btn btn-primary">Cancel</button>
  </div>
</div>
</fieldset>
 </form>
   </div>
   <div class="container">
    <form class="form-horizontal" action="actionSup" method="post">
             <fieldset>

<!-- Form Name -->
<legend>Add Supplier</legend>
                 <div class="form-group">
  <label class="col-md-4 control-label" for="fn">Supplier Id</label>  
  <div class="col-md-4">
  <input name="sid" type="text" required="required">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ln">Supplier Name</label>  
  <div class="col-md-4">
  <input name="sname" type="text" required="required">
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-primary">Add</button>
     <button type="reset" class="btn btn-primary">Cancel</button>
  </div>
</div>
</fieldset>
 </form>
  </div>
  </div>
 <div class="panel-footer">

 <!-- Footer Content -->
 <jsp:include page="footer.jsp"/>
</div>
 </div>
 
</body>
</html>