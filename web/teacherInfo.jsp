<%@ page import="Bean.teainfo" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:teacherInfo.jsp
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
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
        <div class="navbar-header">
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
                    <a href ="teaSearchCourse.jsp" >课程搜索</a>
                </li>

                <li>
                    <a  href="teacherHome.jsp"  >我的课程</a>
                </li>

                <li>
                    <a href="teacherComment.jsp">我的讨论 </a>
                </li>
                <li>
                    <a class="active-menu" href="">个人信息 </a>

                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">个人信息设置</h1>
                    <h1 class="page-subhead-line">这里，你将可以对个人的信息进行修改</h1>

                </div>
            </div>
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        用户信息资料

                        <div class="panel-body">

                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div  class="row pad-top-botm client-info">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <h4> <strong>个人信息</strong></h4>
                            <b>姓名：<strong><%= ((teainfo)request.getSession().getAttribute("teacher")).getName()%></strong></b> <br />
                            <b>School :</b> <%= ((teainfo)request.getSession().getAttribute("teacher")).getSchool()%> <br />
                            <b>学院 :</b> <%= ((teainfo)request.getSession().getAttribute("teacher")).getCollege()%><br />
                            <b>E-mail :</b> <%= ((teainfo)request.getSession().getAttribute("teacher")).getEmail()%>  </div>
                        <div class="col-lg-6 col-md-6 col-sm-6"> </div>
                        <!-- /. ROW  -->
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>

                        <br>
                        <br>

                        <div class="row pad-top-botm">
                            <div class="col-lg-12 col-md-12 col-sm-12">

                                <a href="teaInfoUpdate.jsp" class="btn btn-primary btn-lg" >个人信息修改</a>
                                <p>&nbsp;</p>
                                <%--<a href="#" class="btn btn-primary btn-lg" >删除用户</a>--%>
                            </div>
                        </div>



                    </div>

                </div>


            </div>
        </div>
    </div>
            <!-- /. PAGE INNER  -->
        </div>


<div id="footer-sec">
        移动课堂网
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
