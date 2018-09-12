package ActivityManager;

import Bean.comment;
import SQLVisit.SQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:LvFan
 * function:用于创建评论，将其插入数据库
 *          需要 学号 时间 内容 课程号 四个参数
 *          通过request返回成功与否
 */
@WebServlet("/createCommentServlet")
public class createCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        comment com=new comment();
        String number=request.getParameter("number");
        com.setStuNumber(number);                       //获得教师号或者学生号

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String s_date=sdf.format(date);                                             //获得相应时间

        com.setDate(s_date);
        com.setContent(request.getParameter("content"));                           //获得内容

        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));  //获得课程号
        com.setCourseNumber(courseNumber);

        SQL sql=new SQL();
        boolean done=sql.InsertComment(com);

        request.setAttribute("courseNumber",courseNumber);
        if(done) {
            if(sql.stuNumberExist(number)) {
                request.getRequestDispatcher("stuCourseComment.jsp").forward(request, response); //跳转到学生显示评论信息的页面
            }
            else{
                request.getRequestDispatcher("teaCourseComment.jsp").forward(request,response);//跳转到教师显示评论信息的页面
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
