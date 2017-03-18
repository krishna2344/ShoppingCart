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
	<div class="jumbotron">
		<form class="form-inline">
<!-- 		${message} -->	
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Description/Image</th>
					<th>Unit Price</th>
					<th></th>
				</tr>
				<c:forEach items="${products}" var="prod">
					<tr>
						<td>${prod.name}</td>
						<td>${prod.description}<br>
						<img src="img/${prod.pic}" alt="HTML5 Icon" width="128"
							height="128"></td>
						<td><fmt:setLocale value="en_US" />
							<fmt:formatNumber value="${prod.unitprice}" type="currency" /></td>
						<td><a class="btn btn-default"
							href="ProductDetail?ProductId=${prod.id}" role="button">Add
								to Cart</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>
