/*
 * Copyright (c) 2018
 * User:Hongb
 * File:updateStuServlet.java
 * Date:2018/05/28 08:46:28
 */

package Student;

import Bean.stuinfo;
import SQLVisit.SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hongb on 2018/5/28.
 */
@WebServlet("/updateStuServlet")
public class updateStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        stuinfo stu = new stuinfo();
        stu.setName(request.getParameter("name"));
        stu.setStuNumber(((stuinfo)request.getSession().getAttribute("student")).getStuNumber());
        stu.setSex(request.getParameter("sex"));
        stu.setPassword(request.getParameter("password"));
        stu.setEmail(request.getParameter("email"));
        stu.setSchool(request.getParameter("school"));
        stu.setCollege(request.getParameter("college"));

//      访问数据库
        SQL sql =new SQL();
        sql.UpdateStuInfo(stu);
        request.getSession().setAttribute("student",stu);                          //更新session中"student"的值
        response.sendRedirect("studentInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
