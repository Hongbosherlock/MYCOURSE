<%@ page import="Bean.file" %>
<%@ page import="java.util.List" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:stuCourseFile.jsp
  ~ Date:18-6-3 下午3:05
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%



    if(request.getParameter("courseNumber")==null){
        out.println("<script>alert('请先登陆');window.location.href='login.html'</script>");
        return;
    }
%>
<%
    List<file> fileList=null;
    int courseNumber=0;
    if(request.getAttribute("fileList")==null){
        if(request.getParameter("courseNumber")!=null){
            courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        }
        else {
            courseNumber = Integer.parseInt((String) request.getAttribute("courseNumber"));
        }
%>
<jsp:include page="showFileServlet">
    <jsp:param name="courseNumber" value="<%= courseNumber%>"/>
</jsp:include>
<%
    }

    fileList=(List<file>)request.getAttribute("fileList");
    String courseName=(String)request.getAttribute("courseName");
    String courseTeacher=(String)request.getAttribute("courseTeacher");

    pageContext.setAttribute("courseTeacher",courseTeacher);
    pageContext.setAttribute("courseNumber",courseNumber);
    pageContext.setAttribute("courseName",courseName);

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
    <style type="text/css">
        .create {
            float: right;
            height: 40px;
            width: 60px;
            margin-top: 2px;
            margin-right: 1px;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="" style="font-size: 40px;">课程中心</a>
        </div>

        <div class="header-right">


            <a href="studentHome.jsp" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>


        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="" class="active-menu"><i  ></i>课件</a>
                </li>

                <li>
                    <a href="stuCourseHomework.jsp?courseNumber=${courseNumber}" ><i></i>作业</a>
                </li>
                <li>
                    <a href="stuCourseAnnouncement.jsp?courseNumber=${courseNumber}"><i ></i>公告</a>

                </li>

                <li>
                    <a href="stuCourseVote.jsp?courseNumber=${courseNumber}"><i ></i>投票</a>
                </li>
                <li>
                    <a href="stuCourseComment.jsp?courseNumber=${courseNumber}"><i ></i>讨论</a>

                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">${courseName}</h1>
                    <div class="active-menu" ></div>
                    <h1 class="page-subhead-line">任课教师：${courseTeacher}</h1>


                </div>
            </div>
            <div class="col-md-12">
                <!--    Hover Rows  -->
                <div class="panel panel-default">
                    <div class="panel-heading"> 课件区</div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table width="82%" class="table table-hover">
                                <thead>
                                <tr>
                                    <th width="10%">课件号</th>
                                    <th width="20%">课件名</th>
                                    <th width="40%">简介</th>
                                    <th width="15">发布时间</th>
                                    <th width="15%">&nbsp;</th>
                                </tr>
                                </thead>
                                <tbody>
                                <% for (file fil :
                                        fileList) {

                                %>
                                <form action="downloadServlet" method="post">
                                <tr>
                                    <td><%= fil.getId()%></td>
                                    <td><%= fil.getFile_path().substring(fil.getFile_path().lastIndexOf("\\")+1)%></td>
                                    <td><%= fil.getIntroduction()%></td>
                                    <td><%= fil.getDate()%></td>
                                    <td ><input name="button" type="submit" class="progress-bar-info"  value="下载"></td>
                                    <td ><input type="hidden" name="path" value="<%= fil.getFile_path()%>"></td>
                                    <td ><input type="hidden" name="courseNumber" value="${courseNumber}"> </td>
                                </tr>
                                </form>

                                <% }%>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- End  Hover Rows  -->
            </div>


        </div>



    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<div id="footer-sec">
    &copy; 移动课堂，让学习更轻松。
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


</body>
</html>
