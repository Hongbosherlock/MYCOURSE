package FileManager;

import Bean.file;
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
 * function:用于更改课件信息，将其插入数据库
 *          需提供 课件id
 *          只能更改介绍
 *          通过request返回成功与否
 */
@WebServlet("/updateFileServlet")
public class updateFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        file fil=new file();

        fil.setId(Integer.parseInt(request.getParameter("id")));
        fil.setIntroduction(request.getParameter("introduction"));

        SQL sql=new SQL();
        boolean done=sql.UpdateFile(fil);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("teaCourseFile.jsp"); //返回教师课程主页，显示课件页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
