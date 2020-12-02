/*!
    * Start Bootstrap - Grayscale v6.0.3 (https://startbootstrap.com/theme/grayscale)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-grayscale/blob/master/LICENSE)
    */
    (function ($) {
    "use strict"; // Start of use strict

    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function () {
        if (
            location.pathname.replace(/^\//, "") ==
                this.pathname.replace(/^\//, "") &&
            location.hostname == this.hostname
        ) {
            var target = $(this.hash);
            target = target.length
                ? target
                : $("[name=" + this.hash.slice(1) + "]");
            if (target.length) {
                $("html, body").animate(
                    {
                        scrollTop: target.offset().top - 70,
                    },
                    1000,
                    "easeInOutExpo"
                );
                return false;
            }
        }
    });

    // Closes responsive menu when a scroll trigger link is clicked
    $(".js-scroll-trigger").click(function () {
        $(".navbar-collapse").collapse("hide");
    });

    // Activate scrollspy to add active class to navbar items on scroll
    $("body").scrollspy({
        target: "#mainNav",
        offset: 100,
    });

    // Collapse Navbar
    var navbarCollapse = function () {
        if ($("#mainNav").offset().top > 100) {
            $("#mainNav").addClass("navbar-shrink");
        } else {
            $("#mainNav").removeClass("navbar-shrink");
        }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
-
    $(".table-row").click(function() {
        //var newWindow = window.open("DrugInfo"); newWindow.;
        //console.log($(this).data("href"));
        window.location.href = $(this).data("href");
    });
    

    $('#searchForm').on('submit',(e)=>{
    	//e.preventDefault();
    	console.log('type.val = '+$('#selectType option:selected').val());
        if($('#type option:selected').val()=='' || $('#type option:selected').val()==null){
            alert('Please select type to search.')
            return false;
        };
        if($('#searchTxt').val()=='' || $('#searchTxt').val()==null){
            alert('Please type text to search.')
            return false;
        };
    })
var flagInsu = false;
    $("#btnInsurance").click(function(event){
        console.log($("#pCode").val());
        event.preventDefault();
        // JSON request
       if(!flagInsu){
        var pCode = $("#pCode").val();
        $.ajax({
             url: "/ajaxInsurance/" + pCode,
             type: "GET",
             dataType: "json",          // ajax
             contentType: "application/json",  // ajax
             //data: {p_code : 646900710}, // JSON.stringify(data),
             success: function(result){
                 flagInsu = true;
                 createInsurance(result);
             }
        })
       }else{
    	   $('.insurance').toggle();
       }

        
    })
    
    var createInsurance = function(res){
    	console.log(res.content.administration_method);
    	
    	var htmlCode = 
    	"<table name='tableInsurance' class=\"table text-dark mt-3 mb-5 insurance\">"
		+"<tbody>"
		+"	<tr>"
		+"		<th>Main Ingredient Name</th>"
		+"		<td colspan='3'>"+res.content.main_ingredient_code+") "+res.content.main_ingredient_code_name+"</td>"
		+"	</tr>"
		+"	<tr>"
		+"		<th>Product Code (Before)</th>"
		+"		<td>"+res.content.product_code_before+"</td>"
		+"		<th>Administration Method</th>"
		+"		<td>"+res.content.administration_method+"</td>"
		+"	</tr>"
		+"	<tr>"
		+"		<th>Drug Type</th>"
		+"		<td>"+res.content.drug_type+"</td>"
		+"		<th>ATC Code</th>"
		+"		<td>"+res.content.temp_column+"</td>"
		+"	</tr>"
		+"	<tr>"
		+"		<th>Formulation type</th>"
		+"		<td>"+res.content.formulation_type+"</td>"
		+"		<th>Package type</th>"
		+"		<td>"+res.content.price_limit+"</td>"
		+"	</tr>"
		+"	<tr>"
		+"		<th colspan=\"2\">Memo</th>"
		+"		<th>Pharma standard</th>"
		+"		<td>"+res.content.pharma_standard+"</td>"
		+"	</tr>"
		+"	<tr>"
		+"		<td colspan=\"4\">"+res.content.memo+"</td>"
		+"	</tr>"
		+"</tbody>"
		+"</table>";

    	$('.row').append(htmlCode);
    }
})(jQuery); // End of use strict
