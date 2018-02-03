function init(productId, startTime, endTime) {
    var currentTime = util.getCurrentTime();
    countDown(productId, currentTime, startTime, endTime);
}


function setButton(productId, countDownBox) {
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
            }
        }
    });
}

function countDown(productId, currentTime, startTime, endTime) {
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
            setButton(productId, countDownBox);
        });
    } else {
        setButton(productId, countDownBox);
    }
}
