/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:loginTeaServlet.java
 * Date:18-6-3 下午9:23
 */

package Teacher;

import Bean.teainfo;
import SQLVisit.SQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author:LvFan
 * function:用于教师登录
 *          需提供 教师号 密码
 *          若失败则跳转到登录界面
 */
@WebServlet("/loginTeaServlet")
public class loginTeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        SQL sql=new SQL();
        teainfo teacher=sql.getTeaInfo(request.getParameter("teaNumber"),request.getParameter("password"));
        if(teacher==null) {
            request.setAttribute("message", "帐号不存在或者密码不正确！");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorPage.jsp");
            requestDispatcher.forward(request, response);

        }else{
            String role = "teacher";
            request.getSession().setAttribute("role",role);
            request.getSession().setAttribute("teacher",teacher);  //将教师信息加入到session域中
            response.sendRedirect("teacherHome.jsp");             //重定向到教师主页
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
