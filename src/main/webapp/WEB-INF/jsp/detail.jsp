<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>${product.productName}</title>
    <%@include file="common/head.jsp" %>
    <%@include file="components/init.jsp" %>
</head>
<body>

<div class="container">
    <div class="panel panel-default">

        <%@include file="components/navbar.jsp" %>

        <div class="panel-heading text-center display-3">
            <h1>${product.productName}</h1>
        </div>


        <div class="panel-body">
            <h2 class="text-danger text-center">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="countdown-box">placeholder</span>
            </h2>
        </div>

    </div>
</div>


<%@include file="components/loginDialogue.jsp" %>


<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/script/utils.js"></script>

<script type="text/javascript">
    jQuery(window).on("load", function () {
        var cancelButton = jQuery("#cancelButton");
        cancelButton.hide();
        var userName = "${userName}";
        var userId = parseInt("${userId}");
        if (userName.length === 0) {
            util.login(false);
        }
        else {
            var startTime = parseInt("${product.startTime.getTime()}");
            var endTime = parseInt("${product.endTime.getTime()}");
            var productId = parseInt("${product.productId}");
            init(productId, startTime, endTime, userId);
        }
    });
</script>

</body>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<script type="text/javascript" src="/resources/script/detail.js"></script>

</html>
