package Student;

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
 * Created by Hongb on 2018/5/26.
 */
@WebServlet("/resignStuServlet")
public class resignStuServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            request.setCharacterEncoding("UTF-8");
            doPost(request,response);  //让doGet()执行与doPost相同的操作
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");

//        java Bean对象：stuinfo, 给stu对象赋值
        stuinfo stu = new stuinfo();
        stu.setName(request.getParameter("truename"));
        stu.setStuNumber(request.getParameter("stuNumber"));
        String sex = request.getParameter("sex").equals("1") ?"男":"女";
        stu.setSex(sex);
        stu.setPassword(request.getParameter("password"));
        stu.setEmail(request.getParameter("email"));
        stu.setSchool(request.getParameter("school"));
        stu.setCollege(request.getParameter("college"));
        stu.setGrade(request.getParameter("grade"));

//        System.out.println("学生性别:"+stu.getSex());
//      访问数据库
        SQL sql =new SQL();
        boolean flag = sql.InsertStuInfo(stu);
        if(flag)
        {
            response.sendRedirect("/login.html");
        }
        else
        {
            request.setAttribute("message","注册失败，可能是学生号已存在！");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
