<div class="container-fluid">

	<div class="row">

		<!-- Would be the display sidebar -->
		<div class="col-lg-2">
			<%@include file="./shared/sidebar.jsp"%>

		</div>


		<!-- To Display the actual products -->
		<div class="col-lg-10">
			<!-- Added BreadCrumb component -->
			<div class="row">
				<div class="col-sm-12">

					<c:if test="${userClickViewClothes==true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">View Clothes</li>


						</ol>
					</c:if>

					<c:if test="${userClickCategoryClothes==true}">
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
				<div class="col-lg-12">
					<div class="container-fluid">
						<div class="table-responsive">
							<table id="clothesListTable"
								class="table table-hover table-borderd">

								<thead class="thead-dark">

									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Size</th>
										<th>UnitPrice</th>
										<th>Price/Day</th>
										<th>Qua.</th>
										<th></th>
										<th></th>
									</tr>

								</thead>

								<tfoot class="thead-dark">

									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Size</th>
										<th>Price</th>
										<th>Price/Day</th>
										<th>Qau.</th>
										<th></th>
										<th></th>


									</tr>

								</tfoot>

							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>