<%@ page import="Bean.teainfo" %>
<%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:teacherComment.jsp
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

              
                <a href="login.html" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>


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
                        <a href="teaSearchCourse.jsp" ><i  ></i>课程搜索</a>
                    </li>
                    
                            <li>
                                <a  href="teacherHome.jsp" ><i ></i>我的课程</a>
                            </li>
                           
                     <li>
                        <a class="active-menu" href=""><i ></i>我的讨论 </a>
                     </li>
                    <li>
                        <a href="teacherInfo.jsp"><i ></i>个人信息 </a>
                        
                    </li>
                    
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">我的讨论</h1>
                        <h1 class="page-subhead-line">这里，你将可以对本站内自己参与的提问和回答</h1>

                    </div>
                </div>
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	我的讨论记录
                            	<table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>日期</th>
                                            <th>课程名称</th>
                                        
                                            <th>回帖数</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>2016/1/3</td>
                                            <td>计算机组成原理</td>
                                            <td>0</td>
                                            
                                            <td> <p style="float: right;width: 300px;">
                                   
                                    <button class="btn btn-primary" onclick="skip()"><i class="glyphicon glyphicon-search"></i>查看</button>
                                    <script>
                                    	function skip()
											{
											    window.location.href="";
											}
                                    </script>
                                   
                                </p></td>
                                        </tr>
                                       
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
        		移动课堂
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
