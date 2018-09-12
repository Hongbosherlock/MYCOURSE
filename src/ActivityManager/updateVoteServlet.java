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
 * function:用于更改投票信息
 *          只能更改 内容 结果 截止时间
 *          需提供 投票id
 *
 *          */
@WebServlet("/updateVoteServlet")
public class updateVoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        vote vo=new vote();
        vo.setId(Integer.parseInt(request.getParameter("id")));
        vo.setContent(request.getParameter("content"));
        vo.setEnd_date(request.getParameter("end_date"));                //获得投票id、主题、截止时间

        String item=request.getParameter("item");                        //获得需要更新的 选项 及其 票数
        int number=Integer.parseInt(request.getParameter("number"));
        String[] preResult=request.getParameter("result").split("%");

        String result="";                                                   //更新投票情况
        for (String i:preResult
             ) {
            String[] subItem=i.split(":");
            if(subItem[0].equals(item)){
                result=result.concat(subItem[0]+":"+(Integer.parseInt(subItem[1])+1)+"%");
            }
            else{
                result=result.concat(i.concat("%"));
            }
        }
        
        vo.setResult(result);
        int courseNumber=Integer.parseInt(request.getParameter("courseNumber"));

        SQL sql=new SQL();
        boolean done=sql.UpdateVote(vo);

        if(done) {
            request.setAttribute("courseNumber", courseNumber);
            request.getRequestDispatcher("stuCourseVote.jsp").forward(request, response); //跳转到显示投票信息的页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
