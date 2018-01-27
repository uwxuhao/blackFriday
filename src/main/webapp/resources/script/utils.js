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
                backdrop: true,
                keyboard: false
            });
        }
        $("#submitButton").click(function () {
            var userName = $("#userNameInput").val();
            var password = $("#passwordInput").val();
            var loginInfo = {"userName": userName.toString(), "password": password.toString()};
            var loginJson = JSON.stringify(loginInfo);
            $.ajax({
                url: "/blackFriday/login",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: loginJson,
                async: false,
                cache: false,
                processData: false,
                success: function (serverResponse) {
                    var success = serverResponse['success'];
                    console.log(success);
                    if (success) {

                    } else {

                    }
                }
            });
        });
    }

};
