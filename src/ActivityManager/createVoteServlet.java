package ActivityManager;

import Bean.vote;
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
 * function:用于创建投票，将其插入数据库
 *          需要 内容 结果 截止时间 课程号 四个参数
 *          通过request返回成功与否
 */
@WebServlet("/createVoteServlet")
public class createVoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        vote vo=new vote();
        String content=request.getParameter("content");
        vo.setContent(content);           //获得内容

        String[] selectItems=request.getParameter("selectItems").split("%");
        String result="";                                            //将选项转换为结果
        for(String item:selectItems){
            result=result+item+":0"+"%";
        }

        vo.setResult(result);
        vo.setEnd_date(request.getParameter("end_date"));         //获得截止时间
        boolean done=true;
        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));
        vo.setCourseNumber(courseNumber);  //获得课程号
        if((!content.equals(""))&&(!result.equals(""))) {
            SQL sql = new SQL();
            done = sql.InsertVote(vo);
        }
        if(done) {
            request.setAttribute("courseNumber",courseNumber);
            if(request.getSession().getAttribute("teacher")!=null) {
                request.getRequestDispatcher("teaCourseVote.jsp").forward(request, response); //跳转到教师显示投票信息的页面
            }
            else{
                request.getRequestDispatcher("stuCourseVote.jsp").forward(request,response);  //跳转到学生显示投票信息的页面
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
