package CourseManager;

import Bean.courseinfo;
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
 * function:用于创建课程，将其插入数据库
 *          需提供 课程名 教师号 课程介绍
 *          通过request返回成功与否
 */
@WebServlet("/createCourseServlet")
public class createCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        courseinfo courseInfo=new courseinfo();

        courseInfo.setCourseName(request.getParameter("courseName"));
        courseInfo.setTeaNumber(((teainfo)(request.getSession().getAttribute("teacher"))).getTeaNumber());
        courseInfo.setIntroduction(request.getParameter("introduction")); //获取课程信息

        SQL sql=new SQL();
        boolean done=sql.InsertCourseInfo(courseInfo);                                     //将课程信息写入数据库

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("teacherHome.jsp");
        requestDispatcher.forward(request,response);                                //跳转到教师个人主页
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
