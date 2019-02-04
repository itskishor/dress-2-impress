<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<h2 style="color: green; text-align:center">
			<strong>Manage Transaction</strong>	
	</h2>
	<div class="row justify-content-center">

		<c:if test="${not empty message}">

			<div class="col-8">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
	</div>
	<hr />
	<h4 style="color: black;"align="center">
			<strong>Active Transactions</strong>
	</h4>
	<hr />
	<div class="row justify-content-center">

		<div class="col-xs-12"></div>
		<div class="col-xs-12">

			<div style="overflow: auto">
				<table id="employeeManageTransaction"
					class="table table-dark table-condensed table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>User Id</th>
							<th>User Name</th>
							<th>User SirName</th>
							<th>Clothes Count</th>
							<th>No.Of Days</th>
							<th>Booking Date</th>
							<th>Issue Date</th>
							<th>Return Date</th>
							<th>Total Deposit</th>
							<th>Total Rent</th>
							<th>Grand Total</th>
							<th>Delete</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>