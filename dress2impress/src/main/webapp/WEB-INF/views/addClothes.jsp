<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<hr/>
	<h2 style="text-align:center">
			<strong>Add Clothes</strong>	
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

		<div class="col-7">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Add Clothes</h5>
				</div>

				<div class="card-body">
					<sf:form class="form-horizontal" modelAttribute="supplierclothes"
						action="${contextRoot}/add/supplierclothes" method="POST"
						enctype="multipart/form-data">
						<div class="form-group row">
							<label class="control-label col-md-4"><b>Enter Clothes Name:</b></label>
							<div class="col-8">
								<sf:input type="text" path="name" id="name" class="form-control"
									placeholder="Clothes Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Enter The Brand:</b></label>
							<div class="col-8">
								<sf:input type="text" path="brand" id="brand"
									class="form-control" placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Size:</b></label>
							<div class="col-8">
								<sf:input path="size" id="size" class="form-control"
									placeholder="Enter clothes size here!"></sf:input>
								<sf:errors path="size" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Description:</b></label>
							<div class="col-8">
								<sf:textarea path="description" id="description" rows="4"
									class="form-control" placeholder="Enter your description here!"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Unit Price:</b></label>
							<div class="col-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									class="form-control" required="true" placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<%-- <div class="form-group row">
							<label class="control-label col-md-4"><b>Price Per Day:</b></label>
							<div class="col-8">
								<sf:input type="number" path="pricePerDay" id="pricePerDay"
									class="form-control" required="true" placeholder="Enter The Price/Day" />
								<sf:errors path="pricePerDay" cssClass="help-block" element="em" />
							</div>
						</div> --%>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Quantity Available:</b></label>
							<div class="col-8">
								<sf:input type="number" path="quantity" id="quantity"
									class="form-control" required="true" placeholder="Enter Quantity Available" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group row">
							<label class="control-label col-md-4"><b>Upload The File:</b></label>
							<div class="col-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group row">
							<label class="control-label col-md-4"><b>Category:</b></label>
							<div class="col-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>
						
						<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md">Submit</button>
								<!-- Hidden Fields for Clothes -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="pricePerDay" />

							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>
</div>