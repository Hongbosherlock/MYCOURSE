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
/**
 * author:LvFan
 * function:用于修改课程信息，将其插入数据库
 *          需要 课程号
 *          可修改 课程名 课程介绍
 *          通过request返回成功与否
 */
@WebServlet("/updateCourseServlet")
public class updateCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        courseinfo courseInfo=new courseinfo();
        courseInfo.setCourseNumber(Integer.parseInt(request.getParameter("id")));
        courseInfo.setCourseName(request.getParameter("courseName"));
        courseInfo.setIntroduction(request.getParameter("introduction")); //获取课程信息

        SQL sql=new SQL();
        boolean done=sql.UpdateCourseInfo(courseInfo);                                     //将课程信息写入数据库

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(".jsp"); //返回教师课程主页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
