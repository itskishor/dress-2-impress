<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container"> 

	<div class="row">

		<%-- <!-- Would be the display side bar -->
		<div class="col-lg-2">
			<%@include file="./shared/sidebar.jsp"%>

		</div> --%>


		<!-- To Display the actual products -->
		<div class="col-lg-12">
			<!-- Added BreadCrumb component -->
			<div class="row">
				<div class="col-sm-12">

					<c:if test="${userClickPopularClothes==true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Most Popular</li>


						</ol>
					</c:if>

					<c:if test="${userClickCategoryPopularClothes==true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
					<div class="col-md-12 col-sm-12 col-lg-12">
					<div class="container">
						<div class="table-responsive">
							<table id="popularClothesListTable"
								class="table table-condensed table-hover table-sm">

								<thead class="thead-dark">

									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Size</th>
										<th>UnitPrice</th>
										<th>Price/Day</th>
										<th>Qty.</th>
										<th>Views</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>