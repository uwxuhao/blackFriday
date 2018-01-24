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
        <div class="panel-heading text-center">
            Product List
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
                    <tr>
                        <td>${product.productName}</td>
                        <td><fmt:formatDate value="${product.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${product.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${product.inventory}</td>
                        <td>${product.price}</td>
                        <td>
                            <a class="btn btn-info" href="/blackFriday/${product.productId}/detail" target="_blank">link</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>


</div>

</body>

<%-- JQuery --%>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<%-- BootStrap --%>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
