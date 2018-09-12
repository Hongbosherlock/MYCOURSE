<%@ page import="java.util.List" %>
<%@ page import="Bean.submit_homework" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:showSshowSubmit_homework.jsp
  ~ Date:18-6-4 上午10:38
  --%>

<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2018/6/4
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>submit_homework</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body>

    <div class="col-md-12">
        <!--    Hover Rows  -->
        <div class="panel panel-default">
            <div class="panel-heading">作业提交情况</div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table width="86%" height="60" class="table table-hover">
                            <thead>
                            <tr>
                                <td>学号</td>
                                <td>点击下载</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<submit_homework> submit_homeworkList=(List<submit_homework>)request.getAttribute("submit_homeworkList");
                                for (submit_homework sh :
                                        submit_homeworkList) {
                            %>
                            <form action="downloadServlet" method="post">
                                <tr>
                                    <td><%= sh.getStuNmuber()%></td>
                                    <td>
                                        <input type="hidden" name="path" value="<%= sh.getPath()%>">
                                        <input type="submit" value="下载"></td>
                                </tr>
                            </form>
                            <% }
                            %>
                            </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- End  Hover Rows  -->
    </div>
</body>
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>
</html>
