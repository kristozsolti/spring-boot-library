$( document ).ready( function() {
	
	// Toggle active nav-link by link when the document is loading	
	var active = window.location.pathname;
	$("a[href|='" + active + "']").addClass("active");

	// Enable Tooltips everywhere
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	});
			
});


