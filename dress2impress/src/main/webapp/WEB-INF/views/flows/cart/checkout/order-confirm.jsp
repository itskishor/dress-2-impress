<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
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
				<div class="invoice-title">
					<center><h2 style="color: tomato">
						Invoice
					</h2></center>
				</div>
				<hr>
				<div>
					<h5 class="pull-left" style="color: tomato">Order :<strong style="color:black">${orderDetail.id}</strong></h5>
					<h5 class="pull-right" style="color: tomato">Order Date:<strong style="color:black"> <%
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a");
         out.print( ft.format(dNow));
      %></strong></h5></br>
				</div>
            <hr>

				<div class="row">
					<div class="col-12">
						<div class="row">
						<div class="col-12">
							<div class="pull-left">
								<address>
									<h5 style="color: tomato">Billed To:</h5>
									${orderDetail.user.firstName} ${orderDetail.user.lastName}<br>
									${orderDetail.billing.addressLineOne}<br>
									${orderDetail.billing.addressLineTwo}<br>
									${orderDetail.billing.city} - ${orderDetail.billing.postalCode}<br>
									${orderDetail.billing.state} - ${orderDetail.billing.country}
								</address>
							</div>
							
							
							<div class="pull-right">
								<address>
									<h5 style="color: tomato">
										Shipped To:
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
					</div>
						<div class="row">
							<div class="col-12 text-center">
								<address>
									<h5 style="color: tomato">
										Payment Method:
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
									Order summary
								</h5>

							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-hover table-info">
										<thead>
											<tr>
												<td><strong>Item</strong></td>
												<td class="text-center"><strong>Price</strong></td>
												<td class="text-center"><strong>Quantity</strong></td>
												<td class="text-center"><strong>No. Of Days</strong></td>
												<td class="text-center"><strong>Issue Date</strong></td>
												<td class="text-center"><strong>Return Date</strong></td>
												<td class="text-center"><strong>Deposit</strong></td>
												<td class="text-right"><strong>Rent</strong></td>

											</tr>
										</thead>
										<tbody>
											<!-- foreach ($order->lineItems as $line) or some such thing here -->
											<c:forEach items="${orderDetail.orderItems}" var="orderItem">
												<tr>
													<td>${orderItem.clothes.name}</td>
													<td class="text-center">&#8377;${orderItem.pricePerDay} /-</td>
													<td class="text-center">${orderItem.clothesCount}</td>
													<td class="text-center">${orderItem.noOfDays}</td>
													<td class="text-center">${orderItem.issueDate}</td>
													<td class="text-center">${orderItem.returnDate}</td>
													<td class="text-center">&#8377;${orderItem.deposite} /-</td>
													<td class="text-right">&#8377; ${orderItem.totalRent} /-</td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
										<tr>
										<td style="color:black"><strong>Total:</strong></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="text-right"><strong style="color:blue">&#8377; ${checkoutModel.checkoutTotalDeposit}/-</strong></td>
										<td class="text-right"><strong style="color:blue">&#8377; ${checkoutModel.checkoutTotalRent}/-</strong></td>
										</tr>
											<tr>
										<td style="color:black"><strong>Delivery Charges:</strong></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="text-right"><strong style="color:blue">&#8377; 50 /-</strong></td>
										</tr>
										<tr>
										<td style="color:black"><strong>Grand Total:</strong></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="text-right"><strong style="color:blue">&#8377; ${checkoutModel.checkoutTotal} /-<i style="color:black">(* including all taxes)</i></strong></td>
										</tr>
										</tfoot>
									</table>
								</div>
							</div>
							<div>
							<h6 style="color:red">Terms & Conditions:</h6><i>If clothes has not been returned to Dress2impress by the Rental Return Due Date then dress2Impress shall be entitled to charge additional charge until the Clothes is returned to Dress2Impress. <br> 
							The User expressly authorises Dress2Impress to deduct such additional charges from the User's deposit which was taken at the time of booking of the User's order. Such additional charges shall be charged a fixed rate of Clothes for each day overdue.</i> 
							</div>
						</div>
					</div>
				</div>
				<div class="pull-right"><input type="button" value="Print" onClick="window.print()"></div>
				<div class="text-center">
					<a href="${contextRoot}/show/all/clothes"
						class="btn btn-lg btn-primary">Continue Renting</a>
				</div>
			</div>
		</div>
		<%@include file="../../shared/flows-footer.jsp"%>