<%@include file="../../shared/flows-header.jsp"%>
<div class="container">

	<div class="row">
		<!--  To display all the goods -->
		<div class="col-12">

			<table class="table table-dark table-hover" style="width: 100%">
				<tr>
					<th>Clothes Name</th>
					<th>Clothes Count</th>
					<th>Price Per Day</th>
					<th>Deposite</th>
					<th>Issue Date</th>
					<th>Return Date</th>
					<th>Grand Total</th>
				</tr>
				<c:forEach items="${checkoutModel.cartLines}" var="cartLine">
					<tr>
						<td>${cartLine.clothes.name}</td>
						<td>${cartLine.clothesCount}</td>
						<td>&#8377; ${cartLine.pricePerDay}/-</td>
						<td>&#8377; ${cartLine.deposite}</td>
						<td>${cartLine.issueDate}/-</td>
						<td>${cartLine.returnDate}/-</td>
						<td>&#8377; ${cartLine.totalPrice}/-</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-12">
			<center>
				<div class="card card-default pull-center"
					style="width: 30rem; height: 23rem;">
					<div class="card-heading">
						<h4 class="card-title">
							<u>Payment Details</u>
						</h4>
					</div>
					<div class="card-body">
						<form role="form">
							<div class="form-group">
								<label for="cardNumber"> CARD NUMBER</label>
								<div class="input-group">
									<input type="text" class="form-control" path="validcardnumber"
										id="cardNumber" placeholder="Valid Card Number" required
										autofocus />&ensp;&ensp; <i class="fa fa-lock"
										style="font-size: 38px; color: black"></i>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="expityMonth">EXPIRY DATE</label> <br />
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<input type="text" class="form-control" id="expityMonth"
												placeholder="MM" required />
										</div>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<input type="text" class="form-control" id="expityYear"
												placeholder="YY" required />
										</div>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cvCode"> CV CODE</label> <input type="password"
											class="form-control" id="cvCode" placeholder="CV" required />
										<i class="fa fa-cc-visa" style="font-size: 38px; color: black"></i>
										<i class="fa fa-cc-mastercard"
											style="font-size: 38px; color: black"></i> <i
											class="fa fa-credit-card"
											style="font-size: 38px; color: black"></i>
									</div>
								</div>
							</div>
							<ul class="nav nav-pills nav-stacked">
								<li class="active"><a href="#"><span
										class="badge pull-right bg-danger"><h6 style="color:white">&#8377; ${checkoutModel.checkoutTotal}/-</h6></span> Final Payment : </a></li>
							</ul>
							<br/>
						</form>
						<center>
						<a href="${flowExecutionUrl}&_eventId_pay"
							class="btn btn-success btn-xs btn-block" role="button">Pay</a>
					</center>
					</div>
				</div>
			</center>

		</div>

	</div>
</div>
<%@include file="../../shared/flows-footer.jsp"%>