<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Dress2Impress- ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!--Loading The Home Content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			
				<!--Loading The View Clothes Content -->
			<c:if test="${userClickViewClothes==true or userClickCategoryClothes==true}">
				<%@include file="viewclothes.jsp"%>
			</c:if>
			
				<!--Loading The Admin Sign In Content -->
			<c:if test="${userClickAdmin==true}">
				<%@include file="admin.jsp"%>
			</c:if>
			
				<!--Loading The Employee Sign In Content -->
			<c:if test="${userClickEmployee==true}">
				<%@include file="employee.jsp"%>
			</c:if>
				<!--Loading The Supplier Content -->
			<c:if test="${userClickSupplier==true}">
				<%@include file="supplier.jsp"%>
			</c:if>

			<!--Loads Only when Users Click On Sign In-->
			<c:if test="${userClickSignin==true}">
				<%@include file="signin.jsp"%>
			</c:if>

			<!--Loads Only when Users Click On Cart-->
			<c:if test="${userClickCart==true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>

		<!--Footer Comes Here-->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Self Coded Java Script -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>

