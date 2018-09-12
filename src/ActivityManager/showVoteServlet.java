package ActivityManager;


import Bean.vote;
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
@WebServlet("/showVoteServlet")
public class showVoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql=new SQL();
        List<vote> vo=sql.SelectVoteByCourse(courseNumber);
        String courseTeacher=sql.SelectTeaNameByCourseNumber(courseNumber);
        String courseName=sql.SelectCourseNameByCourseNumber(courseNumber);

        request.setAttribute("courseNumber",courseNumber);
        request.setAttribute("courseName",courseName);
        request.setAttribute("voteList",vo);
        request.setAttribute("courseTeacher",courseTeacher);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
