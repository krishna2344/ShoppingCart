RawBlameHistory     42 lines (41 sloc)  1.47 KB
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
	<jsp:include page="./menu.jsp"/>
	<div class="container">	
	 	<h2>Products</h2>
		<form role="form" class="form-inline" method="post" action="AddToCart">
			<table class="table table-hover table-condensed"> 
			<!-- style="width: 500px; position: absolute; left: 80px; top: 150px;" -->
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Description</th>
					<th>image</th>
				</tr>
				<tr>
					<td>${product.name}</td>
					<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
							value="${product.unitprice}" type="currency" /></td>
 					<td>${product.description}</td>
 					<td><img src="img/${product.pic}" alt="HTML5 Icon" width="128" height="128"></td>
				</tr>
			</table>		
			<div class="form-group">
				<input type="text" name="prodid" value="${product.id}" hidden /> 	
<%-- 				Specify/Double check your user name: <input type="text" name="loginname" placeholder="${loginname}" required> <br><br>
 --%>				<input type="text" class="form-control" name="qty" placeholder="Quantity">
			</div>
			<button type="submit" class="btn btn-default" id="submit">Buy</button>
		</form>
	</div>
</body>
</html>
