<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row justify-content-center">

		<c:if test="${not empty message}">

			<div class="col-8">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-8">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Sign Up-Personal</h5>
				</div>

				<div class="card-body">
					<sf:form class="form-horizontal" id="registerForm"
						modelAttribute="user" method="POST">

						<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-8">
								<sf:input type="text" path="firstName" class="form-control"
									placeholder="First Name" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-8">
								<sf:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-8">
								<sf:input type="text" path="email" class="form-control"
									placeholder="Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-8">
								<sf:input type="text" path="contactNumber" class="form-control"
									placeholder="XXXXXXXXXX" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-8">
								<sf:input type="password" path="password" class="form-control"
									placeholder="Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-8">
								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="Re-Type Password" />
								<sf:errors path="confirmPassword" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-8">
								<label class="radio-inline"> 
								<sf:radiobutton path="role" value="USER" checked="checked" /> User
								<%-- </label> <label class="radio-inline"> 
								<sf:radiobutton path="role" value="ADMIN" /> Admin
								</label> <label class="radio-inline"> 
								<sf:radiobutton path="role" value="EMPLOYEE" /> Employee
								</label> <label class="radio-inline">  --%>
								<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="row justify-content-center">
								<button type="submit" class="btn btn-primary btn-md" name="_eventId_billing">Next-Billing <span class="fa fa-angle-right"></span></button>
								
							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>

<%-- 	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<!-- 	        <h4 class="modal-title">New Category</h4>
 -->
				</div>
				<div class="modal-body">

					<sf:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST">

						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8 validate">
								<sf:textarea cols="" rows="5" path="description"
									id="category_description" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

</div>
 --%>
<%@include file="../shared/flows-footer.jsp"%>