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
 * function:用于删除评论，将其插入数据库
 *          需要 评论id
 *          通过request返回成功与否
 */
@WebServlet("/deleteCommentServlet")
public class deleteCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));

        SQL sql=new SQL();
        boolean done=sql.DeleteComment(id);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(".jsp"); //返回...主页，显示评论信息的页面
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
