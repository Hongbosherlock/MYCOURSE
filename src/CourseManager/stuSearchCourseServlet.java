package CourseManager;

import Bean.courseinfo;
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
 * function: 通过学号搜索得到课程相关信息
 *          需要 学号
 *          通过request返回课程信息列表
*/
@WebServlet("/stuSearchCourseServlet")
public class stuSearchCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String stuNumber=request.getParameter("stuNumber");
        SQL sql=new SQL();
        List<courseinfo> courses=sql.SelectCoursesByStuNumber(stuNumber);

        request.setAttribute("courseList",courses);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentHome.jsp");   //返回学生主页！！！
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
