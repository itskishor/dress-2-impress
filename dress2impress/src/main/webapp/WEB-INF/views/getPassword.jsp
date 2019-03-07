<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.amplesoftech.dress2impressbackend.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="col-md-8 col-sm-8 col-lg-8">
		<div class="card ">

			<div class="card-body">

				<div class="form-group row">
					<label class="control-label col-md-4"><b>Enter Mobile
							Number:</b></label>
					<div class="col-8">
						<input type="text" id="contactNumber" name="contactNumber"
							class="form-control" placeholder="Contact Number" />

					</div>
					<input type="button" onClick="myFunction()" value="GetPassword"/>
            <span id="pwd"></span>
				</div>

				<div class="form-group">

					<div class="row justify-content-center">

						<a href="<%=request.getContextPath()%>/login"
							class="btn btn-primary">Back to login</a> ${pwd}
					</div>

				</div>

				</>

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
			var val=document.getElementById("contactNumber").value;
			var clist = [
	    <%=sb.toString()%>
		];
			var plist=[
				<%=sb1.toString()%>
				];
			for (i = 0; i < clist.length; i++) {
				if (val == clist[i]) {
					document.getElementById("pwd").innerHTML=plist[i];
					//alert(plist[i]);
				}
			}
		}
	</script>

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




</body>
</html>