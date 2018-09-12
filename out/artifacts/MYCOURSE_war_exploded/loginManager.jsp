<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2018/5/30
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginManager</title>
</head>
<body>
<%  String number=request.getParameter("number");
    String password=request.getParameter("password");
    String type=request.getParameter("type");

    if(type=="student"){
        request.setAttribute("stuNumber",number);
        request.setAttribute("password",password);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("loginStuServlet");
        requestDispatcher.forward(request,response);
    }
    else{
        request.setAttribute("teaNumber",number);
        request.setAttribute("password",password);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("loginTeaServlet");
        requestDispatcher.forward(request,response);
    }
%>
</body>
</html>
