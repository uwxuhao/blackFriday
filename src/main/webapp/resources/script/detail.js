function init(productId, startTime, endTime, userId) {
    var currentTime = util.getCurrentTime();
    countDown(productId, currentTime, startTime, endTime, userId);
}


function setButton(productId, countDownBox, userId) {
    countDownBox.hide().html('<button class="btn btn-primary btn-lg" id = "shopButton">Add to Cart</button>');
    jQuery.ajax({
        'contentType': "application/json; charset=utf-8",
        'url': util.url.getInfo(productId),
        'type': "POST",
        'async': false,
        'cache': false,
        'processData': false,
        'success': function (serverResponse) {
            var success = serverResponse['success'];
            var data = serverResponse['data'];
            var md5 = data['md5'];
            if (success) {
                var shopButton = jQuery("#shopButton");
                countDownBox.show();
                shopButton.one('click', function () {
                    jQuery(this).addClass('disabled');
                    var requestResult = util.sendProductRequest(productId, userId, 1, md5);
                    if(requestResult === "SUCCESS"){
                        alert("Congratulation! You get the product!");
                    } else if(requestResult === "END"){
                        alert("Sorry! The product is closed");
                    } else if(requestResult === "NOT_ENOUGH"){
                        alert("Sorry! There is not enough inventory");
                    } else if(requestResult === "WRONG_MD5"){
                        alert("Warning! You are cheating!");
                    } else if(requestResult === "INNER_ERROR"){
                        alert("Inner error");
                    }
                });
            }
        }
    });
}

function countDown(productId, currentTime, startTime, endTime, userId) {
    var countDownBox = jQuery("#countdown-box");
    if (currentTime > endTime) {
        countDownBox.html('End');
    } else if (currentTime < startTime) {
        var startDate = new Date(startTime);
        console.log(startDate);
        countDownBox.countdown(startDate, function (event) {
            var format = event.strftime('Count Down：%D day %H hour %M minute %S second');
            countDownBox.html(format);
        }).on('finish.countdown', function () {
            setButton(productId, countDownBox, userId);
        });
    } else {
        setButton(productId, countDownBox, userId);
    }
}
