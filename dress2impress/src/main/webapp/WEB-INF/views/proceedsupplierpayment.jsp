<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="container-fluid">

	<!-- Bread crumb -->
	<div class="row">
		
		<div class="col-sm-12">
		
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/employeemanage/purchase">Supplier Clothes</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/${clothId}/supplierclothes">View Clothes</a></li>	
				<li class="breadcrumb-item active">Payment Gateway</li>		
			</ol>
		
		
		</div>
	
	
	</div>
		
	<div class="row">	
		<!-- Display the product description -->		
		<div class="col-lg-6">
		
			<div class="thumbnail">
							
			<div class="card ">
				<div class="card-body ">
						<h4 class="card-title" style="color:Green;">
							<center><u><strong>Payment Details</strong></u></center>
						</h4>
					</div>
					<sf:form class="form-horizontal"  modelAttribute="debitcarddetail" 
					action="${contextRoot}/proceed/debitcarddetails" method="POST">
						<div class="form-group row">
							<label class="control-label col-md-4"><b>Card Number</b></label>
							<div class="col-lg-7">
								<sf:input type="number" path="cardNumber" id="cardNumber" maxlength="16" class="form-control"
									placeholder="Enter Your Card Number" />
								<sf:errors path="cardNumber" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Expiry Date</b></label>
							<div class="col-lg-3">
								<sf:input type="number" path="expiryMonth" id="expirymonth"
									class="form-control" min="1" max="12" placeholder="Month"/>
								<sf:errors path="expiryMonth" cssClass="help-block" element="em" />
							</div>
							<div class="col-lg-3">
								<sf:input type="number" path="expiryYear" id="expiryYear" class="form-control" min="2018" max="2050"
									placeholder="Year"></sf:input>
								<sf:errors path="expiryYear" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>CVV Number</b></label>
							<div class="col-3">
								<sf:input type="number" path="cvvNumber" id="cvvNumber" class="form-control"
									placeholder="CVV"></sf:input>
								<sf:errors path="cvvNumber" cssClass="help-block" element="em" />
							</div>
							<i class="fa fa-cc-visa" style="font-size: 38px; color: black"></i>&nbsp;&nbsp;
										<i class="fa fa-cc-mastercard" style="font-size: 38px; color: black"></i> &nbsp;&nbsp;
										<i class="fa fa-credit-card" style="font-size: 38px; color: black"></i>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Card Holder Name</b></label>
							<div class="col-7">
								<sf:input type="text" path="name" id="name" rows="4"
									class="form-control" placeholder="Enter Card Holder Name!"></sf:input>
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						<ul class="nav nav-pills nav-stacked">
								<li class="active"><a href="#"><span
										class="badge pull-right bg-danger"><h6 style="color:white">&#8377; ${payable} /-</h6></span> <strong>Final Payment :</strong> </a></li>
							</ul>
						
						<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-success btn-md">Proceed</button>
								<!-- Hidden Fields for Clothes -->
								<sf:hidden path="id" />

							</div>
						</div>

					</sf:form>

				</div>
			</div>
						
			</div>
		
		</div>

	
	</div>