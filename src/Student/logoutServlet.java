/*
 * Copyright (c) 2018
 * User:Hongb
 * File:logoutServletAction.java
 * Date:2017/05/22 19:41:22
 */

package Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created by Hongb on 2018/5/26.
 */

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession(false);
        if(session==null){
            response.sendRedirect("login.html");
            return;
        }
        session.invalidate();
        response.sendRedirect("login.html");
    }
}