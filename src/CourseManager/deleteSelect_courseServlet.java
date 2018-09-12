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
 * function:用于学生退出选课，将其插入数据库
 *          需提供 学号 课程号
 *          通过request返回成功与否
 */
@WebServlet("/deleteSelect_courseServlet")
public class deleteSelect_courseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        String stuNumber;
        stuNumber = ((stuinfo)request.getSession().getAttribute("student")).getStuNumber();

        SQL sql=new SQL();
        boolean done=sql.DeleteSelect_course(courseNumber,stuNumber);

            request.setAttribute("done",done);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentHome.jsp"); //返回学生个人主页，显示课程信息页
            requestDispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
