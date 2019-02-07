<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<script>
	window.userRole = '${userModel.role}';
</script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container-fluid">
	   
		<a class="navbar-brand text-warning" href="${contextRoot}/home"> <img src="resources/images/favcon.png" alt="" width="42" height="42">Dress 2 Impress</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav justify-content-center">
			
				<li id="viewclothes"><a class="nav-link"
					href="${contextRoot}/show/all/clothes"><i class="fa fa-female" aria-hidden="true"></i> View Clothes</a></li>
					
				<li id="popularclothes"><a class="nav-link"
						href="${contextRoot}/show/all/popularclothes"><i class="fa fa-eye" aria-hidden="true"></i> Most Popular</a></li>
					
				<security:authorize access="hasAuthority('SUPPLIER')">
					<li id="addclothes"><a class="nav-link"
						href="${contextRoot}/add/supplierclothes"><i class="fa fa-plus-square" aria-hidden="true"></i> Add Clothes</a></li>
				</security:authorize>
				
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageemployee"><a class="nav-link"
						href="${contextRoot}/manage/employee">Manage Employees</a></li>
						<li id="managesupplier"><a class="nav-link"
						href="${contextRoot}/manage/supplier">Manage Supplier</a></li>
						<li id="managecategories"><a class="nav-link"
						href="${contextRoot}/manage/categories">Manage Categories</a></li>
						<li id="adminviewtransactions"><a class="nav-link"
						href="${contextRoot}/manage/viewtransactions">Transactions</a></li>
				</security:authorize>
				
						<security:authorize access="hasAuthority('EMPLOYEE')">
					    <li id="employeemanageclothes"><a class="nav-link"
					    href="${contextRoot}/employeemanage/clothes">Manage Clothes</a></li>
						<li id="employeemanageuser"><a class="nav-link"
						href="${contextRoot}/employeemanage/user">Manage User</a></li>
						<li id="employeemanagetransactions"><a class="nav-link"
						href="${contextRoot}/employeemanage/transactions">Manage Transactions</a></li>
						<li id="employeemanagepurchase"><a class="nav-link"
						href="${contextRoot}/employeemanage/purchase">Purchase Clothes</a></li>
				</security:authorize>
				
			</ul>
			<ul class="navbar-nav ml-auto">
				<!-- class="nav-item" -->
				<security:authorize access="isAnonymous()">
					<li id="register"><a class="nav-link"
						href="${contextRoot}/register"> Sign Up</a></li>
					<li id="signin"><a class="nav-link"
						href="${contextRoot}/login"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userCart"><a
						class="btn btn-primary btn-sm dropdown-toggle"
						href="javascript:void(0)" id="dropdownMenu1"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							<i class="fa fa-user" aria-hidden="true"></i> ${userModel.fullName} <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<security:authorize access="hasAuthority('USER')">
								<center>
									<li id="cart"><a href="${contextRoot}/cart/show"> <span
											class="fa fa-shopping-cart"
											style="font-size: 30px; color: red"></span> &#160;&#160;<span
											class="badge">${userModel.cart.cartLines}</span> -
											&#8377;&#160; ${userModel.cart.grandTotal}
									</a></li>
								</center>
								<li role="separator" class="divider"></li>
							</security:authorize>
							<li id="logout"><a href="${contextRoot}/perform-logout"><center><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</center></a></li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>