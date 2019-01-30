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
	content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta name="description" content="">
<meta name="author" content=""> 
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<link rel="shortcut icon" href="resources\images\favcon.ico" type="image/x-icon" />
<title>Dress2Impress- ${title}</title>
<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}';
</script>
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap DataTable-->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<link href="${css}/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="container">
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
			<!--Loading The View Clothes Content -->
			<c:if test="${userClickPopularClothes==true or userClickCategoryPopularClothes==true}">
				<%@include file="mostpopular.jsp"%>
			</c:if>
			
			 <!--Loading The Manage Clothes Content -->
			<c:if test="${userClickEmployeePurchaseClothes==true}">
				<%@include file="purchaseclothes.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Clothes Content -->
			<c:if test="${userClickEmployeeManageClothes==true}">
				<%@include file="manageclothes.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Clothes Content -->
			<c:if test="${userClickManageEmployee==true}">
				<%@include file="manageemployee.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Clothes Content -->
			<c:if test="${userClickEmployeeManageUser==true}">
				<%@include file="manageuser.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Clothes Content -->
			<c:if test="${userClickManageSupplier==true}">
				<%@include file="managesupplier.jsp"%> 
			</c:if>
			
			<!--Loading The Manage transactions Content -->
			<c:if test="${userClickEmployeeManageTransaction==true}">
				<%@include file="managetransactions.jsp"%> 
			</c:if>
			
			<!--Loading The View transactions Content -->
			<c:if test="${userClickAdminViewTransaction==true}">
				<%@include file="viewtransactions.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Categories Content -->
			<c:if test="${userClickManageCategories==true}">
				<%@include file="managecategory.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Categories Content -->
			<c:if test="${userClickContactUs==true}">
				<%@include file="contactus.jsp"%> 
			</c:if>
			<!--Loading The Manage Categories Content -->
			<c:if test="${userClickAboutUs==true}">
				<%@include file="aboutus.jsp"%> 
			</c:if>
			
			<!--Loading The Manage Clothes Content -->
			<c:if test="${userClickAddClothes==true}">
				<%@include file="addClothes.jsp"%> 
			</c:if>
			
			<!--Loading The View Clothes Content -->
			<c:if test="${userClickShowClothes==true}">
				<%@include file="singleClothes.jsp"%>
			</c:if>
			
			<!--Loading The View Single Supplier Clothes Content -->
			<c:if test="${userClickShowSupplierClothes==true}">
				<%@include file="singlesupplierclothes.jsp"%>
			</c:if>
			
			<!--Loading The View Single Supplier Payment Content -->
			<c:if test="${userClickProceedPayment==true}">
				<%@include file="supplierorderinvoice.jsp"%>
			</c:if>	
			
			<!--Loading The View Single Supplier Payment Content -->
			<c:if test="${userClickSupplierPayment==true}">
				<%@include file="proceedsupplierpayment.jsp"%>
			</c:if>	

			<!--Loads Only when Users Click On Cart-->
			<c:if test="${userClickShowCart==true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>

		<!--Footer Comes Here-->
		<%@include file="./shared/footer.jsp"%>


		<!-- JQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- JQuery Validator Plugin -->
		<script src="${js}/jquery.validate.js"></script>
		
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		
		<!--Data Table Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!--Data Table Bootstrap -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
       <!--Bootbox plugin -->
		<script src="${js}/bootbox.min.js"></script>
		
		<!-- Self Coded Java Script -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>
</html>

