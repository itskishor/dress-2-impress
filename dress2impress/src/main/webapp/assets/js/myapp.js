$(function() {
	// Solving active menu problem
	switch (menu) {

	case 'View Clothes':
		$('#viewclothes').addClass('active');
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
					str +='<a href="'+window.contextRoot+'/show/'+data+'/clothes" class="btn btn-info btn-sm">View</a> &#160;' ;
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

});