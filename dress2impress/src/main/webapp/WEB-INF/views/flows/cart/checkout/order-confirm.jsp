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
<title>Dress2Impress- ${title}</title>
<link rel="shortcut icon" type="image/png"
	href="/assets/images/favcon.png" />
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

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Dress 2
						Impress</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->

		<div class="content">
			<div class="container">
				<div class="alert alert-success">
					<h3 class="text-center">Your Order is Confirmed!!</h3>
				</div>
				<div class="invoice-title" >
					<h2 style="color: tomato" align="center">
							<u>	Invoice</u>
						</h2>
				</div>
				<hr>
				<div class="text-right">
					<h5 style="color: tomato">Order ${orderDetail.id}</h5>

					<address>
						<strong>Order Date:</strong><br> ${orderDetail.issueDate}<br>

					</address>
				</div>

				<div class="row">
					<div class="col-12">
						<hr>
						<div class="row">
							<div class="col-6 text-left">
								<address>
									<h5 style="color: tomato">
										<strong>Billed To:</strong>
									</h5>
									${orderDetail.user.firstName} ${orderDetail.user.lastName}<br>
									${orderDetail.billing.addressLineOne}<br>
									${orderDetail.billing.addressLineTwo}<br>
									${orderDetail.billing.city} - ${orderDetail.billing.postalCode}<br>
									${orderDetail.billing.state} - ${orderDetail.billing.country}
								</address>
							</div>
							<div class="col-6 text-right">
								<address>
									<h5 style="color: tomato">
										<strong>Shipped To:</strong>
									</h5>
									${orderDetail.user.firstName} ${orderDetail.user.lastName}<br>
									${orderDetail.shipping.addressLineOne}<br>
									${orderDetail.shipping.addressLineTwo}<br>
									${orderDetail.shipping.city} -
									${orderDetail.shipping.postalCode}<br>
									${orderDetail.shipping.state} - ${orderDetail.shipping.country}
								</address>
							</div>
						</div>
						<div class="row">
							<div class="col-6 text-left">
								<address>
									<h5 style="color: tomato">
										<strong>Payment Method:</strong>
									</h5>
									<br> Card Payment <br> ${orderDetail.user.email}
								</address>
							</div>

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="card card-default">
							<div class="card-heading">

								<h5 style="color: tomato" align="center">
									<strong>Order summary</strong>
								</h5>

							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-condensed">
										<thead>
											<tr>
												<td><strong>Item</strong></td>
												<td class="text-center"><strong>Price</strong></td>
												<td class="text-center"><strong>Quantity</strong></td>
												<td class="text-center"><strong>Issue Date</strong></td>
											<td class="text-center"><strong>Return Date</strong></td>
												<td class="text-right"><strong>Totals</strong></td>
												
											</tr>
										</thead>
										<tbody>
											<!-- foreach ($order->lineItems as $line) or some such thing here -->
											<c:forEach items="${orderDetail.orderItems}" var="orderItem">
												<tr>
													<td>${orderItem.clothes.name}</td>
													<td class="text-center">&#8377;
														${orderItem.pricePerDay}</td>
													<td class="text-center">${orderItem.clothesCount}</td>
									 <td class="text-center">${orderDetail.issueDate}</td>
									 <td class="text-center">${orderDetail.returnDate}</td>
										
													
													<td class="text-right">&#8377; ${orderItem.totalPrice}</td>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="text-center">
					<a href="${contextRoot}/show/all/clothes"
						class="btn btn-lg btn-warning">Continue Shopping</a>
				</div>
				</div>
				</div>
			<%@include file="../../shared/flows-footer.jsp"%>