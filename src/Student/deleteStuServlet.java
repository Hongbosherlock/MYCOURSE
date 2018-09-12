/*
 * Copyright (c) 2018
 * User:Hongb
 * File:deleteStuServletAction.java
 * Date:2017/05/24 22:29:24
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
 * Created by Hongb on 2018/5/26.
 */

@WebServlet("/deleteStuServlet")
public class deleteStuServlet extends HttpServlet {
    public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        request.setCharacterEncoding("UTF-8");
        stuinfo stu = new stuinfo();
        stu.setStuNumber(request.getParameter("stunum"));
        SQL sql = new SQL();
        sql.DeleteStuInfo(stu.getStuNumber());
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        doPost(request,response);
    }
}
