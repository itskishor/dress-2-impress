<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<hr />
	<h2 style="text-align:center">
			<strong>Manage Clothes</strong>	
	</h2>
	<hr />
	<div class="row justify-content-center">

		<c:if test="${not empty message}">

			<div class="col-6">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-6">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Manage Clothes</h5>
				</div>

				<div class="card-body">
					<sf:form class="form-horizontal" modelAttribute="clothes"
						action="${contextRoot}/manage/clothes" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4">Enter Clothes Name</label>
							<div class="col-8">
								<sf:input type="text" path="name" id="name" class="form-control"
									placeholder="Clothes Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Enter The Brand</label>
							<div class="col-8">
								<sf:input type="text" path="brand" id="brand"
									class="form-control" placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Size</label>
							<div class="col-8">
								<sf:input path="size" id="size" class="form-control"
									placeholder="Enter clothes size here!"></sf:input>
								<sf:errors path="size" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-8">
								<sf:textarea path="description" id="description" rows="4"
									class="form-control" placeholder="Enter your description here!"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									class="form-control" placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Price Per Day</label>
							<div class="col-8">
								<sf:input type="number" path="pricePerDay" id="pricePerDay"
									class="form-control" placeholder="Enter The Price/Day" />
								<sf:errors path="pricePerDay" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity Available</label>
							<div class="col-8">
								<sf:input type="number" path="quantity" id="quantity"
									class="form-control" placeholder="Enter Quantity Available" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Upload a file</label>
							<div class="col-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<c:if test="${clothes.id == 0}">
									<br />
									<div class="text-right">
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-danger btn-xs">Add
											Category</button>
									</div>
								</c:if>
							</div>
						</div>

						<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md">Submit</button>
								<!-- Hiddin Fields for Clothes -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="rented" />
								<sf:hidden path="views" />

							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
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




	<hr />
	<h2 style="color: black;"align="center">
			<strong>Available Clothes</strong>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<div class="col-xs-12"></div>
		<div class="col-xs-12">

			<div style="overflow: auto">
				<table id="adminClothesTable"
					class="table table-dark table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Size</th>
							<th>Unit Price</th>
							<th>Price Per Day</th>
							<th>Qty. Avail</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Size</th>
							<th>Unit Price</th>
							<th>Price Per Day</th>
							<th>Qty. Avail</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>


				</table>


			</div>
		</div>
	</div>
</div>