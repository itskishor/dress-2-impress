<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<h2 style="color: black;"align="center">
			<strong>All Transactions</strong>
	</h2>
	<hr />
	<div class="row justify-content-center">

		<div class="col-xs-12"></div>
		<div class="col-xs-12">

			<div style="overflow: auto">
				<table id="adminViewTransaction"
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
							<th>Status</th>
						</tr>
					</thead>
				</table>
				
			</div>
		</div>
	</div>
	
		<div>
		<span class="badge pull-right bg-success"><h6 style="color:Red">Total Profit :</h6> &#8377; ${TotalProfit} /-</span> <br>
</div>