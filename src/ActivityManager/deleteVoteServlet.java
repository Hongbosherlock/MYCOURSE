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
 * function:用于删除投票，将其写入数据库
 *          需要 需要投票id
 *          通过request返回成功与否
 */
@WebServlet("/deleteVoteServlet")
public class deleteVoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int id=Integer.parseInt(request.getParameter("id"));
        int courseNumber = Integer.parseInt(request.getParameter("courseNumber"));

        SQL sql=new SQL();
        boolean done=sql.DeleteVote(id);

        if(done){
        request.setAttribute("courseNumber",courseNumber+"");
        request.getRequestDispatcher("teaCourseVote.jsp").forward(request,response); //跳转到显示投票信息的页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
