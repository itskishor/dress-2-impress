<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="container-fluid">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-sm-12">
		
			
			<ol class="breadcrumb">
			
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/clothes">Clothes</a></li>
				<li class="breadcrumb-item active">${clothes.name}</li>
			
			</ol>
		
		
		</div>
	
	
	</div>
	
	
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-lg-5">
		
			<div class="thumbnail">
							
				<img src="${images}/${clothes.code}.jpeg" class="img img-responsive" width=65% height=80%/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-lg-5">
		
			<h3>${clothes.name}</h3>
			<hr/>
			
			<p>${clothes.description}</p>
			<hr/>
			
			<h5>Original Price: <strong> &#8377;${clothes.unitPrice} /-</strong></h5>
			<hr/>
			<h5>Price Per Day: <strong> &#8377;${clothes.pricePerDay} /-</strong></h5>
			<hr/>
					
			<c:choose>
				
				<c:when test="${clothes.quantity < 1}">
				
					<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
					<h6><span style="color:blue">Coming Soon!</span></h6>
					
				</c:when>
				<c:otherwise>				
					
					<h6>Qty. Available: ${clothes.quantity}</h6>
						
				</c:otherwise>
			
			</c:choose>
			<security:authorize access="isAnonymous() or hasAuthority('USER')">	
			<c:choose>
				
				<c:when test="${clothes.quantity < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
				<span class="fa fa-shopping-cart"></span> Add to Cart</strike></a>
					
				</c:when>
				<c:otherwise>				
					
					<a href="${contextRoot}/cart/add/${clothes.id}/clothes" class="btn btn-success">
				<span class="fa fa-shopping-cart"></span> Add to Cart</a>
						
				</c:otherwise>
			
			</c:choose>
			</security:authorize>
					
					<%-- <security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${clothes.id}/clothes" class="btn btn-success">
				<span class="fa fa-pencil"></span> Edit</a>
			</security:authorize> --%>
			
			
						
		        
				<a href="${contextRoot}/show/all/clothes" class="btn btn-primary">Back</a>
			
					
		</div>

	
	</div>

</div>