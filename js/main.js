//COUNT DOWN CLOCK
$(document).ready(function () {

    $(window).on('scroll', function () {
        var wHeight = $(window).scrollTop();
        var wWidth = $(window).width();

        if (wWidth > 800) {
            if (wHeight > 120) {
                $('.header').addClass('fixed');
            } else {
                $('.header').removeClass('fixed');
            }
        } else {
            $('.header').addClass('fixed');
            if (!($('.mob-nav-wrapper').hasClass('show'))) {
                $('.header').addClass('fixed');
            }
        }
        // if (wHeight > 120) {
        //     if (wWidth > 800) {
        //         $('.header').addClass('fixed');
        //     } else {
        //         if (!($('.mob-nav-wrapper').hasClass('show'))) {
        //             $('.header').addClass('fixed');
        //         }
        //     }

        // } else {
        //     $('.header').removeClass('fixed');
        // }
    });
    //TAB COMPONENT
    var $tabs = $(".tabs");
    $tabs.each(function () {
        $(this).siblings('.tab-content').addClass("_hide");
        var curentTarget = $(this).find(".active").attr("tab-target");
        $(curentTarget).removeClass("_hide");
    });

    $(".tabs").on("click", "li", function (e) {
        e.preventDefault();
        tabProcess($(this));
    });

    function tabProcess(tab) {
        var target = $(tab).attr("tab-target");
        var $panels = $(target).siblings('.tab-content');
        var latestActive = $(tab).siblings(".item");
        $(latestActive).each(function () {
            if (latestActive.hasClass("active")) {
                $(this).removeClass("active");
            }
        });
        $(tab).addClass("active");

        $panels.each(function () {
            if ($(this) != $(target)) {
                $(this).addClass("_hide");
            }
        });
        $(target).removeClass("_hide");
    }

    //DROPDOWN COMPONENT

    $('body').on('click', '.dropdown-trigger', function (e) {
        var target = $(this).attr('data-target');
        $('.dropdown-content').each(function () {
            var dropdownId = '#' + $(this).attr('id');
            if (dropdownId != target) {
                $(this).removeClass("__show");
            }
        });

        $(target).toggleClass("__show");

        e.preventDefault();
        e.stopPropagation();
        $(window).click(function (e) {
            if (!$(e.target).closest(target).length) {
                $(target).removeClass("__show");
            }
        });
    });

    $('body').on('click', '.dropdown-content li', function () {
        var value = $(this).html();
        var valueLabel = $(this).closest('.selector-wrapper').find('.dropdown-value');
        console.log(valueLabel);
        $(valueLabel).html(value);
        $('.dropdown-content').removeClass("__show");
    });

    //QUANTITY BOX
    $('body').on('click', '.qty-btn', function () {
        var valueInput = $(this).siblings('.qty-value');

        var currentVal = $(valueInput).val();

        if ($(this).hasClass('down')) {
            if (parseInt(currentVal) > 0) {
                $(valueInput).val(parseInt(currentVal) - 1);
            }
        } else if ($(this).hasClass('up')) {
            $(valueInput).val(parseInt(currentVal) + 1);
        }
    });

    //SEARCH
    $('.btn-mob-search').click(function () {
        $('.search-box').addClass('show');
    });
    $('.btn-close-search').click(function () {
        $('.search-box').removeClass('show');
    });
    //HAMBURGER
    var mobNav = '.mob-nav-wrapper';
    $('#mobNavTrigger').click(function () {
        $(mobNav).addClass('show');
        $('.body-mask').show();
        $('.header').removeClass('fixed');
        $('.mob-list-action').addClass('__hide');
    });
    $('.body-mask').click(function () {
        if ($(mobNav).hasClass('show')) {
            $(mobNav).removeClass('show');
            $(this).hide();
            $('.header').addClass('fixed');
            $('.mob-list-action').removeClass('__hide');
        }
    });

    //MODAL

    function closeModal() {
        $(".modal").removeClass("show")
    }

    var $modalTrigger = $(".open-modal"),
        $modalClose = $(".close-modal");
    $(document).on("click", ".open-modal", function (e) {
        e.stopPropagation();
        var t = $(this).attr("target");
        $(t).addClass("show")
    }), $(document).on("click", ".close-modal", function (e) {
        closeModal()
    }), $(document).on("click", ".modal-content", function (e) {
        e.stopPropagation()
    }), $(document).on("click", ".modal", function (e) {
        closeModal()
    });

    //FLASH MODAL
    $('.flash-msg').click(function () {
        var flashMsg = $(this).attr('flash-data');
        $('.flash-modal .msg').html(flashMsg);
        $('.flash-modal').addClass('show');
        setTimeout(function () {
            $('.flash-modal').removeClass('show');
        }, 1500);
    })
});