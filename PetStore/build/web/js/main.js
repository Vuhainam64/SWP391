

/*  ---------------------------------------------------
 Theme Name: Cake
 Description: Cake e-commerce tamplate
 Author: Colorib
 Author URI: https://www.colorib.com/
 Version: 1.0
 Created: Colorib
 ---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
     Preloader
     --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");
    });

    /*------------------
     Background Set
     --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Search Switch
    $('.search-switch').on('click', function () {
        $('.search-model').fadeIn(400);
    });

    $('.search-close-switch').on('click', function () {
        $('.search-model').fadeOut(400, function () {
            $('#search-input').val('');
        });
    });

    //Canvas Menu
    $(".canvas__open").on('click', function () {
        $(".offcanvas-menu-wrapper").addClass("active");
        $(".offcanvas-menu-overlay").addClass("active");
    });

    $(".offcanvas-menu-overlay").on('click', function () {
        $(".offcanvas-menu-wrapper").removeClass("active");
        $(".offcanvas-menu-overlay").removeClass("active");
    });


    /*------------------
     Navigation
     --------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
     Hero Slider
     ------------------------*/
    $(".hero__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<i class='fa fa-angle-left'><i/>", "<i class='fa fa-angle-right'><i/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: false
    });

    /*--------------------------
     Categories Slider
     ----------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 22,
        items: 5,
        dots: false,
        nav: true,
        navText: ["<span class='arrow_carrot-left'><span/>", "<span class='arrow_carrot-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: false,
        responsive: {
            0: {
                items: 1,
                margin: 0
            },
            480: {
                items: 2
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1200: {
                items: 5
            }
        }
    });

    /*-----------------------------
     Testimonial Slider
     -------------------------------*/
    $(".testimonial__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 2,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 2
            }
        }
    });

    /*---------------------------------
     Related Products Slider
     ----------------------------------*/
    $(".related__products__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='arrow_carrot-left'><span/>", "<span class='arrow_carrot-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {
            0: {
                items: 1
            },
            480: {
                items: 2
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
        }
    });

    /*--------------------------
     Select
     ----------------------------*/
    $("select").niceSelect();

    /*------------------
     Magnific
     --------------------*/
    $('.video-popup').magnificPopup({
        type: 'iframe'
    });

    /*------------------
     Barfiller
     --------------------*/
    $('#bar1').barfiller({
        barColor: '#111111',
        duration: 2000
    });
    $('#bar2').barfiller({
        barColor: '#111111',
        duration: 2000
    });
    $('#bar3').barfiller({
        barColor: '#111111',
        duration: 2000
    });


    /*------------------
     Single Product
     --------------------*/
    $('.product__details__thumb img').on('click', function () {
        $('.product__details__thumb .pt__item').removeClass('active');
        $(this).addClass('active');
        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.big_img').attr('src');
        if (imgurl != bigImg) {
            $('.big_img').attr({
                src: imgurl
            });
        }
    });


//Home 
    $(".product__details__thumb").niceScroll({
        cursorborder: "",
        cursorcolor: "rgba(0, 0, 0, 0.5)",
        boxzoom: false
    });
    $('.cupcake').mouseover(function () {
        $('#cupcake').show();
        $('#butter').hide();
        $('#red_velvet').hide();
        $('#biscuit').hide();
        $('#donut').hide();
    });

    $('.butter').mouseover(function () {
        $('#cupcake').hide();
        $('#butter').show();
        $('#red_velvet').hide();
        $('#biscuit').hide();
        $('#donut').hide();
    });

    $('.red_velvet').mouseover(function () {
        $('#cupcake').hide();
        $('#butter').hide();
        $('#red_velvet').show();
        $('#biscuit').hide();
        $('#donut').hide();
    });

    $('.biscuit').mouseover(function () {
        $('#cupcake').hide();
        $('#butter').hide();
        $('#red_velvet').hide();
        $('#biscuit').show();
        $('#donut').hide();
    });

    $('.donut').mouseover(function () {
        $('#cupcake').hide();
        $('#butter').hide();
        $('#red_velvet').hide();
        $('#biscuit').hide();
        $('#donut').show();
    });

//Shop
    //Sort
    $(document).ready(function () {
        $(".shop__option__right select").change(function () {
            var selectedOption = $(this).val();
            var url = window.location.href;
            var newUrl = "";
            if (selectedOption === "name") {
                newUrl = updateUrlParam(url, "sort", "name");
            } else if (selectedOption === "id") {
                newUrl = updateUrlParam(url, "sort", "id");
            } else if (selectedOption === "price") {
                newUrl = updateUrlParam(url, "sort", "price");
            }
            // create a form and submit it using POST method
            var form = $('<form method="POST" action="' + newUrl + '">');
            $('body').append(form);
            form.submit();
        });
    });

    function updateUrlParam(url, param, value) {
        var regex = new RegExp("([?&])" + param + "=.*?(&|$)", "i");
        if (url.match(regex)) {
            return url.replace(regex, "$1" + param + "=" + value + "$2");
        } else {
            if (url.indexOf("?") === -1) {
                return url + "?" + param + "=" + value;
            } else {
                return url + "&" + param + "=" + value;
            }
        }
    }

    $(document).ready(function () {
        const form = $('.signUp');
        const passwordInput = $('#password');
        const confirmPasswordInput = $('#confirmPassword');
        const checkBoxInput = $('#checkbox');

        form.submit(function (event) {
            if (passwordInput.val() !== confirmPasswordInput.val()) {
                event.preventDefault();
                alert('Passwords do not match!');
            }

            if (!checkBoxInput.prop('checked')) {
                event.preventDefault();
                alert('Please agree to the terms and conditions.');
            }
        });
    });

})(jQuery);

