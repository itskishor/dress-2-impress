<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.amplesoftech.dress2impressbackend.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<br>
		<br>
		<br>
		<br>
	</div>
	   <center>
		<div class="container-fluid span8">
			<div class="row">
			<center>
				<div>
					<b>&nbsp;&nbsp;&nbsp;&nbsp;Enter Your Registered Mobile
						Number:</b><br>
				</div>
				</center>
				<center>
				<br><div class="input-group">
				<div class="col-lg-6 col-lg-offset-6" style="background-color: lavenderblush;">
					<input type="text" id="contactNumber" name="contactNumber"
						class="form-control" placeholder="Contact Number" />
				</div>
				</div>
				</center>

			</div>
			</div>
	</center>
	<br>
	<center>
		<button type="button" class="btn btn-success" onClick="myFunction()"
			value="GetPassword">Get Password</button>
	</center>

	<div></div>

	<Center>
		<h4>Your Password is:<span style="color: blue; font-weight: bold" id="pwd"></span></h4>
	</Center>
	</div>

	<br>
	<center>
		<div class="form-group">

			<div class="row justify-content-center">

				<a href="<%=request.getContextPath()%>/login"><button
						type="button" class="btn btn-primary">Back to login</button></a>
				${pwd}
			</div>

		</div>
	</center>



	</div>
	</div>

	</div>

	<%
		List<User> list = (List<User>) request.getAttribute("list");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append('"').append(list.get(i).getContactNumber()).append('"');

		}

		List<User> list1 = (List<User>) request.getAttribute("list");
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (sb1.length() > 0) {
				sb1.append(",");
			}
			sb1.append('"').append(list.get(i).getPassword()).append('"');
		}
	%>
	<script type="text/javascript">
		function myFunction() {
			var val = document.getElementById("contactNumber").value;
			var clist = [
	<%=sb.toString()%>
		];
			var plist = [
	<%=sb1.toString()%>
		];
			for (i = 0; i < clist.length; i++) {
				if (val == clist[i]) {
					document.getElementById("pwd").innerHTML = plist[i];
					//alert(plist[i]);
				}
			}
		}
	</script>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
		<footer style="background-color: grey">

			<!-- Copyright -->
			<div class="footer-copyright text-center py-3">
				© 2018 Copyright: <a
					href="https://mdbootstrap.com/education/bootstrap/">
					Dress2Impress.com</a>
			</div>
			<!-- Copyright -->

		</footer>
	</center>
</body>
</html>