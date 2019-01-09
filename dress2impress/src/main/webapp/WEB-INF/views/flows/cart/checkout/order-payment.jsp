<%@include file="../../shared/flows-header.jsp" %>
<div class="container">

	<div class="row">
			<!--  To display all the goods -->
			<div class="col-md-4">
				
				<div class="row">
					<c:forEach items="${checkoutModel.cartLines}" var="cartLine">
					<div class="col-xs-12 text-left">
						
						<div>
							<h3>${cartLine.clothes.name}</h3>
							<hr/>
							<h4>Quantity -${cartLine.clothesCount}</h4>
							<h5>Price Per Day - &#8377; ${cartLine.pricePerDay}/-</h5>
						<h5> Issue Date- &#8377; ${cartLine.issueDate}/-</h5>	
						<h5> Return Date- &#8377; ${cartLine.returnDate}/-</h5>					
						</div>						
						<hr/>
						<div class="text-right">
							<h3>Grand Total - &#8377; ${cartLine.totalPrice}/-</h3>
						</div>						
					</div>
					</c:forEach>
				</div>
				
				
			</div>
			
			<div class="col-md-8">
	            <div class="card card-default">
	                <div class="card-heading">
	                    <h4 class="card-title">
	                        Payment Details
	                    </h4>
	                </div>
	                <div class="card-body">
	                    <form role="form">
	                    <div class="form-group">
	                        <label for="cardNumber">
	                            CARD NUMBER</label>
	                        <div class="input-group">
	                            <input type="text" class="form-control" path="validcardnumber" id="cardNumber" placeholder="Valid Card Number"
	                                required autofocus />&ensp;&ensp;
	                                <i class="fa fa-lock" style="font-size:38px;color:black"></i>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-xs-7 col-md-7">
	                            <div class="form-group">
	                                <label for="expityMonth">EXPIRY DATE</label>
	                                <br/>
	                                <div class="col-xs-6 col-lg-6 pl-ziro">
	                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required />
	                                </div>
	                                <div class="col-xs-6 col-lg-6 pl-ziro">
	                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
	                            </div>
	                        </div>
	                        <div class="col-xs-5 col-md-5 pull-right">
	                            <div class="form-group">
	                                <label for="cvCode">
	                                    CV CODE</label>
	                                <input type="password" class="form-control" id="cvCode" placeholder="CV" required />
	                                  <i class="fa fa-cc-visa" style="font-size:38px;color:black"></i>
	                                  <i class="fa fa-cc-mastercard" style="font-size:38px;color:black"></i>
	                                  <i class="fa fa-credit-card" style="font-size:38px;color:black"></i>
	                            </div>
	                        </div>
	                    </div>
	                    </form>
	                </div>
	            </div>
	            <ul class="nav nav-pills nav-stacked">
	                <li class="active"><a href="#"><span class="badge pull-right"> &#8377; ${checkoutModel.checkoutTotal}/-</span> Final Payment</a></li>
	            </ul>
	            <br/>
	            <a href="${flowExecutionUrl}&_eventId_pay" class="btn btn-success btn-sm btn-block" role="button">Pay</a>
			
			</div>

	</div>
</div>
<%@include file="../../shared/flows-footer.jsp" %>