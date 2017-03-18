<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Online Shopping Site</title>
	<jsp:include page="./header.jsp"/>
</head>
<body>
	<jsp:include page="./carousel.jsp"/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Online Shopping Store</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
		<li><a href="login.jsp">Login</a></li>
		<li><a href="register.jsp">Register</a></li>
		<li><a href="ViewProducts">View Merchandises</a></li>
      </ul>
    </div>
  </div>
</nav>
	<div class="jumbotron">
		<form class="form-inline">
			<h2> You may view the merchandises without logging in. <br>
			Please login/register in order to purchase or view details of products. </h2>	 
			${productView}
		</form>
	</div> 
</body>
</html>