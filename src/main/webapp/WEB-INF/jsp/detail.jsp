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


</body>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
</html>
