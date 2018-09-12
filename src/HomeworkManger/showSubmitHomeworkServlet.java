/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:showSubmitHomeworkServlet.java
 * Date:18-6-4 上午9:42
 */

package HomeworkManger;

import Bean.submit_homework;
import SQLVisit.SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showSubmitHomeworkServlet")
public class showSubmitHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int homework_id=Integer.parseInt(request.getParameter("id"));

        SQL sql=new SQL();
        List<submit_homework> submit_homeworkList=sql.SelectSubmitByHomeworkId(homework_id);

        request.setAttribute("submit_homeworkList",submit_homeworkList);
        request.getRequestDispatcher("showSubmit_homework.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
