package ActivityManager;

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
 * function:用于删除公告，将其写入数据库
 *          需要 公告id
 *          通过request返回成功与否
 */
@WebServlet("/deleteAnnouncementServlet")
public class deleteAnnouncementServlet extends HttpServlet {
    /**
     * 用于删除公告，需要公告id*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int courseNumber = Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql = new SQL();
        boolean done = sql.DeleteAnnouncement(id);

        request.setAttribute("courseNumber", courseNumber+"");
        if (done) {
            request.getRequestDispatcher("teaCourseAnnouncement.jsp").forward(request, response); //返回教师课程主页，显示公告信息的页面
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
