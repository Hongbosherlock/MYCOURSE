package CourseManager;

import Bean.stuinfo;
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
 * function:处理学生选课信息，将其插入数据库
 *          需要 课程号、学号
 *          通过request返回成功与否
 */
@WebServlet("/select_courseServlet")
public class select_courseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String stuNumber;
        stuNumber = ((stuinfo)request.getSession().getAttribute("student")).getStuNumber();
        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        SQL sql=new SQL();
        boolean done=sql.InsertSelect_course(courseNumber,stuNumber);

        request.setAttribute("done",done);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentHome.jsp"); //返回学生个人主页
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
