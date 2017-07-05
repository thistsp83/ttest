<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video CD's Cart Details Edit View</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" type="text/css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="./resources/css/shoe.css">
    <link rel="stylesheet" href="./resources/css/caroualresponsive.css">

</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<div class="container">
<div class="row">
<h2>Edit Video CD Cart Quantity Details</h2>
<hr/>
  <form action="cart_update"  method="post"  enctype="multipart/form-data">
  <input type="hidden" class="form-control" id="p_id" name="p_id" value="${cartlist.cartid}">
    <%-- <div class="form-group">
      <label for="p_id">Cart ID :</label>
      <input type="text" class="form-control" id="p_id" name="p_id" value="${cartlist.cartid}">
    </div> --%>
    <div class="form-group">
      <label for="p_name">Quantity :</label>
      <input type="text" class="form-control" id="p_name"  name="p_name" value="${cartlist.quantity}" required="required">
    </div>
    
    <button type="submit" class="btn btn-primary" >Save</button>
  </form>
          
           

</div></div>
	
<jsp:include page="footer.jsp" />  

</body>
</html>