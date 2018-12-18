<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">

		<div class="col-6">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Personal Details</h5>
				</div>
				<div class="card-body">
					<!-- Display the content Here -->
					<div class="text-center">
						<h3>
							Name : <strong>${registerModel.user.firstName}
								${registerModel.user.lastName}</strong>
						</h3>
						<h3>
							Email : <strong>${registerModel.user.email}</strong>
						</h3>
						<h4>
							Contact : <strong>${registerModel.user.contactNumber}</strong>
						</h4>
						<h4>
							Role : <strong>${registerModel.user.role}</strong>
						</h4>
					</div>

				</div>
				<div class="card-footer">
					<!-- Anchor to the move to the personal page -->
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Edit</a>

				</div>

			</div>
		</div>

		<div class="col-6">
			<div class="card ">
				<div class="card-header bg-dark text-white">
					<h5 class="card-title">Billing Address</h5>
				</div>
				<div class="card-body">
					<!-- Display the content Here -->
					<div class="text-center">
						<h3>${registerModel.billing.addressLineOne}</h3>
						<h3>${registerModel.billing.addressLineTwo}</h3>
						<h4>${registerModel.billing.city}-${registerModel.billing.postalCode}</h4>
						<h4>${registerModel.billing.state}-${registerModel.billing.country}</h4>
					</div>

				</div>
				<div class="card-footer">
					<!-- Anchor to the move to the personal page -->
					<a href="${flowExecutionUrl}&_eventId_billing"
						class="btn btn-primary">Edit</a>

				</div>

			</div>
		</div>
	</div>


	<!-- To provide the confirm button after providing the details -->
	<div class="row justify-content-center">
		<div class="col-1">
			<div class="text-center"></div>
			<!-- Anchor to move to the success page -->
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>

		</div>
	</div>



</div>
<%@include file="../shared/flows-footer.jsp"%>