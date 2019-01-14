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

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%><br />
		<br />
		<!-- Page Content -->

		<div class="content">

			<div class="container-fluid">

				<c:if test="${not empty message}">
					<div class="row justify-content-center">
						<div class="col-md-8">
							<div class="alert alert-danger alert-dismissible">${message}</div>
						</div>
					</div>
				</c:if>

				<c:if test="${not empty logout}">
					<div class="row justify-content-center">
						<div class="col-md-8">
							<div class="alert alert-success">${logout}</div>
						</div>
					</div>
				</c:if>

				<div class="row justify-content-center">

					<div class="col-md-6">

						<div class="card card-primary">

							<div class="card-heading bg-primary" >
								<h4 align="center">
									<b>Login</b>
								</h4>
							</div>

							<div class="card-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">
             
									<div class="form-group row">
										<label for="username" class="col-md-4 control-label"><b>Email:</b>
										</label>
										<div class="col-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="col-md-4 control-label"><b>Password:</b>
										</label>
										<div class="col-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-12 text-center">
											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</div>
									</div>
								</form>
								
								</div>

							</div>
							<div class="card-footer">
							    <div class="text-left">
									New User - <a href="${contextRoot}/register">Register Here</a>
							
							</div>

						</div>

					</div>

				</div>

			</div>


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