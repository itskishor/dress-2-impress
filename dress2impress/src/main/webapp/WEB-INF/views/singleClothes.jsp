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
							
				<img src="${images}/${clothes.code}.jpeg" class="img img-responsive" width="400" height="400"/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-lg-5">
		
			<h3>${clothes.name}</h3>
			<hr/>
			
			<p>${clothes.description}</p>
			<hr/>
			
			<h4>Price: <strong> &#8377; ${clothes.unitPrice} /-</strong></h4>
			<hr/>
					<h6>Qty. Available: ${clothes.quantity}</h6>
					
					
						
		        <a href="${contextRoot}/cart/add/${clothes.id}/clothes" class="btn btn-success">
				<span class="fa fa-shopping-cart"></span> Add to Cart</a>
				<a href="${contextRoot}/show/all/clothes" class="btn btn-primary">Back</a>
			
					
		</div>

	
	</div>

</div>