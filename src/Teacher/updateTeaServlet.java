/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:updateTeaServlet.java
 * Date:18-6-3 下午9:52
 */

package Teacher;

import Bean.teainfo;
import SQLVisit.SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * author:LvFan
 * function:用于修改教师信息，将其插入数据库
 *          需提供 教师号
 *          可更改 名字 性别 密码 邮箱 学校 学院
 *          通过request返回成功与否
 */
@WebServlet("/updateTeaServlet")
public class updateTeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        teainfo ti=new teainfo();
        ti.setName(request.getParameter("name"));
        ti.setTeaNumber(((teainfo)request.getSession().getAttribute("teacher")).getTeaNumber());
        ti.setSex(request.getParameter("sex"));
        ti.setPassword(request.getParameter("password"));
        ti.setEmail(request.getParameter("email"));
        ti.setSchool(request.getParameter("school"));
        ti.setCollege(request.getParameter("college"));

        SQL sql=new SQL();
        boolean done=sql.UpdateTeaInfo(ti);
        request.setAttribute("done",done);

        request.getSession().setAttribute("teacher",ti);                          //更新session中"teacher"的值
        response.sendRedirect("teacherInfo.jsp");
//        RequestDispatcher requestDispatcher=request.getRequestDispatcher("teacherHome/teacherInfo.jsp"); //返回教师个人主页，个人信息页
//        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
