package HomeworkManger;

import Bean.homework;
import SQLVisit.SQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * author:LvFan
 *function:通过课程号搜索得到相关作业信息
 *          需要课程号
 *          通过request返回作业信息列表
 */
@WebServlet("/showHomeworkServlet")
public class showHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql=new SQL();
        List<homework> hks=sql.SelectHomeworkByCourse(courseNumber);
        String courseName=sql.SelectCourseNameByCourseNumber(courseNumber);

        request.setAttribute("homeworkList",hks);
        request.setAttribute("courseName",courseName);

        String courseTeacher=sql.SelectTeaNameByCourseNumber(courseNumber);
        request.setAttribute("courseTeacher",courseTeacher);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
