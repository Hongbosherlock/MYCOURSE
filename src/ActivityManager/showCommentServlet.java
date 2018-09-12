package ActivityManager;

import Bean.comment;
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
 * 根据课程号搜索投票信息
 * 需要提供课程号，返回投票信息列表
 * */
@WebServlet("/showCommentServlet")
public class showCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));

        SQL sql=new SQL();
        List<comment> com=sql.SelectCommentByCourse(courseNumber);
        String courseName=sql.SelectCourseNameByCourseNumber(courseNumber);


        request.setAttribute("commentList",com);
        request.setAttribute("courseNumber",courseNumber);
        request.setAttribute("courseName",courseName);

        String courseTeacher=sql.SelectTeaNameByCourseNumber(courseNumber);
        request.setAttribute("courseTeacher",courseTeacher);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
