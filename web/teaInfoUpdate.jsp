<%@ page import="Bean.teainfo" %><%--
  ~ Copyright (c) 2018 All rights reserved
  ~ Author: LvFan
  ~ Project：MYCOURSE
  ~ File:teaInfoUpdate.jsp
  ~ Date:18-6-3 下午9:40
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Hongb
  Date: 2018/6/1
  Time: 20:51
  To change this template use File | Settings | File Templates.
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
    <title>信息更改</title>

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

            <%--<a href="../message-task.html" class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>--%>
            <%--<a href="../message-task.html" class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>--%>
            <a href="logoutServlet" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>


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
                            <%--<small>Last Login : 2 Weeks Ago </small>--%>
                        </div>
                    </div>

                </li>

            </ul>
        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">用户信息修改</h1>
                    <h1 class="page-subhead-line">在这里，你将对你的信息进行重新修改</h1>

                </div>
            </div>
            <!-- /. ROW  -->

            <table width="498" cellspacing="0">
                <tr>
                    <td width="139" height="32" class="tb_l">您的邮箱：</td>
                    <td width="247" class="tb_m emailContainer">
                        <input NAME="email" type="text" class="inputEmail" id="email" value="" maxlength="13" content="info"/>
                    </td>
                    <td width="104"></td>
                </tr>
                <tr>
                    <td height="40" class="tb_l">设置新密码：</td>
                    <td class="tb_m">
                        <input type="password" name="password" id="password"  content="info" autocomplete="off"/></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="72" class="tb_l">再输入一遍密码：</td>
                    <td class="tb_m"><input type="password" name="password2" id="password2" autocomplete="off" /></td>
                    <td></td>
                </tr>

            </table>
            <table width="499" cellspacing="0">

                <tr>
                    <td width="137" height="55" class="tb_l">您的姓名：</td>
                    <td width="356" class="tb_m"><input type="text" name="name" id="name" value="" /></td>
                </tr>
                <tr>
                    <td width="137" height="55" class="tb_l">您的性别：</td>
                    <td width="356" class="tb_m"><input type="text" name="sex" id="sex" value="" /></td>
                </tr>

                <tr>
                    <td height="57" class="tb_l">您的学院：</td>
                    <td class="tb_m"><input type="text" name="college" id="college" /></td>
                </tr>
                <tr>
                    <td height="64" class="tb_l">您所在学校：</td>
                    <td class="tb_m">
                        <input type="text" name="school" id="s_school" value="" autocomplete="off" />
                        <div class="school_search"></div>
                    </td>
                </tr>

            </table>
            <table cellspacing="0">
                <tr>
                    <td width="6" class="tb_l"></td>
                    <%--<input value="提交" class="btn btn-primary btn-lg"  type="button" onclick="register()">--%>
                    <input value="提交" class="btn btn-primary " style="font-size:20px" type="button" onclick="submit()">
                    <%--<td width="16" class="tb_r"><input type="hidden" name="im" value="student" /></td>--%>
                </tr>

            </table>
        </div>
        <!-- /. WRAPPER  -->      </div>
</div>

移动课堂

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

<script>
    function aaa() {
        alert("sdasd");

    }
    function submit() {
        // alert("asdsa");
        var userPassword = document.getElementById("password").value;
        var userSecondPassword=document.getElementById("password2").value;
        var userName=document.getElementById("name").value;
        var email=document.getElementById("email").value;
        var college=document.getElementById("college").value;
        var school=document.getElementById("s_school").value;
        var userGender=document.getElementById("sex").value;

        if(email===""){
            alert("邮箱不能为空");
            return;
        }
        if(userPassword===""){
            alert("用户密码不能为空");
            return;
        }
        if(userSecondPassword===""){
            alert("请再次输入密码");
            return;
        }
        if(userName===""){
            alert("请输姓名");
            return;
        }



        if(college===""){
            alert("学院不能为空");
            return;
        }

        if(school===""){
            alert("学校不能为空");
            return;
        }


        if(userPassword===userSecondPassword) {
            // var datetime = getNowFormatDate();
            var url = "updateTeaServlet?name=" + userName + "&sex=" + userGender + "&password=" + userPassword+"&email="+email+"&school="+school+"&college="+college;
            window.location = url;
            // alert(("！"))
        }else {
            alert("两次输入的密码不相同！请检查！");

        }



    }
</script>
</html>
