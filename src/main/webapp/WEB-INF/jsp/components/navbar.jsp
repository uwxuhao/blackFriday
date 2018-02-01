<div class="panel-heading nav navbar-default">
    <div class="navbar-header">
        <img src="/resources/images/logo/blackFridayLogo.png">
    </div>

    <ul class="nav navbar-nav navbar-right">
        <c:choose>
            <c:when test="${empty userName}">
                <li>
                    <a class="btn btn-default" id="signUpButton">
                        <span class="glyphicon glyphicon-user"></span>
                        Sign Up
                    </a>
                </li>
                <li>&nbsp&nbsp</li>
                <li>
                    <a class="btn btn-default" id="loginButton">
                        <span class="glyphicon glyphicon-log-in"></span>
                        Login
                    </a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="#">${userName}</a>
                </li>
                <li>
                    <a href="#">Order</a>
                </li>
                <li>
                    <a href="#">Cart</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>