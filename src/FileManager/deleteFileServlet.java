/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:deleteFileServlet.java
 * Date:18-6-5 下午2:15
 */

package FileManager;

import SQLVisit.SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFileServlet")
public class deleteFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int courseNumber = Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql = new SQL();
        boolean done = sql.DeleteFile(id);

        request.setAttribute("courseNumber", courseNumber+"");
        if (done) {
            request.getRequestDispatcher("teaCourseFile.jsp").forward(request, response); //返回教师课程主页，显示公告信息的页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
