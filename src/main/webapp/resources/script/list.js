jQuery(window).on("load", function () {
    jQuery(".clickable-row").click(function () {
        window.location = jQuery(this).data("href");
    });

    jQuery("#loginButton").click(function () {
        util.login(true);
    });
});