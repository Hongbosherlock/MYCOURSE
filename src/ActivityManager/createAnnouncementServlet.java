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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:LvFan
 * function:用于创建公告，将其插入数据库
 *          需要 创建时间 内容 课程号 三个参数
 *          通过request返回成功与否
 */
@WebServlet("/createAnnouncementServlet")
public class createAnnouncementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String s_date=sdf.format(date);                                             //获得相应时间
        int courseNumber=Integer.parseInt(request.getParameter("courseNumber")); //得到课程号
        String content=request.getParameter("content");
        boolean done=true;

        announcement ant = new announcement();
        ant.setDate(s_date);
        ant.setContent(content);                         //得到公告内容
        ant.setCourseNumber(courseNumber);
        if(!content.equals("")) {
            SQL sql = new SQL();

            done = sql.InsertAnnouncement(ant);
        }
        if (done) {
            request.setAttribute("courseNumber", courseNumber);                      //返回课程号
            request.getRequestDispatcher("teaCourseAnnouncement.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
