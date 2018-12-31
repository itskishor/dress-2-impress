<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
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

		<div class="col-6">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Manage Employee</h5>
				</div>

				<div class="card-body">
                 <sf:form class="form-horizontal" modelAttribute="employee"
						action="${contextRoot}/manage/employee" method="POST"
						enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-md-4">Enter First Name</label>
						<div class="col-8">
							<sf:input type="text" path="firstName" id="firstName"
								class="form-control" placeholder="Fisrt Name" />
							<sf:errors path="firstName" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group">
							<label class="control-label col-md-4">Enter The Last Name</label>
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
							<label class="control-label col-md-4">Select Date Of Birth</label>
							<div class="col-6">
								<sf:input type="date" path="dob" id="dob" class="form-control" required="true"
									placeholder="Enter Date Of Birth Here!"></sf:input>
								<sf:errors path="dob" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Address</label>
							<div class="col-6">
								<sf:textarea path="empaddr" id="empaddr" rows="4"
									class="form-control" placeholder="Enter Address here!"></sf:textarea>
								<sf:errors path="empaddr" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Select Date Of Joining</label>
							<div class="col-6">
								<sf:input type="date" path="doj"  id="doj" class="form-control" required="true"
									placeholder="Enter Date Of Joining Here!"></sf:input>
								<sf:errors path="doj"  cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Salary</label>
							<div class="col-4">
								<sf:input type="number" path="salary"  id="salary"
									class="form-control" placeholder="Enter The Salary" />
								<sf:errors path="salary" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-4">
								<sf:input type="text" path="contactNumber"  id="contactNumber"
									class="form-control" placeholder="XXXXXXXXXX" />
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-4">
								<sf:input type="password" path="password"  id="password"
									class="form-control"  placeholder="Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-4">
								<sf:input type="password" path="confirmPassword"  id="confirmPassword"
									class="form-control"  placeholder="Re-Type Password" />
								<sf:errors path="confirmPassword"  cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Department</label>
							<div class="col-4">
								<sf:select class="form-control" path="department" id="categoryId" items="${categories}" 
								itemLabel="name" itemValue="id"/>
								
								
							</div>
						</div>
						
							<div class="form-group">

							<div class="row justify-content-center">

								<button type="submit" class="btn btn-primary btn-md"> Submit</button>
								<!-- Hiddin Fields for Employee -->
								<sf:hidden path="id" />
								<sf:hidden path="enabled"/>
								
							</div>
						</div>
                 </sf:form>
				</div>
			</div>
		</div>
	</div>




	<hr />
	<h2 style="color: black;">
		<center>
			<strong>Active Employees</strong>
		</center>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<div class="col-xs-12"></div>
		<div class="col-xs-12">

			<div style="overflow: auto">
			
			<!-- Employee Table For Admin -->
			
				<table id="adminEmoloyeeTable"
					class="table table-dark table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>DOB</th>
							<th>Address</th>
							<th>DOJ</th>
							<th>Salary</th>
							<th>Contact</th>
							<th>Department</th>
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
							<th>DOB</th>
							<th>Address</th>
							<th>DOJ</th>
							<th>Salary</th>
							<th>Contact</th>
							<th>Department</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>