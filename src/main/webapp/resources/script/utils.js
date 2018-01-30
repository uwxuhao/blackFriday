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
        }
    },

    init: function () {
        //TODO
    },

    login: function (mainPage) {
        var loginModal = $("#loginModal");
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
        $("#submitButton").click(function () {
            var userName = $("#userNameInput").val();
            var password = $("#passwordInput").val();
            var loginInfo = {"userName": userName.toString(), "password": password.toString()};
            var loginJson = JSON.stringify(loginInfo);
            $.ajax({
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
                        $('#loginMessage').hide().html('<label class="label label-danger">' + message + '</label>').show(300);
                    }
                }
            });
        });
    }

};
