<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!------ Include the above in your HEAD tag ---------->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> -->
<div class="container-fluid">

    <c:if test="${not empty message}">
		
		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>		
	
	</c:if>
	<c:choose>
		<c:when test="${not empty cartLines}">
	<table id="cart" class="table table-hover table-responsible-xs table-sm table-condensed">
    				<thead>
						<tr>
							<th>Clothes</th>
							<th>Price/Day</th>
			       			<th>Quantity</th>
							<th>Deposit</th>
							<th>NoOfDays</th>
							<th>Issue Date</th>
							<th>Return Date</th>
							<th class="text-center">SubTotal</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
						<tr>
							<td data-th="Clothes">
								<div class="row">
									<div class="col-6 hidden-xs"><img src="${images}/${cartLine.clothes.code}.jpeg" alt="${cartLine.clothes.name}" class="img-responsive cartImg"/></div>
									<div class="col-6">
										<h6 class="nomargin">${cartLine.clothes.name}
										<c:if test="${cartLine.available == false}">
											<strong style="color:red">(Not Available)</strong> 
										</c:if> </h6>
										<p>Size: ${cartLine.clothes.size}</p>
									</div>
								</div>
							</td>
							<td data-th="PricePerDay">&#8377;${cartLine.pricePerDay}</td>
							<td data-th="Quantity">
								<input type="number" id="count_${cartLine.id}" min="1" class="form-control text-center" value="${cartLine.clothesCount}">
							</td>
							<td data-th="Deposite">&#8377;${cartLine.deposite}</td>
							<td data-th="NoOfDays">
							<input type="number" id="countdays_${cartLine.id}" min="1" class="form-control" value="${cartLine.noOfDays}">
							</td>
							<td data-th="IssueDate"><input type="date" id="issuedate_${cartLine.id}" min="${cartLine.issueDate}" class="form-control text-center" value="${cartLine.issueDate}" ></td>
							<td data-th="ReturnDate"><input type="date" id="returndate_${cartLine.id}" class="form-control text-center" value="${cartLine.returnDate}" disabled></td>
							<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.totalPrice} /-</td>
							<td class="actions" data-th="">
								<button  type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								<a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>								
							</td>
						</tr>
						</c:forEach>
					</tbody>		
					<tfoot>					
					<tr>
						<td><a href="${contextRoot}/show/all/clothes" class="btn btn-warning"><i class="fa fa-angle-left" style="font-size:24px;color:red"></i> Continue Shopping</a></td>
						<td colspan="6" class="hidden-xs"></td>
						<td class="pull-right"><strong>GrandTotal &#8377;${userModel.cart.grandTotal}/-</strong></td>
						
						<c:choose>
							<c:when test="${availableCount != 0}">
							<h6 class="pull-right" style="color:red">Warning:Please Press The <button  type="button" name="refreshCart" class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button> Button To Refresh The Cart Before You Checkout</h6>
								<td><a href="${contextRoot}/cart/validate" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right" style="font-size:24px;color:red"></i></a></td>
							</c:when>							
							<c:otherwise>
								<td><a href="javascript:void(0)" class="btn btn-success btn-block disabled"><strike>Checkout  <i class="fa fa-angle-right" style="font-size:24px;color:red"></i></strike></a></td>
							</c:otherwise>
						</c:choose>						
					</tr>
				</tfoot>
					<%-- <tfoot>
						<tr>
							<td><a href="${contextRoot}/show/all/clothes" class="btn btn-primary"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="6" class="hidden-xs"></td>
							<td><a href="#" class="btn btn-default"><strong>Total: &#8377;${userModel.cart.grandTotal}/-</strong></a></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot> --%>
				</table>
				
		</c:when>
		
		<c:otherwise>
			
			<div class="jumbotron">
				
				<h3 class="text-center">Your Cart is Empty!</h3>
				
			
			</div>
		
		</c:otherwise>
	</c:choose>
				
</div>