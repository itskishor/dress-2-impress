<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<hr/>
	<h2 style="text-align:center">
			<strong>Contact Us</strong>	
	</h2>
	<hr />
	<div class="row justify-content-center">

		<c:if test="${not empty message}">

			<div class="col-10">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-10">
			<div class="card ">
				<div class="card-body">
					<sf:form class="form-horizontal"  modelAttribute="contactus"
						action="${contextRoot}/contactus" method="POST"
						enctype="multipart/form-data">
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Enter Your Name:</b></label>
							<div class="col-4">
								<sf:input type="text" path="name" id="name" class="form-control"
									placeholder="your Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-3"><b>Email:</b></label>
							<div class="col-5">
								<sf:input type="email" path="email" id="email"
									class="form-control" placeholder="Your Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-3"><b>Contact Number:</b></label>
							<div class="col-3">
								<sf:input type="text" path="contactNumber" id="contactNumber" class="form-control"
									placeholder="Enter Yor Contact here!"></sf:input>
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-3"><b>Query:</b></label>
							<div class="col-6">
								<sf:textarea path="query" id="query" rows="4"
									class="form-control" placeholder="Enter your Query here!"></sf:textarea>
								<sf:errors path="query" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md">Submit</button>
								<!-- Hiddin Fields for Clothes -->
								<sf:hidden path="id" />

							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>