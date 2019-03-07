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
<link rel="shortcut icon" href="resources\images\favcon.ico"
	type="image/x-icon" />
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


<!--booststrap-->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all">
<!--//booststrap end-->
<!-- font-awesome icons -->
<link href="css/fontawesome-all.min.css" rel="stylesheet"
	type="text/css" media="all">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- //font-awesome icons -->
<!--stylesheets-->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all">
<!--//stylesheets-->
<!-- Nav-CSS -->
<link href="css/nav.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/modernizr.custom.js"></script>
<!-- //Nav-CSS -->
<link href="//fonts.googleapis.com/css?family=Cinzel+Decorative:400,700"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Julius+Sans+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Arimo"
	rel="stylesheet">

<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>

</head>


<body>

	<!--//headder-->
	<!-- banner -->
	<div class="inner_page-banner"></div>
	<!--//banner -->
	<!--about-->
	<section class="about-inner py-lg-4 py-md-3 py-sm-3 py-3">
		<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
			<h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">
			   <h2><strong><u><b><center>About Us</center></b></u></strong></h2>
			</h3>
			<div class="row">
			    <div class="col-lg-3 about-txt-left">
			    <img src="${images}/bg5.jpg" alt="" width="150px" hieght="250%">
				</div>
				<div class="col-lg-3 about-txt-left">
					<img src="${images}/bg3.jpeg" alt="" width="110px" hieght="210%">
				</div>
				<div class="col-lg-6 about-txt-right">
					<div class="jst-wthree-text">
						<h2>
							<br>
						</h2>
					</div>
					<div class="info-sub-w3">
					<strong><p>About Dress-2-Impress is India's Ultimate Online Dress Rental Site
							 vision is to create India's most reliable and
							frictionless commerce system that creates life-changing
							experiences for buyers and sellers. In February 2010, Kishor More
							along with Suhel Sande, started Dress2Impress.com - India's largest
							 Online Dress Rental marketplace, with the widest assortment of 35
							million plus products across 800 plus diverse categories from
							over 125,000 regional, national, and international brands and
							retailers. With millions of users and more than 300,000 sellers,
							Dress2Impress is the online shopping site for Internet users across
							the country, delivering to 6000+ cities and towns in India. In
							its journey till now.</p></strong>
						<p class="pt-2">
						
					</div>
					</div>
				</div>
				
				<div class="row">
				<div class="col-lg-3 about-txt-left">
					<img src="${images}/bg4.jpg" alt="" width="250px" hieght="350px">
				</div>
				<div class="col-lg-3 about-txt-left">
					<img src="${images}/bg6.jpeg" alt="" width="180px" hieght="280px">
				</div>
					<div class="col-lg-6 about-txt-right">
					<div class="jst-wthree-text">
						<h2>
							<br>
						</h2>
					</div>
					<div class="info-sub-w3">
					<strong><p>Dress2Impress has partnered with several global
							marquee investors and individuals such as Nike, Adidas,
							Reebok, Foxconn, Alibaba, eBay Inc., Premji Invest, Intel
							Capital, Bessemer Venture Partners, Mr. Ratan Tata, among others.
							Online Dress Rental is A Boon The trend of Online Dress Rental  is becoming
							a household name and so is Dress2Impress. Dress2Impress is the preferred
							choice of hundreds of thousands of online shoppers given its
							mammoth assortment of 15 million+ products, quick delivery even
							to the remotest corners of the country, and daily deals,
							discounts & offers to make products available at slashed down
							prices to our valuable customers.Shop on the Go – Install
							Dress2Impress App Today! You can shop for your favourite products at
							Dress2Impress even on the go using Dress2Impress App. Available for both
							Android and Apple users, the app can be downloaded from Google
							Play Store and Apple App Store respectively. The app is quick,
							user-friendly, and enables shoppers buy products with a breeze.
							What's more, get timely notifications on your phone or tablet so
							that you don't miss amazing deals and offers. Download the app
							right now and experience how fun it is to shop on your mobile!</p></strong>
						<p class="pt-2">
						
					</div>
					</div>
			</div>
				</div>
	</section>
	<!--js working-->
	<script src='js/jquery-2.2.3.min.js'></script>
	<!-- For the demo ad only -->
	<!--nav menu-->
	<script src="js/classie.js"></script>
	<script src="js/demonav.js"></script>
	<!-- //nav menu-->
	<!-- //nav menu-->
	<!--bootstrap working-->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>