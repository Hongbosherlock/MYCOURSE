<%@ page import="Bean.file" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.teainfo" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:teaCourseFile.jsp
  ~ Date:18-6-3 下午1:41
  --%>

<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2018/6/1
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>



    <%--if(request.getParameter("courseNumber")==null){--%>
        <%--out.println("<script>alert('请先登陆');window.location.href='login.html'</script>");--%>
        <%--return;--%>
    <%--}--%>
<%--%>--%>

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

    pageContext.setAttribute("courseNumber",courseNumber);
    pageContext.setAttribute("courseName",courseName);

%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>移动课堂-教师课程中心</title>

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


            <a href="teacherHome.jsp" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>


        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href=""  class="active-menu"><i  ></i>课件</a>
                </li>

                <li>
                    <a href="teaCourseHomework.jsp?courseNumber=${courseNumber}" ><i></i>作业</a>
                </li>
                <li>
                    <a href="teaCourseAnnouncement.jsp?courseNumber=${courseNumber}"><i ></i>公告</a>

                </li>

                <li>
                    <a href="teaCourseVote.jsp?courseNumber=${courseNumber}"><i ></i>投票</a>
                </li>
                <li>
                    <a href="teaCourseComment.jsp?courseNumber=${courseNumber}"><i ></i>讨论</a>

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
                    <h1 class="page-subhead-line">任课教师：<%= ((teainfo)request.getSession().getAttribute("teacher")).getName()%></h1>

                    <div class="col-md-12">
                        <!--    Hover Rows  -->
                        <div class="panel panel-default">
                            <div class="panel-heading">上传课件</div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table width="86%" height="274" class="table table-hover">
                                        <form  method="post" enctype="multipart/form-data"  action="uploadFileServlet">
                                            <thead>
                                            <tr>
                                                <td>介绍：</td>
                                                <td>选择文件：</td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" name="introduction" id="textfield"></td>
                                                <td><input type="file" name="fileField" id="fileField"></td>
                                                <td><input type="hidden" name="courseNumber" value="${courseNumber}"></td>
                                                <td><input type="submit" name="button5" id="button" value="发布" onclick="success()"></td>
                                            </tr>
                                            </thead>
                                        </form>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- End  Hover Rows  -->
                    </div>

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
                                    <th width="20%">课件号</th>
                                    <th width="25%">课件名</th>
                                    <th width="16%">简介</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%
                                    if(fileList!=null){
                                    for (file fil:fileList
                                        ) {
                                   %>
                                <tr>
                                    <td><%= fil.getId()%></td>
                                    <td><%= fil.getFile_path().substring(fil.getFile_path().lastIndexOf("\\")+1)%></td>
                                    <td><%= fil.getIntroduction()%></td>
                                    <form action="deleteFileServlet" method="post">
                                    <td><input type="hidden" name="id" value="<%= fil.getId()%>">
                                    <input type="hidden" name="courseNumber" value="${courseNumber}">
                                    <input type="submit" value="删除课件" onclick="deleteDone()"></td>
                                    </form>
                                </tr>
                                <% }
                                }
                                %>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
                <!-- End  Hover Rows  -->
            </div>


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
<script language="JavaScript">
    function success(){
        alert("上传课件成功！");
    }
    function deleteDone() {
        alert("删除课件成功！");
    }
</script>

</body>
</html>

