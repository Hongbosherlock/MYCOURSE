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
 * 学生登录
 */

@WebServlet("/loginStuServlet")
public class loginStuServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        SQL sql = new SQL();

        stuinfo stu=sql.getStuInfo(request.getParameter("stuNumber"),request.getParameter("password"));
        if (stu!=null)
        {
            String role = "student";
            request.getSession().setAttribute("role",role);
            request.getSession().setAttribute("student", stu);

            request.getRequestDispatcher("/studentHome.jsp").forward(request,response);
        }
        else {
//            response.sendRedirect("login.jsp");
            request.setAttribute("message","帐号不存在或者密码不正确！");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}