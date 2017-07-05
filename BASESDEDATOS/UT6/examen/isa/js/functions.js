
$(document).ready(function() {
	
	/* Activate H5F */
	H5F.setup($("div#signUp form"));

    $('ul#tabs li').click(function() {
    	
    	/* If what we clicked is the actual link, we move make the changes */
    	if($(this).attr("class") == "inactiveTab") {

			/* Swap classes on the clicked item */
	        $(this).addClass('activeTab').removeClass('inactiveTab');
	        
	        /* Swap classes on the other LI */
	        $(this).siblings('.activeTab').removeClass('activeTab').addClass('inactiveTab');
	        
	        /* Change the float of the previous element */
	        $(this).prev().css("float", "left");
			
			/* We toggle the tabs */
			$("div.toggleTab").slideToggle("fast", function() {

				/* Once the animation is complete, focus the first field of the visible form */
				$("div.toggleTab input:visible").first().focus();

			});
			
		}

    });
    
});