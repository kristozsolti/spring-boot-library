$( document ).ready( function() {
	
	// Toggle active nav-link by link when the document is loading	
	var active = window.location.pathname;
	var activeLink = $("a[href='" + active + "']:first");
	activeLink.addClass("active");

	// Enable Tooltips everywhere
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	});
			
});


