<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<hr />
	<h2 style="text-align: center">
		<strong>Manage Employee</strong>
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
					<h5 class="card-title">Manage Employee</h5>
				</div>

				<div class="card-body">
                 <sf:form class="form-horizontal" modelAttribute="user"
						action="${contextRoot}/manage/employee" method="POST"
						enctype="multipart/form-data">
					<div class="form-group row">
						<label class="control-label col-md-3"><b>First Name:</b></label>
						<div class="col-8">
							<sf:input type="text" path="firstName" id="firstName"
								class="form-control" placeholder="Fisrt Name" />
							<sf:errors path="firstName" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group row">
							<label class="control-label col-md-3"><b>Last Name:</b></label>
							<div class="col-8">
								<sf:input type="text" path="lastName"  id="lastname"
									class="form-control" placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Email:</b></label>
							<div class="col-8">
								<sf:input type="email" path="email" id="email"
									class="form-control" placeholder="Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Date Of Birth:</b></label>
							<div class="col-8">
								<sf:input type="date" path="dob" id="dob"
									class="form-control" required="true" placeholder="Select Date" />
								<sf:errors path="dob" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Address:</b></label>
							<div class="col-8">
								<sf:input type="text" path="empaddr" id="empaddr"
									class="form-control" required="true" placeholder="Enter Address" />
								<sf:errors path="empaddr" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Date Of Joining:</b></label>
							<div class="col-8">
								<sf:input type="date" path="doj" id="doj"
									class="form-control" required="true" placeholder="Select Joining Date" />
								<sf:errors path="doj" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Salary:</b></label>
							<div class="col-8">
								<sf:input type="number" path="salary" id="salary" required="true"
									class="form-control" placeholder="Enter Salary" />
								<sf:errors path="salary" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Contact Number:</b></label>
							<div class="col-8">
								<sf:input type="text" path="contactNumber" id="contactNumber" class="form-control" required="true"
									placeholder="Enter Contact Number Here!"></sf:input>
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<%-- <div class="form-group row">
							<label class="control-label col-md-3"><b>Role:</b></label>
							<div class="col-6">
								<sf:input type="text" path="role" id="role" value="EMPLOYEE"  class="form-control" disabled="true"  required="true"></sf:input>
								<sf:errors path="role" cssClass="help-block" element="em" />
							</div>
						</div> --%>
											
						<div class="form-group row">
							<label class="control-label col-md-3"><b>Password:</b></label>
							<div class="col-8">
								<sf:input type="password" path="password" id="password" class="form-control" required="true"
									placeholder="Enter Your Pasword!"></sf:input>
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						
							<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md"> Submit</button>
								<!-- Hidden Fields for User -->
								<sf:hidden path="id" />
								<sf:hidden path="enabled"/> 
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
			<strong>Available Employee</strong>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<!-- <div class="col-xs-12"></div> -->
		<div class="col-12">

			<div style="overflow: auto">
			
			Employee Table For Admin
			
				<table id="adminEmployeeTable"
					class="table table-dark table-condensed table-sm table-hover">

					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Salary</th>
							<th>Birth   Date</th>
							<th>Joining Date</th>
							<th>Address</th>		
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>