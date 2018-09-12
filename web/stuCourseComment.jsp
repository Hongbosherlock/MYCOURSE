<%@ page import="Bean.comment" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.stuinfo" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:stuCourseComment.jsp
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
    List<comment> commentList=null;
    int courseNumber=0;
    if(request.getAttribute("commentList")==null){
        if(request.getParameter("courseNumber")!=null){
            courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        }
        else {
            courseNumber = Integer.parseInt((String) request.getAttribute("courseNumber"));
        }
%>
<jsp:include page="showCommentServlet">
    <jsp:param name="courseNumber" value="<%= courseNumber%>"/>
</jsp:include>
<%
    }
    commentList=(List<comment>)request.getAttribute("commentList");
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


            <a href=studentHome.jsp class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>


        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="stuCourseFile.jsp?courseNumber=${courseNumber}" ><i  ></i>课件</a>
                </li>

                <li>
                    <a href="stuCourseHomework.jsp?courseNumber=${courseNumber}"   ><i></i>作业</a>
                </li>
                <li>
                    <a href="stuCourseAnnouncement.jsp?courseNumber=${courseNumber}" ><i ></i>公告</a>

                </li>

                <li>
                    <a href="stuCourseVote.jsp?courseNumber=${courseNumber}"><i ></i>投票</a>
                </li>

                <li>
                    <a href="" class="active-menu"><i ></i>讨论</a>
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
                    <div class="panel-heading">课程讨论</div>
                    <div class="panel-body">

                        <div class="table-responsive">
                            <div class="panel panel-success">
                                <div class="panel-heading"></div>
                                <div class="panel-body" style="padding: 0px;">
                                    <div class="chat-widget-main">
                                        <% for (comment com :
                                                commentList) {

                                        %>
                                        <div class="chat-widget-left">
                                            <%= com.getContent()%>
                                        </div>
                                        <div class="chat-widget-name-left">
                                            <h4><%= com.getStuNumber()%></h4>
                                        </div>
                                        <% }%>
                                    </div>
                                </div>
                                <div class="panel-footer">
                                    <div class="input-group">
                                        <form action="createCommentServlet" method="post">
                                            <input type="text" name="content" class="form-control" placeholder="Enter Message" />
                                            <input type="hidden" name="courseNumber" value="${courseNumber}">
                                            <input type="hidden" name="number" value="<%=((stuinfo)request.getSession().getAttribute("student")).getStuNumber()%>">

                                            <span class="input-group-btn">
                                                  <button class="btn btn-success" type="submit">发送</button>
                                             </span>
                                        </form>
                                    </div>
                                </div>
                            </div>
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

