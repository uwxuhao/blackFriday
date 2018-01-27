$(window).on("load", function ($) {
    $(".clickable-row").click(function () {
        window.location = $(this).data("href");
    });

    $("#loginButton").click(function () {
        util.login(true);
    });
});