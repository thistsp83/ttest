<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage = "error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"> -->
	<html>
	 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="utf-8" />
	<title>Product list View</title>
	
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" type="text/css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	

</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<br/>
<br/>
 
<div class="container">
<div class="row">
   
   <p></p>
   <h1>product List view</h1>   
   <p> </p><p> </p>
   
       <div class="col-md-10 col-md-offset-1">

           <div class="panel panel-default panel-table">
             <div class="panel-heading">
               <div class="row">
                 <div class="col col-xs-6">
                   <h3 class="panel-title">List Table</h3>
                 </div>
                <!--  <div class="col col-xs-6 text-right">
                   <button type="button" class="btn btn-sm btn-primary btn-create">Create New</button>
                 </div> -->
               </div>
             </div>
             <div class="panel-body">
               <table class="table table-striped table-bordered table-list">
                 <thead>
                   <tr>
                       <%--  <th><class="fa fa-cog"> </th> --%>
                       <th class="hidden-xs">ID</th>
                       <th>Name</th>
                       <th>Category</th>
                       <th>Supplier</th>
                       <th>Price</th>
                       <th>Image</th>                                                                        
                   </tr> 
                 </thead>
                 <tbody>
                         
                         <c:forEach items="${plist}" var="p">
                         <tr>
                        <%--  <td>
                         
                             <a class="btn btn-default" href="./shoe_edit?id=${p.id}"><em class="fa fa-pencil"></em></a>
                             <a class="btn btn-danger" href="./shoe_delete?id=${p.id}"><em class="fa fa-trash"></em></a> 
                           </td> --%>  
                           <td class="hidden-xs">${p.productid}</td>   
                           <td>${p.productname}</td>
                          <td>${p.categoryid.categoryname}</td>   
                           <td>${p.suplierid.suppliername}</td>    
                           <td>${p.productprice}</td> <!--shoeprice  -->
                           <td><a href="p1-details?id=${p.productid}"><img src="${pageContext.request.contextPath}/resources/images/${p.p_image}"  class="img-rounded" alt="${p.p_image}" width="75px" height="50px"/> </a></td>         
                           <tr>       
                         </c:forEach>
                       </tbody>
               </table>
           
             </div>
             <div class="panel-footer">
               <div class="row">
                 <div class="col col-xs-4">Page 1 of 5
                 </div>
                 <div class="col col-xs-8">
                   <ul class="pagination hidden-xs pull-right">
                     <li><a href="#">1</a></li>
                     <li><a href="#">2</a></li>
                     <li><a href="#">3</a></li>
                     <li><a href="#">4</a></li>
                     <li><a href="#">5</a></li>
                   </ul>
                   <ul class="pagination visible-xs pull-right">
                       <li><a href="#">�</a></li>
                       <li><a href="#">�</a></li>
                   </ul>
                 </div>
               </div>
             </div>
           </div>

</div></div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>