<%@ page import="Bean.courseinfo" %>
<%@ page import="Bean.stuinfo" %>
<%@ page import="SQLVisit.SQL" %>
<%@ page import="java.util.List" %><%--
  ~ Copyright (c) 2018
  ~ User:Hongb
  ~ File:studentHome.jsp
  ~ Date:2018/06/04 10:46:04
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Hongb
  Date: 2018/6/4
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    stuinfo user= (stuinfo)session.getAttribute("student");

    if (user==null){
        out.println("<script>alert('请先登陆');window.location.href='login.html'</script>");
        return;
    }
%>

<%

    if(request.getAttribute("courseList")==null){
        String stuNumber;

        stuNumber= ((stuinfo)request.getSession().getAttribute("student")).getStuNumber();

%>
<jsp:include page="stuSearchCourseServlet">
    <jsp:param name="stuNumber" value="<%=stuNumber%>"/>
</jsp:include>
<%
    }

    List<courseinfo> courseList=(List<courseinfo>)request.getAttribute("courseList");

    pageContext.setAttribute("courseList",courseList);
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
                            <font size="4"><%= ((stuinfo)request.getSession().getAttribute("student")).getName()%></font>同学您好！
                            <br />

                        </div>
                    </div>

                </li>


                <li>
                    <a href="stuSearchCourse.jsp" ><i  ></i>课程搜索</a>
                </li>

                <li>
                    <a href="" class="active-menu"><i></i>我的课程</a>
                </li>


                <li>
                    <a href="studentComment.jsp"><i ></i>我的讨论 </a>
                </li>
                <li>
                    <a href="studentInfo.jsp"><i ></i>个人信息 </a>

                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">我的课程</h1>
                    <h1 class="page-subhead-line">这里，你将可以查看已经参与学习的课程</h1>

                </div>
            </div>
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        正在学习
                        <div class="table-responsive">
                            <table width="99%" class="table table-hover">
                                <thead>
                                <tr>
                                    <th width="9%">课程号</th>
                                    <th width="10%">课程名称</th>
                                    <th width="8%">教师</th>
                                    <th width="11%">课程简介</th>
                                </tr>
                                </thead>
                                <tbody>

                                <%
                                    SQL sql =new SQL();
                                    for(courseinfo cour:courseList){
                                %>

                                <form action="">
                                <tr>
                                    <td><%= cour.getCourseNumber()%></td>
                                    <td><%= cour.getCourseName()%></td>
                                    <td><%=sql.SelectTeaNameByCourseNumber(cour.getCourseNumber())%></td>
                                    <td><%= cour.getIntroduction()%></td>
                                    <td> <p style="float: right;width: 300px;">
                                        <%--<input type="hidden" id="number" value="<%= cour.getCourseNumber()%>">--%>
                                        <%--<button class="btn btn-primary" onclick="skip()"><i class="glyphicon glyphicon-search"></i>查看</button>--%>
                                        <%--<button class="btn btn-primary" onclick="Delete()"><i class="glyphicon glyphicon-warning-sign"></i>退出</button>--%>
                                    <td><a href="stuCourseFile.jsp?courseNumber=<%=cour.getCourseNumber()%>" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>查看</a> </td>
                                    <td><a href="deleteSelect_courseServlet?courseNumber=<%=cour.getCourseNumber()%>" class="btn btn-danger"  onclick='return confirm("确定要退出吗?")'><i class="glyphicon glyphicon-warning-sign"></i>退出 </a></td>


                                </tr>
                                </form>
                                <%}
                                %>

                                </tbody>
                            </table>
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
                <!-- /. ROW  -->



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


</body>
</html>
