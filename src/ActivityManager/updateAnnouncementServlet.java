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
/**
 * author:LvFan
 * function:用于更改公告信息，将其插入数据库
 *          需提供 公告id
 *          只能更改公告 内容
 *          通过request返回成功与否
 *
 *          禁用！！！
 *
 */
@WebServlet("/updateAnnouncementServlet")
public class updateAnnouncementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        announcement ant=new announcement();
        ant.setId(Integer.parseInt(request.getParameter("id")));
        ant.setContent(request.getParameter("content"));

        SQL sql=new SQL();
        boolean done=sql.UpdateAnnouncement(ant);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(".jsp"); //返回教师课程主页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
