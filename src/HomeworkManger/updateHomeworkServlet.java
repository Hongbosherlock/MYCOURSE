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
/**
 * author:LvFan
 * function:用于更改作业信息，将其插入数据库
 *          需提供 作业id
 *          只能更改作业 截止时间、介绍
 *          通过request返回成功与否
 */
@WebServlet("/updateHomeworkServlet")
public class updateHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        homework hk=new homework();
        hk.setId(Integer.parseInt(request.getParameter("id")));
        hk.setEnd_date(request.getParameter("end_date"));
        hk.setIntroduction(request.getParameter("introduction"));

        SQL sql=new SQL();
        boolean done=sql.UpdateHomework(hk);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(".jsp"); //返回教师课程主页，显示作业页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
