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
				<div class="card-header bg-primary text-white">
					<h5 class="card-title">Sign Up-Personal</h5>
				</div>

				<div class="card-body">
					<sf:form class="form" id="registerForm"
						modelAttribute="user" method="POST">
						<div class="form-group row">
							<label class="control-label col-md-4"><b>First Name:</b></label>
							<div class="col-8">
								<sf:input type="text" path="firstName" class="form-control"
									placeholder="First Name" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Last Name:</b></label>
							<div class="col-8">
								<sf:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Email:</b></label>
							<div class="col-8">
								<sf:input type="email" path="email" class="form-control"
									placeholder="Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Mobile Number:</b></label>
							<div class="col-8">
								<sf:input type="text" path="contactNumber" class="form-control"
									placeholder="XXXXXXXXXX" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Password:</b></label>
							<div class="col-8">
								<sf:input type="password" path="password" class="form-control"
									placeholder="Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Confirm Password:</b></label>
							<div class="col-8">
								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="Re-Type Password" />
								<sf:errors path="confirmPassword" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Select Role:</b></label>
							<div class="col-8">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" /> <b>User</b>
								  <sf:radiobutton
										path="role" value="SUPPLIER" /> <b>Supplier</b>
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="row justify-content-center">
								<button type="submit" class="btn btn-primary btn-md"
									name="_eventId_billing">
									Next-Billing <span class="fa fa-angle-right"></span>
								</button>

							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>