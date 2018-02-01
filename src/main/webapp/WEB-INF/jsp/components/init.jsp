<%
    HttpSession httpSession = request.getSession(false);
    String userName = (String) httpSession.getAttribute("userName");
%>