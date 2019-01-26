<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="container-fluid">

	<!-- Bread crumb -->
	<div class="row">
		
		<div class="col-sm-12">
		
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/employeemanage/purchase">Supplier Clothes</a></li>
				<li class="breadcrumb-item active">${supplierClothes.name}</li>		
			</ol>
		
		
		</div>
	
	
	</div>
	
	
	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-lg-6">
		
			<div class="thumbnail">
							
				<img src="${images}/${supplierClothes.code}.jpeg" class="img img-responsive" width=65% height=80%/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-lg-6">
		
			<h3>${supplierClothes.name}</h3>
			<hr/>
			
			<p>${supplierClothes.description}</p>
			<hr/>
			
			<h5>Price: <strong> &#8377;${supplierClothes.unitPrice} /-</strong></h5>
			<hr/>
					
			<c:choose>
				
				<c:when test="${supplierClothes.quantity < 1}">
				
					<h6>Quantity Available: <span style="color:red">Out of Stock!</span></h6>
					<h6><span style="color:blue">Coming Soon!</span></h6>
					
				</c:when>
				<c:otherwise>				
					
					<h6>Quantity Available: ${supplierClothes.quantity}</h6>
						
				</c:otherwise>
			
			</c:choose>
			
			<a href="${contextRoot}/employeemanage/purchase" class="btn btn-primary">Back</a>
			<a href="${contextRoot}/${supplierClothes.id}/supplierpayment" class="btn btn-success">Purchase</a>
					
		</div>
		
		</div>
	
	</div>