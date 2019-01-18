<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<hr />
	<h2 style="text-align:center">
			<strong>Manage Categories</strong>	
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
					<h5 class="card-title">Manage Categories</h5>
				</div>

				<div class="card-body">
					<sf:form class="form-horizontal" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST"
						enctype="multipart/form-data">
						<div class="form-group row">
							<label class="control-label col-md-4"><b>Enter Category Name:</b></label>
							<div class="col-8">
								<sf:input type="text" path="name" id="name" class="form-control" required="true" 
									placeholder="Category Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4"><b>Description:</b></label>
							<div class="col-8">
								<sf:textarea path="description" id="description" rows="4"
									class="form-control" required="true" placeholder="Enter your description here!"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md">Submit</button>
								<!-- Hiddin Fields for Clothes -->
								<sf:hidden path="id" />
								<sf:hidden path="active" />
								
							</div>
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>
	
	<hr />
	<h2 style="color: black;"align="center">
			<strong>Available Categories</strong>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<!-- <div class="col-xs-12"></div> -->
		<div class="col-12">

			<div style="overflow: auto">
				<table id="adminCategoryTable"
					class="table table-dark table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Description</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>
				</table>


			</div>
		</div>
	</div>
</div>