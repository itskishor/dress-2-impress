<div class="container">
	<div class="row">

		<!-- Would be the display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- To Display the actual products -->
		<div class="col-md-9">
			<!-- Added BreadCrumb component -->
			<div class="row">
				<div class="col-lg-12">
				
				<c:if test="${userClickViewClothes==true}">
					<ol class="breadcrumb"> 
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item active">View Clothes</li>
				
					
					</ol>
                 </c:if>
                 
                 <c:if test="${userClickCategoryClothes==true}">
					<ol class="breadcrumb"> 
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item active">Category</li>
					<li class="breadcrumb-item active">${category.name}</li>
					</ol>
                 </c:if>
				</div>
			</div>

		</div>

	</div>
</div>