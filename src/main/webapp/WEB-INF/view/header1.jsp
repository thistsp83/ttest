<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video Kart</title>
</head>
<body>
<center>
<img src="./resources/images/banner.jpg"/>
</center>

<!-- starting header navigation bar -->
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Video Cart</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
      
    <!--  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index">Home</a></li>
           <li><a href="adding">Add</a></li>
        <!-- <li><a href="supplying">supplier</a></li> -->
			<!-- 	<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories<b class="caret"></b></a>
						
						<ul class="dropdown-menu">
							<li class="col-sm-1">
								<ul>
									<li class="dropdown-header">Category</li>
									<li><a href="#">Educational</a></li>
								    <li><a href="#">Entertainment</a></li>
									<li><a href="#">Movies</a></li>
									<li><a href="#">Devotional</a></li>
									<li><a href="#">Others</a></li>
									
								</ul>
				</li>
				 </ul>
				 </li>
			<!-- <ul class="nav navbar-nav navbar-right"> -->
			<!-- 	<li>
					<form class="navbar-form navbar-left">
                       <div class="form-group">
                       <input type="text" class="form-control" placeholder="Search">
                       </div>
                       <button type="submit" class="btn btn-default"><i class ="glyphicon glyphicon-search"></i></button>
                    </form>
               </li>
               <li>
                <a href="login"><span class="glyphicon glyphicon-log-in"></span>Sign In</a>
                </li>
              <li>
                <a href="registerpage"><span class="glyphicon glyphicon-log-in"></span>Register</a>
                </li>
              
              </ul>
             <!-- </ul> -->
             <nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
							
			<a class="navbar-brand" href="./">				
				<img src='<c:url value="resources/images/logo.png" />' width="50px" height="25px" class="img-responsive"/>
			</a>
		</div>		
		
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Products <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>Category 1</li>
						<li>Category 1</li>
						<li>Category 1</li>
					</ul>
				</li>
					<li><a href="<c:url value="admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false">Add</a></li>
			</ul>
		
			
				<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                 </c:if>
                 </ul>
			  <ul class="nav navbar-nav navbar-right">
			  <c:if test="${pageContext.request.userPrincipal.name == null }">
					<li>
					<a href=' <c:url value="/signin" />'>Login</a>
					</li>
				<li><a href="/signup">Signup</a></li>
				
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name  != null}">
                               <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
	              				<li><a href='<c:url value="/logout" />'>Signout</a></li>
                 </c:if>
				
				</ul>
		</div>		
	</div>
</nav>
      </div>-->
       </div>
       </nav>
	<br>-->

</body>
</html>