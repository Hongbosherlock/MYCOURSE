/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:searchCourseServlet.java
 * Date:18-6-5 下午3:49
 */

package CourseManager;

import Bean.courseinfo;
import SQLVisit.SQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * author:LvFan
 * function:用于根据课程名搜索课程
 *          需要 课程名
 *          可以通过request返回课程列表
 */
@WebServlet("/searchCourseServlet")
public class searchCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String role = request.getParameter("role");
        String courseName=request.getParameter("courseName");

        SQL sql=new SQL();
        List<courseinfo> courses=sql.SelectCoursesByCourseName(courseName);
        request.setAttribute("courses",courses);
//        request.setAttribute("flag",flag);
        if(role.equals("teacher")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("teaSearchCourse.jsp");   //返回搜索结果页
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("stuSearchCourse.jsp");   //返回搜索结果页
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
