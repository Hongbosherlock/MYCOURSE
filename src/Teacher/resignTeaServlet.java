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
 * function:用于教师注册，将其插入数据库
 *          需提供 名字 教师号 性别 密码 邮箱 学校 学院
 *          通过request返回成功与否
 */
@WebServlet("/resignTeaServlet")
public class resignTeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        teainfo ti=new teainfo();
        ti.setName(request.getParameter("name"));
        ti.setTeaNumber(request.getParameter("teaNumber"));
        String sex = request.getParameter("sex").equals("1") ?"男":"女";
        ti.setSex(sex);
        ti.setPassword(request.getParameter("password"));
        ti.setEmail(request.getParameter("email"));
        ti.setSchool(request.getParameter("school"));
        ti.setCollege(request.getParameter("college"));

//        System.out.println("教师性别:"+ti.getSex());
        SQL sql=new SQL();
        boolean done=sql.InsertTeaInfo(ti);

        if(done) {
            response.sendRedirect("login.html");
        }
        else{
            request.setAttribute("message","注册失败，可能是教师号已存在！");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
