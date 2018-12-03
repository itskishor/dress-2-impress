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
		$('#viewclothes').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	}

});