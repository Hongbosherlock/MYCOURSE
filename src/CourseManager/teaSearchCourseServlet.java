/*
 * Copyright (c) 2018
 * User:Hongb
 * File:teaSearchCourseServlet.java
 * Date:2018/06/03 22:10:03
 */

package CourseManager;

import Bean.courseinfo;
import SQLVisit.SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * author:LvFan
 * function: 通过教师号搜索得到课程相关信息
 *          需要 教师号
 *          通过request返回课程信息列表
 */
@WebServlet("/teaSearchCourseServlet")
public class teaSearchCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String teaNumber = request.getParameter("teaNumber");
//        System.out.println("教师号："+teaNumber);
        SQL sql=new SQL();
        List<courseinfo> courses=sql.SelectCoursesByTeaNumber(teaNumber);

        request.setAttribute("courseList",courses);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
