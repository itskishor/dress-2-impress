<%@include file="../../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			
<div class="container">

	<div class="row">
		
			<div class="col-md-4">				
			<h4>Select Shipping Address</h4>
				<hr/>
				
				<div class="row">
					<c:forEach items="${addresses}" var="address">					
						<div class="cols-xs-12">
							<h5>${address.addressLineOne}</h5>
							<h5>${address.addressLineTwo}</h5>
							<h5>${address.city} - ${address.postalCode}</h5>
							<h5>${address.state} - ${address.country}</h5>
							<hr/>
							<div class="text-left">
								<a href="${flowExecutionUrl}&_eventId_addressSelection&shippingId=${address.id}" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Select</a>
							</div>												
						</div>
					</c:forEach>			
				</div>
			</div>		
			
			<div class="col-md-8">	
				<div class="card card-primary">
				
					<div class="card-heading">
						<h4 align="center">Sign Up - Address</h4>
					</div>
					
					<div class="card-body">
										
						<sf:form
							method="POST"
							modelAttribute="shipping"
							class="form-horizontal"
							id="billingForm"
						>						
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
								<div class="col-8">
									<sf:input type="text" path="addressLineOne" class="form-control"
										placeholder="Enter Address Line One" />
									<sf:errors path="addressLineOne" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
								<div class="col-8">
									<sf:input type="text" path="addressLineTwo" class="form-control"
										placeholder="Enter Address Line Two" />
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-4">
									<sf:input type="text" path="city" class="form-control"
										placeholder="Enter City Name" />
									<sf:errors path="city" cssClass="help-block" element="em"/> 
								</div>
							</div>					
							<div class="form-group">
								<label class="control-label col-md-4" for="postalCode">Postal Code</label>
								<div class="col-4">
									<sf:input type="text" path="postalCode" class="form-control"
										placeholder="XXXXXX" />
									<sf:errors path="postalCode" cssClass="help-block" element="em"/> 
								</div>
							</div>													
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-4">
									<sf:input type="text" path="state" class="form-control"
										placeholder="Enter State Name" />
									<sf:errors path="state" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-6">
									<sf:input type="text" path="country" class="form-control"
										placeholder="Enter Country Name" />
									<sf:errors path="country" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<div class="form-group">
								<div class="col-8 text-center" >
									<button type="submit" name="_eventId_saveAddress" class="btn btn-primary">
										<i class="fa fa-plus" aria-hidden="true"></i> Add Address
									</button>	
									<br>																 
								</div>
							</div>
						</sf:form>					
					</div>
				</div>
	</div>	
</div>	
<%@include file="../../shared/flows-footer.jsp"%>