<%@ page import="Bean.courseinfo" %>
<%@ page import="Bean.teainfo" %>
<%@ page import="java.util.List" %>
<%@page import="SQLVisit.SQL" %>
<%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:teaSearchCourse.jsp
  ~ Date:18-6-3 下午9:40
  --%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    teainfo user= (teainfo)session.getAttribute("teacher");

    if (user==null){
        out.println("<script>alert('请先登陆');window.location.href='login.html'</script>");
        return;
    }
%>
<%

        List<courseinfo> courses=(List<courseinfo>)request.getAttribute("courses");
//        boolean flag  = (boolean) request.getSession().getAttribute("flag");
        pageContext.setAttribute("courses",courses);


%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>移动课堂-个人中心</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />


</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header" >
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="" style="font-size: 40px;">移动课堂</a>
        </div>

        <div class="header-right">


            <a href="logoutServlet" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>

        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="assets/img/user.png" class="img-thumbnail" />

                        <div class="inner-text">
                            <font size="4"><%= ((teainfo)request.getSession().getAttribute("teacher")).getName()%></font>老师您好！
                            <br />

                        </div>
                    </div>

                </li>


                <li>
                    <a class="active-menu" href="" ><i></i>课程搜索</a>
                </li>
                <li>

                    <a  href="teacherHome.jsp" ><i ></i>我的课程</a>

                </li>
                <li>
                    <a href="teacherComment.jsp"><i ></i>我的讨论 </a>

                </li>
                <li>
                    <a href="teacherInfo.jsp"><i ></i>个人信息</a>

                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">课程信息查询</h1>
                    <h1 class="page-subhead-line">这里，你将可以对所有课程进行查询搜索</h1>

                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-3">

                        <select class="form-control" id="first" onChange="change()" >
                            <option selected="selected">请选择专业分类</option>
                            <option>计算机</option>
                            <option>外语</option>
                            <option>艺术</option>
                            <option>建筑</option>
                            <option>医学</option>


                        </select>
                    </div>
                    <%--<div class="col-md-3">--%>
                        <%--<select id="second"  class="form-control">--%>
                            <%--<option selected="selected">请选择课程编号</option>--%>
                            <%--<option>0001</option>--%>
                            <%--<option>0002</option>--%>
                            <%--<option>0003</option>--%>
                            <%--<option>0004</option>--%>
                            <%--<option>0005</option>--%>

                        <%--</select>--%>
                    <%--</div>--%>
                    <div class="col-md-5">
                        <input class="form-control" placeholder="请输入课程名" type="text" name="word" id="word">
                    </div>
                    <div class="col-md-1">
                        <input class="form-control" type="button" value="搜索" onclick="search()" >
                        <input type="hidden" id="role" value="<%= (String)request.getSession().getAttribute("role")%>">
                    </div>
                </div>
            </div>
            </br>
            </hr>
            <div class="row">
                <div class="col-md-12">
                    <!--    Hover Rows  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            课程搜索记录
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>课程号</th>
                                        <th>课程名称</th>
                                        <th>上课教师</th>
                                        <th>课程简介</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        if(courses!=null)
                                        {
                                            SQL sql =new SQL();
                                        for(courseinfo cour:courses){
//                                        pageContext.setAttribute("cour",cour);
                                    %>
                                    <tr>
                                        <td><%= cour.getCourseNumber()%></td>
                                        <td><%= cour.getCourseName()%></td>
                                        <td><%= sql.SelectTeaNameByCourseNumber(cour.getCourseNumber())%></td>
                                        <td><%= cour.getIntroduction()%></td>
                                        <td> <p style="float: right;width: 300px;">

                                            <%--<button class="btn btn-primary" onclick="skip()"><i class="glyphicon glyphicon-search"></i>查看</button>--%>

                                            <%--<script>--%>
                                                <%--function skip()--%>
                                                <%--{--%>
                                                    <%--window.location.href="teaCourseAnnouncement.jsp";--%>
                                                <%--}--%>
                                            <%--</script>--%>

                                        </p></td>
                                    </tr>

                                    <%}
                                    }
                                    %>

                                    </tbody>
                                </table>
                            </div>
                            <ul class="pagination" style="float: right;">
                                <li class="disabled"><a href="#">&laquo;</a></li>
                                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>

                    </div>
                    <!-- End  Hover Rows  -->
                </div>
                <!-- /. ROW  -->


   </div>
        </div>


            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->

        <div id="footer-sec">
            移动课堂，让学习更轻松！
        </div>
        <!-- /. FOOTER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="assets/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="assets/js/bootstrap.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="assets/js/jquery.metisMenu.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="assets/js/custom.js"></script>
        <script src="assets/js/list.js"></script>

</body>
<script>
    function search() {

        var name = document.getElementById("word").value;
        var role = document.getElementById("role").value;
        if(name==="")
            alert("请输入内容！");
        else {
            var url = "searchCourseServlet?courseName=" + name+ "&role=" + role;
            window.location =url;
        }
    }
</script>
</html>
