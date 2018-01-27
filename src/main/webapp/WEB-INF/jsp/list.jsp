<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>Black Friday Shopping</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading nav navbar-default">
            <div class="navbar-header">
                <img src="/resources/images/logo/blackFridayLogo.png">
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a class="btn btn-default" id="signUpButton"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
                </li>
                <li>&nbsp&nbsp</li>
                <li><a class="btn btn-default" id="loginButton"><span class="glyphicon glyphicon-log-in"></span>
                    Login</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Inventory</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${list}">
                    <tr class='clickable-row' data-href="/blackFriday/${product.productId}/detail" role="button">
                        <td>${product.productName}</td>
                        <td><fmt:formatDate value="${product.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${product.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${product.inventory}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="components/loginDialogue.jsp" %>

</body>

<%-- JQuery --%>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<%-- BootStrap --%>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/resources/script/list.js"></script>
<script type="text/javascript" src="/resources/script/utils.js"></script>

</html>
