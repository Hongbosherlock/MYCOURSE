package Teacher;

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
 * function:用于删除教师信息，将其写入数据库
 *          需提供 教师号
 *          通过request返回成功与否
 *
 *          禁用此功能！！！
 */
@WebServlet("/deleteTeaServlet")
public class deleteTeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String teaNumber=request.getParameter("teaNumber");
        SQL sql=new SQL();
        boolean done=sql.DeleteTeaInfo(teaNumber);

        request.setAttribute("done",done);             //返回删除成功与否
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.html"); //返回登录页面
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
