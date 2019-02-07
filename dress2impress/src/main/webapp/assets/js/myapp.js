$(function() {
	// Solving active menu problem
	switch (menu) {

	case 'View Clothes':
		$('#viewclothes').addClass('active');
		break;
	case 'Most Popular':
		$('#popularclothes').addClass('active');
		break;
	case 'Manage Transactions':
		$('#employeemanagetransactions').addClass('active');
		break;
	case 'Transactions':
		$('#adminviewtransactions').addClass('active');
		break;
	case 'Contact Us':
		$('#contactus').addClass('active');
		break;
	case 'About Us':
		$('#aboutus').addClass('active');
		break;
	case 'Manage Clothes':
		$('#employeemanageclothes').addClass('active');
		break;
	case 'Manage Employee':
		$('#manageemployee').addClass('active');
		break;
	case 'Manage User':
		$('#employeemanageuser').addClass('active');
		break;
	case 'Manage Supplier':
		$('#managesupplier').addClass('active');
		break;
	case 'Manage Categories':
		$('#managecategories').addClass('active');
		break;
	case 'Add Clothes':
		$('#addclothes').addClass('active');
		break;
	case 'Purchase Clothes':
		$('#employeemanagepurchase').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#viewclothes').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if ((token != undefined && header != undefined)
			&& (token.length > 0 && header.length > 0)) {
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}

	// Code For JQery Table
	var $table = $("#clothesListTable");

	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/clothes';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/clothes';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpeg" class="imageTable" width="60" height="80"/>';

								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'size'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},
							{
								data : 'pricePerDay',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/clothes" class="btn btn-info btn-sm">View <span class="fa fa-eye"></span></a>';
									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if ((userRole== 'USER')) {
										if (row.quantity < 1) {
											str += '<a href="javascript:void(0)" class="btn btn-success btn-sm disabled">Cart<span class="fa fa-shopping-cart"></span></a>';
										} 
										else 
										{
											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/clothes" class="btn btn-success btn-sm">Cart <span class="fa fa-shopping-cart"></span></a>';

										}
									} 
									else
										{
											/*str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/clothes" class="btn btn-success btn-sm disabled">Cart <span class="fa fa-shopping-cart"></span></a>';*/
											
										}
									return str;
									
								}

							}

					]
				});
	}
	
	// Code For Popular Clothes JQery Table
	var $table = $("#popularClothesListTable");

	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/popular/clothes';
		} 
		else 
		{
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/popularclothes';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpeg" class="imageTable" width="60" height="80"/>';

								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'size'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},
							{
								data : 'pricePerDay',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'views'
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/clothes" class="btn btn-info btn-sm">View <span class="fa fa-eye"></span></a>';
									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if ((userRole == 'USER')) {
										if (row.quantity < 1) {
											str += '<a href="javascript:void(0)" class="btn btn-success btn-sm disabled">Cart<span class="fa fa-shopping-cart"></span></a>';
										} 
										else 
										{
											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/clothes" class="btn btn-success btn-sm">Cart <span class="fa fa-shopping-cart"></span></a>';

										}
									} 
									else 
									{
										
									}
									return str;
								}

							}

					]
				});
	}


	// dismissing the alert after 3 seconds
	var $alert = $('.alert');
	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// --------------------------------

	/* Clothes Data Table For Employee */

	var $adminClothesTable = $("#adminClothesTable");

	if ($adminClothesTable.length) {
		// console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/clothes';
		$adminClothesTable
		.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
			pageLength : 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [

							{
								data : 'id'
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpeg" class="adminDataTableImg" width="100" height="100"/>';

								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},

							{
								data : 'size'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},
							{
								data : 'pricePerDay',
								mRender : function(data, type, row) {
									return '&#8377;' + data
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/employeemanage/'
											+ data
											+ '/clothes" class="btn btn-success">';
									str += '<span class="fa fa-pencil"> Edit</span></a>';

									return str;
								}
							}

					],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Do You want to activate the product?'
													: 'Do You want to deactivate the product?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : "medium",
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {

																console
																		.log(value);
																var activationUrl = window.contextRoot
																		+ '/employeemanage/clothes/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {

																					bootbox
																							.alert({
																								size : "medium",
																								message : data
																							});

																				});
															}

															else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}

													});

										});
					}

				});
	}

	// Validation Code For Category
	var $categoryForm = $("#categoryForm");
	if ($categoryForm.length) {
		$categoryForm
				.validate({
					rules : {
						name : {
							required : true,
							minlength : 2
						},
						description : {
							required : true
						}
					},
					messages : {
						name : {
							required : 'please add the category Name!',
							minlength : 'The category name should not be less than 2 characters!'
						},

						description : {
							required : 'please add the description for this category!',
						}
					},
					errorElement : 'em',
					errorPlacement : function(error, element) {
						// add the class of help-block
						error.addClass('help-block');
						// add the error element after the input element
						error.insertAfter(element);
					}

				});

	}

	// ---------------------------------------
	// Employee Data Table for Admin
	var $adminEmployeeTable = $("#adminEmployeeTable");

	if ($adminEmployeeTable.length) {
		// console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/employees';

		$adminEmployeeTable
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
					pageLength : 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id',
							},
							{
								data : 'firstName'
							},
							{
								data : 'lastName'
							},
							{
								data : 'email'
							},
							{
								data : 'contactNumber',
							},
							{
								data : 'salary',
									mRender : function(data, type, row) {
										return '&#8377;' + data
									}
							},
							{
								data : 'dob'
							},
							
							{
								data : 'doj'
							},
							{
								data : 'empaddr'
							},
													
							{
								data : 'enabled',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'+ window.contextRoot+'/manage/'+data+ '/employee" class="btn btn-success">';
									str += '<span class="fa fa-pencil"> Edit</span></a>';

									return str;
								}
							}

					],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Do You want to activate the User?'
													: 'Do You want to deactivate the User?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : "medium",
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {

																console
																		.log(value);
																var activationUrl = window.contextRoot
																		+ '/manage/employee/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {

																					bootbox
																							.alert({
																								size : "medium",
																								message : data
																							});

																				});
															}

															else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}

													});

										});
					}
					
				});
	}


	// --------------------------
	
//User Data Table for Employee
	
	var $adminUserTable = $("#adminUserTable");

	if ($adminUserTable.length) {
		// console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/user';

		$adminUserTable
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id',
							},
							{
								data : 'firstName'
							},
							{
								data : 'lastName'
							},
							{
								data : 'email'
							},
							{
								data : 'contactNumber',
							},
							
							{
								data : 'enabled',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'+ window.contextRoot+'/employeemanage/'+data+ '/user" class="btn btn-success">';
									str += '<span class="fa fa-pencil"> Edit</span></a>';

									return str;
								}
							}

					],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Do You want to activate the User?'
													: 'Do You want to deactivate the User?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : "medium",
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {

																console
																		.log(value);
																var activationUrl = window.contextRoot
																		+ '/employeemanage/user/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {

																					bootbox
																							.alert({
																								size : "medium",
																								message : data
																							});

																				});
															}

															else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}

													});

										});
					}
					
				});
	}

	// --------------------------
	
	
	//Supplier Data Table for Admin
		
		var $adminSupplierTable = $("#adminSupplierTable");

		if ($adminSupplierTable.length) {
			// console.log('Inside the table!');

			var jsonUrl = window.contextRoot + '/json/data/admin/all/supplier';

			$adminSupplierTable
					.DataTable({
						lengthMenu : [ [ 3, 5, 10, -1 ],
								[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
						pageLength : 5,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
								{
									data : 'id',
								},
								{
									data : 'firstName'
								},
								{
									data : 'lastName'
								},
								{
									data : 'email'
								},
								{
									data : 'contactNumber',
								},
								
								{
									data : 'enabled',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';
										if (data) {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '" checked="checked">  <div class="slider round"> </div></label>';

										} else {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '">  <div class="slider round"> </div></label>';
										}

										return str;
									}
								},
								{
									data : 'id',
									bSortable : false,
									mRender : function(data, type, row) {

										var str = '';
										str += '<a href="'+ window.contextRoot+'/manage/'+data+ '/supplier" class="btn btn-success">';
										str += '<span class="fa fa-pencil"> Edit</span></a>';

										return str;
									}
								}

						],

						initComplete : function() {
							var api = this.api();
							api
									.$('.switch input[type="checkbox"]')
									.on(
											'change',
											function() {
												var checkbox = $(this);
												var checked = checkbox
														.prop('checked');
												var dMsg = (checked) ? 'Do You want to activate the User?'
														: 'Do You want to deactivate the User?';
												var value = checkbox.prop('value');

												bootbox
														.confirm({
															size : "medium",
															message : dMsg,
															callback : function(
																	confirmed) {
																if (confirmed) {

																	console
																			.log(value);
																	var activationUrl = window.contextRoot
																			+ '/manage/supplier/'
																			+ value
																			+ '/activation';
																	$
																			.post(
																					activationUrl,
																					function(
																							data) {

																						bootbox
																								.alert({
																									size : "medium",
																									message : data
																								});

																					});
																}

																else {
																	checkbox
																			.prop(
																					'checked',
																					!checked);
																}
															}

														});

											});
						}
						
					});
		}

		// --------------------------
		
		//Transaction for Admin
		
		var $adminViewTransaction = $("#adminViewTransaction");

		if ($adminViewTransaction.length) {
			// console.log('Inside the table!');

			var jsonUrl = window.contextRoot + '/json/data/admin/all/transactions';

			$adminViewTransaction
					.DataTable({
						lengthMenu : [ [ 3, 5, 10, -1 ],
								[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
						pageLength : 5,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
								{
									data : 'id',
								},
								{
									data :'user.id',
								},						
								{
									data :'user.firstName',
								},
								{
									data :'user.lastName',
								},
								{
									data : 'orderCount'
								},
								{
									data : 'noOfDays'
								},
								{
									data : 'bookingDate'
								},
								{
									data : 'issueDate'
								},
								{
									data : 'returnDate',
								},
								{
									data : 'deposite',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								{
									data : 'totalRent',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								{
									data : 'orderTotal',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								
								{
									data : 'active',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';
										if (data) {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '" checked="checked">  <div class="slider round"> </div></label>';

										} else {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '">  <div class="slider round"> </div></label>';
										}

										return str;
									}
								},
						]
						/*,

						initComplete : function() {
							var api = this.api();
							api
									.$('.switch input[type="checkbox"]')
									.on(
											'change',
											function() {
												var checkbox = $(this);
												var checked = checkbox
														.prop('checked');
												var dMsg = (checked) ? 'Do You want to Close the Transaction?'
														: 'Do You want to Activat the Transaction?';
												var value = checkbox.prop('value');

												bootbox
														.confirm({
															size : "medium",
															message : dMsg,
															callback : function(
																	confirmed) {
																if (confirmed) {

																	console
																			.log(value);
																	var activationUrl = window.contextRoot
																			+ '/employeemanage/transactions/'
																			+ value
																			+ '/activation';
																	$
																			.post(
																					activationUrl,
																					function(
																							data) {

																						bootbox
																								.alert({
																									size : "medium",
																									message : data
																								});

																					});
																}

																else {
																	checkbox
																			.prop(
																					'checked',
																					!checked);
																}
															}

														});

											});
						}*/
						
					});
		}
		
// --------------------------
//Supplier Clothes for Employee for Purchase
		var $table = $("#supplierClothesListTable");

		if ($table.length) {
			// console.log('Inside the table!');

			var jsonUrl = window.contextRoot + '/json/data/all/supplierclothes';
			$table
					.DataTable({
						lengthMenu : [ [ 3, 5, 10, -1 ],
								[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
						pageLength : 5,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
							
							     {
								   data : 'id'
							     },
								{
									data : 'code',
									bSortable : false,
									mRender : function(data, type, row) {

										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/'
												+ data
												+ '.jpeg" class="imageTable" width="60" height="80"/>';

									}
								},
								{
									data : 'name'
								},
								{
									data : 'brand'
								},
								{
									data : 'size'
								},
								{
									data : 'unitPrice',
									mRender : function(data, type, row) {
										return '&#8377;' + data
									}
								},

								{
									data : 'quantity',
									mRender : function(data, type, row) {

										if (data < 1) {
											return '<span style="color:red">Out of Stock!</span>';
										}

										return data;

									}
								},
								{
									data : 'id',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';
										if (row.quantity < 1) {
											str += '<a href="javascript:void(0)" class="btn btn-info btn-sm disabled"><span class="fa fa-shopping-bag">Purchase</span></a>';
										}
										else{
										str += '<a href="'
												+ window.contextRoot
												+ '/show/'
												+ data
												+ '/supplierclothes" class="btn btn-info btn-sm"><span class="fa fa-shopping-bag"> Purchase</span></a>';
										}
										return str;
									}

								}

						]
					});
		}
	
		
// --------------------------
		
		//Transaction Management for Employee
		
		var $employeeManageTransaction = $("#employeeManageTransaction");

		if ($employeeManageTransaction.length) {
			// console.log('Inside the table!');

			var jsonUrl = window.contextRoot + '/json/data/all/activetransactions';

			$employeeManageTransaction
					.DataTable({
						lengthMenu : [ [ 3, 5, 10, -1 ],
								[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
						pageLength : 5,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
								{
									data : 'id',
								},
								{
									data :'user.id',
								},						
								{
									data :'user.firstName',
								},
								{
									data :'user.lastName',
								},
								{
									data : 'orderCount'
								},
								{
									data : 'noOfDays'
								},
								{
									data : 'bookingDate'
								},
								{
									data : 'issueDate'
								},
								{
									data : 'returnDate',
								},
								{
									data : 'deposite',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								{
									data : 'totalRent',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								{
									data : 'orderTotal',
										mRender : function(data, type, row) {
											return '&#8377;' + data
										}
								},
								
								{
									data : 'active',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';
										if (data) {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '" checked="checked">  <div class="slider round"> </div></label>';

										} else {
											str += '<label class="switch"> <input type="checkbox" value="'+ row.id
													+ '">  <div class="slider round"> </div></label>';
										}

										return str;
									}
								},
						],

						initComplete : function() {
							var api = this.api();
							api
									.$('.switch input[type="checkbox"]')
									.on(
											'change',
											function() {
												var checkbox = $(this);
												var checked = checkbox
														.prop('checked');
												var dMsg = (checked) ? 'Do You want to Active the Transaction?'
														: 'Do You want to Close the Transaction?';
												var value = checkbox.prop('value');

												bootbox
														.confirm({
															size : "medium",
															message : dMsg,
															callback : function(
																	confirmed) {
																if (confirmed) {

																	console
																			.log(value);
																	var activationUrl = window.contextRoot
																			+ '/employeemanage/transactions/'
																			+ value
																			+ '/activation';
																	$
																			.post(
																					activationUrl,
																					function(
																							data) {

																						bootbox
																								.alert({
																									size : "medium",
																									message : data
																								});

																					});
																}

																else {
																	checkbox
																			.prop(
																					'checked',
																					!checked);
																}
															}

														});

											});
						}
						
					});
		}

		//---------------------------
	
// Category Data Table for Admin
	
	var $adminCategoryTable = $("#adminCategoryTable ");

	if ($adminCategoryTable .length) 
	{
		// console.log('Inside the table!');

	var jsonUrl = window.contextRoot + '/json/data/admin/all/categories';

	$adminCategoryTable.DataTable({
					lengthMenu : [ [ 3, 5, 7, -1 ],[ '3 Records', '5 Records', '7 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id',
							},
							{
								data : 'name'
							},
							{
								data : 'description'
							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) 
								{
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'+window.contextRoot+'/manage/'+data+'/category" class="btn btn-success">';
									str += '<span class="fa fa-pencil"> Edit</span></a>';
									return str;
								}
							}
					],

					initComplete : function() {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change',
						function() {
								var checkbox = $(this);
								var checked = checkbox.prop('checked');
								var dMsg = (checked) ? 'Do You want to activate the Category?'
													: 'Do You want to deactivate the Category?';
								var value = checkbox.prop('value');
                                bootbox.confirm({
												size : "medium",
												message : dMsg,
												callback : function(confirmed) {
															if (confirmed) {
																console.log(value);
																var activationUrl = window.contextRoot+'/manage/categories/'+value+'/activation';
																$.post(activationUrl,function(data) 
																{
																	bootbox.alert
																	({
														                 size : "medium",
																	     message : data
																	});

																});
															    }

															else 
															{
																checkbox.prop('checked',!checked);					
															}
														}

													});

										});
					}
					
				});
	}	
	//---------------------------
	/* handle refresh cart */
	$('button[name="refreshCart"]')
			.click(
					function() {
						// fetch the cart line id
						var cartLineId = $(this).attr('value');
						var countElement = $('#count_' + cartLineId);
						var countDays = $('#countdays_' + cartLineId);
						var issueDate = $('#issuedate_' + cartLineId);

						var originalCount = countElement.attr('value');
						var currentCount = countElement.val();

						var originalCountDays = countDays.attr('value');
						var currentCountDays = countDays.val();

						var originalIssueDate = issueDate.attr('value');
						var currentIssueDate = issueDate.val();

						// do the checking only when the count has changed
						if ((currentCount !== originalCount)
								|| (currentCountDays !== originalCountDays)
								|| (currentIssueDate > originalIssueDate)) {

							if (currentCountDays > 7 || currentCountDays < 1) {
								// set the field back to the original field
								countDays.val(originalCountDays);
								bootbox
										.alert({
											size : 'medium',
											// title: 'Error',
											message : 'Days Count should be minimum 1 and Maximum 7 Only!'
										});

							}
							// check if the quantity is within the specified
							// range
							else if (currentCount < 1) {
								// set the field back to the original field
								countElement.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											// title: 'Error',
											message : 'Clothes Count should be minimum 1!'
										});
							} else {
								// use the window.location.href property to send
								// the request to the server
								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ currentCount + '&countdays='
										+ currentCountDays + '&issuedate='
										+ currentIssueDate;
								// forward it to the controller
								window.location.href = updateUrl;
							}

						}

					});
});
