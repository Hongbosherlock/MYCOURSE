<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2018/5/30
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>errorPage</title>
</head>
<body>
<%= request.getAttribute("message")%>
<a href="login.html">重新登录</a>
</body>
</html>
