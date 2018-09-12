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
import java.util.List;
/**
 * author:LvFan
 * function:通过课程号搜索得到相关文件信息
 *          需要课程号
 *          通过request返回文件信息列表
 */
@WebServlet("/showFileServlet")
public class showFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));

        SQL sql=new SQL();
        List<file> files=sql.SelectFileByCourse(courseNumber);
        String courseName=sql.SelectCourseNameByCourseNumber(courseNumber);
        String courseTeacher=sql.SelectTeaNameByCourseNumber(courseNumber);

        request.setAttribute("courseTeacher",courseTeacher);
        request.setAttribute("fileList",files);
        request.setAttribute("courseName",courseName);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
