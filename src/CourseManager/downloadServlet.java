package CourseManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * author:LvFan
 * function:用于用户下载 课件 和 作业
 *          需要提供相应下载路径
 */
@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String path=request.getParameter("path");   // 在实际使用过程中用这个路径

//        path=new String(path.getBytes("ISO-8859-1"),"utf-8");

        File file=new File(path);
        InputStream in=new FileInputStream(file);
        OutputStream os=response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+
                new String(file.getName().getBytes("GBK"),"ISO-8859-1"));
        response.addHeader("Content-Length",file.length()+"");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream");
        int data=0;
        while((data=in.read())!=-1){
            os.write(data);
        }
        os.close();
        in.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

