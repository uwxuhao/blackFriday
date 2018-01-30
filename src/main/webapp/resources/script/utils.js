var util = {
    url: {
        doShopping: function () {
            //TODO
        },
        getInfo: function () {
            //TODO
        },
        login: function () {
            //TODO
        },
        signUp: function () {
            //TODO
        },
        currentTime: function () {

        }
    },

    init: function () {
        //TODO
    },

    login: function (mainPage) {
        var loginModal = jQuery("#loginModal");
        if (mainPage) {
            loginModal.modal({
                show: true,
                backdrop: true,
                keyboard: true
            });
        }
        else {
            loginModal.modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
        }
        jQuery("#submitButton").click(function () {
            var userName = jQuery("#userNameInput").val();
            var password = jQuery("#passwordInput").val();
            var loginInfo = {"userName": userName.toString(), "password": password.toString()};
            var loginJson = JSON.stringify(loginInfo);
            jQuery.ajax({
                'contentType': "application/json; charset=utf-8",
                'url': "/blackFriday/login",
                'type': "POST",
                'data': loginJson,
                'dataType': 'json',
                'async': false,
                'cache': false,
                'processData': false,
                'success': function (serverResponse) {
                    // console.log(serverResponse['ServerResponse']);
                    var success = serverResponse['success'];
                    if (success) {
                        window.location.reload();
                    } else {
                        var message = serverResponse['message'];
                        jQuery('#loginMessage').hide().html('<label class="label label-danger">' + message + '</label>').show(300);
                    }
                }
            });
        });
    }

};
