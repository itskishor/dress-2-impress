<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<hr />
	<h2 style="text-align: center">
		<strong>Manage User</strong>
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

		<div class="col-6">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Manage User</h5>
				</div>

				<div class="card-body">
                 <sf:form class="form-horizontal" modelAttribute="user"
						action="${contextRoot}/manage/user" method="POST"
						enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-md-4">First Name</label>
						<div class="col-8">
							<sf:input type="text" path="firstName" id="firstName"
								class="form-control" placeholder="Fisrt Name" />
							<sf:errors path="firstName" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-8">
								<sf:input type="text" path="lastName"  id="lastname"
									class="form-control" placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-8">
								<sf:input type="email" path="email" id="email"
									class="form-control" placeholder="Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-6">
								<sf:input type="Number" path="contactNumber" id="contactNumber" class="form-control" required="true"
									placeholder="Enter Contact Number Here!"></sf:input>
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>
						
							<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md"> Submit</button>
								<!-- Hiddin Fields for User -->
								<sf:hidden path="id" />
								<sf:hidden path="enabled"/>
								<sf:hidden path="password"/>
								<sf:hidden path="role"/>	
							</div>
						</div>
                 </sf:form>
				</div>
			</div>
		</div>
	</div>




	<hr />
	<h2 style="color: black;"align="center">
			<strong>Available User</strong>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<div class="col-xs-12"></div>
		<div class="col-xs-12">

			<div style="overflow: auto">
			
			<!-- Employee Table For Admin -->
			
				<table id="adminUserTable"
					class="table table-dark table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>