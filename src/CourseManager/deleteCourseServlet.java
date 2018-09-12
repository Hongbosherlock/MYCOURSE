package CourseManager;

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
 * function:用于删除课程，将其插入数据库
 *          需要 课程号
 *          通过request返回成功与否
 */
@WebServlet("/deleteCourseServlet")
public class deleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("courseNumber"));

        SQL sql=new SQL();
        boolean done=sql.DeleteCourseInfo(id);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("teacherHome.jsp"); //返回教师个人主页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
