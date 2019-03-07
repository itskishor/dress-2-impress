<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import="java.util.List"%>
<%@page import="com.amplesoftech.dress2impressbackend.dto.User"%>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body> --%>
	<div class="container-fluid">
		<hr />
		<h2 style="text-align: center">
			<strong>Manage Supplier</strong>
		</h2>
		<hr />
		<div class="row justify-content-center">

			<c:if test="${not empty message}">

				<div class="col-8">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						${message}
					</div>
				</div>
			</c:if>

			<div class="col-md-8 col-sm-8 col-lg-8">
				<div class="card ">
					<div class="card-header bg-dark text-white">
						<h5 class="card-title">Manage Supplier</h5>
					</div>

					<div class="card-body">
						<sf:form class="form-horizontal" modelAttribute="user"
							action="${contextRoot}/manage/supplier" method="POST"
							enctype="multipart/form-data">
							<div class="form-group row">
								<label class="control-label col-md-3"><b>First Name:</b></label>
								<div class="col-8">
									<sf:input type="text" path="firstName" id="firstName"
										class="form-control" placeholder="Fisrt Name" />
									<sf:errors path="firstName" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-3"><b>Last Name:</b></label>
								<div class="col-8">
									<sf:input type="text" path="lastName" id="lastname"
										class="form-control" placeholder="Last Name" />
									<sf:errors path="lastName" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-3"><b>Email:</b></label>
								<div class="col-8">
									<sf:input type="email" path="email" id="email"
										class="form-control" placeholder="Email" />
									<sf:errors path="email" cssClass="help-block" element="em" />
									<!-- <span id="errspan" style="color: red;"></span> -->
								</div>
							</div>
							<div class="form-group row">
								<label class="control-label col-md-3"><b>Contact
										Number:</b></label>
								<div class="col-8">
									<sf:input type="text" path="contactNumber" id="contactNumber"
										class="form-control" required="true"
										placeholder="Enter Contact Number Here!"></sf:input>
									<sf:errors path="contactNumber" cssClass="help-block"
										element="em" />
									<!-- <span id="errspan1" style="color: red;"></span> -->
								</div>
							</div>

							<div class="form-group">

								<div class="row justify-content-center">

									<button type="submit" class="btn btn-primary btn-md">Submit</button>
									<!-- Hiddin Fields for User -->
									<sf:hidden path="id" />
									<sf:hidden path="enabled" />
									<sf:hidden path="password" />
									<sf:hidden path="role" />
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>

		<hr />
		<h2 style="color: black;" align="center">
			<strong>Available Suppliers</strong>
		</h2>
		<hr />
		<div class="row justify-content-center">

			<!-- <div class="col-xs-12"></div> -->
			<div class="col-12">

				<div style="overflow: auto">

					<!-- Supplier Table For Admin -->

					<table id="adminSupplierTable"
						class="table table-dark table-condensed table-xl table-hover">

						<thead>
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Contact</th>
								<th>Activate</th>
								<th>Edit</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

<%-- 
	<%
		List<User> list = (List<User>) request.getAttribute("list1");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append('"').append(list.get(i).getEmail()).append('"');
		}
	%>
	<script type="text/javascript">
		function myFunction(val) {
			var elist = [
	<%=sb.toString()%>
		];
			for (i = 0; i < elist.length; i++) {
				if (val == elist[i]) {
					document.getElementById("errspan").innerHTML = "Email Already Exist!!";
					document.getElementById("email").value = "";

				}
			}
		}
	</script>


	<%
		List<User> list1 = (List<User>) request.getAttribute("list1");
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append('"').append(list.get(i).getContactNumber()).append('"');
		}
	%>
	<script type="text/javascript">
		function myFunction1(val) {
			var elist = [
	<%=sb.toString()%>
		];
			for (i = 0; i < elist.length; i++) {
				if (val == elist[i]) {
					document.getElementById("errspan1").innerHTML = "Contact Number Already Exist!!";
					document.getElementById("contactNumber").value = "";

				}
			}
		}
	</script>

</body>
</html> --%>