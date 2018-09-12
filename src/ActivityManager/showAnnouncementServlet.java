package ActivityManager;

import Bean.announcement;
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
 * 根据课程号搜索公告信息
 * 需要提供课程号，返回公告信息列表
 * */
@WebServlet("/showAnnouncementServlet")
public class showAnnouncementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql=new SQL();
        List<announcement> ant=sql.SelectAnnouncementByCourse(courseNumber);       //得到相应课程的公告信息列表
        String courseName=sql.SelectCourseNameByCourseNumber(courseNumber);        //得到相应课程的课程名称
        String courseTeacher=sql.SelectTeaNameByCourseNumber(courseNumber);

        request.setAttribute("announcementList",ant);
        request.setAttribute("courseName",courseName);
        request.setAttribute("courseNumber",courseNumber);   //返回公告列表、课程名、课程号
        request.setAttribute("courseTeacher",courseTeacher);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
