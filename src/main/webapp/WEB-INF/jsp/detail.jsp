<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>${product.productName}</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel-heading text-center display-3">
        <h1>${product.productName}</h1>
    </div>
    <div class="panel-body">
        <h2 class="text-danger">
            <span class="glyphicon glyphicon-time"></span>
            <span class="glyphicon" id="countdown-box">placeholder</span>
        </h2>
    </div>
</div>


<%@include file="components/loginDialogue.jsp" %>

<%
    HttpSession httpSession = request.getSession(false);
    String userName = (String) httpSession.getAttribute("userName");
    System.out.println(userName);
%>

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/script/utils.js"></script>

<script type="text/javascript">
    $(window).on("load", function () {
        var cancelButton = $("#cancelButton");
        cancelButton.hide();
        var login = "${userName}";
        console.log(login.length);
        if (login.length === 0) {
            util.login(false);
        }
    });
</script>

</body>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<script type="text/javascript" src="/resources/script/detail.js"></script>

</html>
