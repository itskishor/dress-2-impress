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
					<h5 class="card-title">Sign Up-Billing</h5>
				</div>

				<div class="card-body">
					<sf:form class="form-horizontal" id="billingForm" method="POST"
						modelAttribute="billing">
							<div class="form-group row">
								<label class="control-label col-md-4" for="addressLineOne">Address
									Line One</label>
								<div class="col-8">
									<sf:input type="text" path="addressLineOne"
										class="form-control"/>
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-4" for="addressLineTwo">Address
									Line Two</label>
								<div class="col-8">
									<sf:input type="text" path="addressLineTwo"
										class="form-control" />
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-8">
									<sf:input type="text" pattern="[A-Za-z]{1,32}" title="Only Characters Allowed Here!!" path="city" class="form-control"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="control-label col-md-4" for="postalCode">Postal
									Code</label>
								<div class="col-8">
									<sf:input type="text" path="postalCode" class="form-control"/>
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-8">
									<sf:input type="text" pattern="[A-Za-z]{1,32}" title="Only Characters Allowed Here!!" path="state" class="form-control"
										 />
								</div>
							</div>

							<div class="form-group row">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-8">
									<sf:input type="text" pattern="[A-Za-z]{1,32}" title="Only Characters Allowed Here!!" path="country" class="form-control"/>
								</div>
							</div>

							<div class="form-group row">
								<div class="row justify-content-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- Submit Button to move to the personal -->
									<button type="submit"  class="btn btn-primary btn-md"
										name="_eventId_personal">
										<span class="fa fa-angle-left"></span> Previous-Personal
									</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- Submit Button to move to the confirm -->
									<button type="submit"  class="btn btn-primary btn-md"
										name="_eventId_confirm">
										Next-Confirm <span class="fa fa-angle-right"></span>
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