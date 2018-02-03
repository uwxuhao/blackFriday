var util = {
    url: {
        productRequest: function () {
            return "/blackFriday/request";
        },
        login: function () {
            return "/blackFriday/login";
        },
        getInfo: function (productId) {
            return "/blackFriday/" + productId + "/info"
        },
        signUp: function () {
            //TODO
        },
        currentTime: function () {
            return "/blackFriday/currentTime";
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
                'url': util.url.login(),
                'type': "POST",
                'data': loginJson,
                'dataType': 'json',
                'async': false,
                'cache': false,
                'processData': false,
                'success': function (serverResponse) {
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
    },

    getCurrentTime: function () {
        var currentTime = null;
        jQuery.ajax({
            'contentType': "application/json; charset=utf-8",
            'url': util.url.currentTime(),
            'type': "POST",
            'async': false,
            'cache': false,
            'processData': false,
            'success': function (serverResponse) {
                var success = serverResponse['success'];
                if (success) {
                    currentTime = serverResponse['data'];
                }
            }
        });
        return currentTime;
    },

    sendProductRequest: function (productId, userId, num, md5) {
        var requestResult = null;
        var requestInfo = {
            "productId": productId.toString(),
            "userId": userId.toString(),
            "num": num.toString(),
            "md5": md5
        };
        var requestJson = JSON.stringify(requestInfo);
        jQuery.ajax({
            'contentType': "application/json; charset=utf-8",
            'url': util.url.productRequest(),
            'type': "POST",
            'data': requestJson,
            'dataType': 'json',
            'async': false,
            'cache': false,
            'processData': false,
            'success': function (serverResponse) {
                console.log(serverResponse);
                var success = serverResponse['success'];
                if (success) {
                    var data = serverResponse['data'];
                    requestResult = data['state'];
                }
            },
            'error': function (XMLHttpRequest, textStatus, errorThrown) {
                alert("Status: " + textStatus);
                alert("Error: " + errorThrown);
            }
        });
        return requestResult;
    }

};
