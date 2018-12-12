$(function() {
	// Solving active menu problem
	switch (menu) {

	case 'View Clothes':
		$('#viewclothes').addClass('active');
		break;
	case 'Manage Clothes':
		$('#manageclothes').addClass('active');
		break;
	case 'Admin':
		$('#admin').addClass('active');
		break;
	case 'Employee':
		$('#employee').addClass('active');
		break;
	case 'Supplier':
		$('#supplier').addClass('active');
		break;
	case 'Sign In':
		$('#signin').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#viewclothes').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
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

		$table.DataTable({
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

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpeg" class="imageTable" width="100" height="100"/>'; 

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
					var str='';
					str +='<a href="'+window.contextRoot+'/show/'+data+'/clothes" class="btn btn-info btn-sm">View <span class="fa fa-eye"></span></a> &#160;' ;
					return str;
				}

			},
			{
				data : 'id',
				bSortable : false,
				mRender : function(data, type, row) {
					var str='';
					
					if (row.quantity < 1) {
						str += '<a href="javascript:void(0)" class="btn btn-success btn-sm disabled">Cart<span class="fa fa-shopping-cart"></span></a>';
					}
					else
						{
						str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/clothes" class="btn btn-success btn-sm">Cart<span class="fa fa-shopping-cart"></span></a>';
						 
						}
					return str;
				}

			}

			]
		});
	}
	
	// dismissing the alert after 3 seconds
	var $alert= $('.alert');
	if($alert.length){
		
	setTimeout(function(){
		$alert.fadeOut('slow');
	}, 3000)
	}
	
	// --------------------------------
	
	$
	
	 /*Data Table For Admin */
	
	var $adminClothesTable = $("#adminClothesTable");

	if ($adminClothesTable.length) {
		// console.log('Inside the table!');

		var jsonUrl =  window.contextRoot + '/json/data/admin/all/clothes';
		$adminClothesTable.DataTable({
			lengthMenu : [ [ 10, 20, 30, -1 ],
					[ '10 Records', '20 Records', '30 Records', 'ALL' ] ],
			pageLength : 20,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ 
				
				{data: 'id'},


				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
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
					if(data) {											
						str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
						
					}else {
						str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
					}
					
					return str;
				}
			},
			{
				data : 'id',
				bSortable : false,
				mRender : function(data, type, row) {

					var str = '';
					str += '<a href="'+window.contextRoot+'/manage/'+data+ '/clothes" class="btn btn-success">';
					str +='<span class="fa fa-pencil"> Edit</span></a>';

					return str;
				}
			}			

			],
			
			initComplete: function () {
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox= $(this);
					var checked=checkbox.prop('checked');
					var dMsg=(checked)? 'Do You want to activate the product?':
					                 	'Do You want to deactivate the product?';
					var value=checkbox.prop('value');
					
					bootbox.confirm({
						size:"medium",
						message:dMsg,
						callback: function(confirmed){
							if(confirmed){
								
								console.log(value);
								var activationUrl=window.contextRoot + '/manage/clothes/' + value  + '/activation';
								$.post(activationUrl, function(data){
									
									bootbox.alert({
										size:"medium",
										message:data
						 			});
									
								});	
							}
							
							else{
								checkbox.prop('checked',!checked); 
							}
						}
						
						}); 
					
					});
			   }	
			
		});
	}
	
	//------------------------
	
	//Validation Code For Category
	var $categoryForm=$("#categoryForm");
	if($categoryForm.length)
		{
		$categoryForm.validate({
			rules:{
				name:{
					required:true,
					minlength:2
				},
				description :{
					required:true
				}
			},
			messages :{
				name: {
					required:'please add the category Name!',
					minlength:'The category name should not be less than 2 characters!'
				},
			
			description: {
				required:'please add the description for this category!',
			}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
			
		});
		
		
		}
	
	//--------------------------
});









