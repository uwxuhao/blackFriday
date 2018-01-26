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

<div id="loginModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    Please Login
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="userName" id="userNameInput"
                               placeholder="User Name" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="password" id="passwordInput"
                               placeholder="Password" class="form-control">
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <span id="loginMessage" class="glyphicon"></span>
                <button type="button" id="submitButton" class="btn  btn-default">
                    <span class="glyphicon glyphicon-user"></span> Submit
                </button>
            </div>

        </div>
    </div>

</div>

</body>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
