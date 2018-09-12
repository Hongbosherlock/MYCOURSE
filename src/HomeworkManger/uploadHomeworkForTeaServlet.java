package HomeworkManger;

import Bean.homework;
import SQLVisit.SQL;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/**
 * author:LvFan
 * function:用于教师上传作业，并且将作业保存到相应路径，修改数据库信息
 *          需提供作业 介绍 截止日期 课程号，保存路径
 *          通过request返回成功与否
 */
@WebServlet("/uploadHomeworkForTeaServlet")
public class uploadHomeworkForTeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String adjunctname;                                                //存储文件名
        String fileDir = this.getServletContext().getRealPath("HOMEWORK/");   //获得写入地址的绝对路径

        String address = "";                                                  //最终文件的保存地址及文件名
        int courseNumber=0;
        homework hk=new homework();

        if (ServletFileUpload.isMultipartContent(request)) {                 //判断是否为上传文件
            DiskFileItemFactory factory = new DiskFileItemFactory();        //创建文件工厂对象
//           factory.setSizeThreshold(20*1024);
//           factory.setRepository(factory.getRepository());
            ServletFileUpload upload = new ServletFileUpload(factory);      //创建一个新的文件上传对象

//           int size=2*1024*1024;
            List formlists = null;                                            //保存上传文件的集合对象
            try {
                formlists = upload.parseRequest(request);                     //获得上传文件的集合对象
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iter = formlists.iterator();                             //获得上传文件的迭代器
            while (iter.hasNext()) {
                FileItem formitem = (FileItem) iter.next();                    //获取每个上传文件
                if (!formitem.isFormField()) {                                //若是文件域，则进行上传
                    String name = formitem.getName();                         //获取文件全路径名
//                    if(formitem.getSize()>size){
//                        message="too big";
//                        break;
//                    }
                    String adjunctsize = new Long(formitem.getSize()).toString();  //获取文件大小
                    if ((name == null) || (name.equals("")) && (adjunctsize.equals("0")))
                        continue;
                    adjunctname = name.substring(name.lastIndexOf("\\") + 1, name.length());
                    address = fileDir + "\\" + adjunctname;                       //创建上传文件的保存地址
                    File saveFile = new File(address);                        //创建文件

                    try {
                        formitem.write(saveFile);                           //往文件写入数据

                        hk.setHomework_path(address);                          //保存文件路径
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (formitem.getFieldName().equals("introduction")) {
                        hk.setIntroduction(formitem.getString("utf-8"));          //得到介绍
                    } else if (formitem.getFieldName().equals("end_date")) {
                        hk.setEnd_date(formitem.getString("utf-8"));              //得到截止日期
                    } else if (formitem.getFieldName().equals("courseNumber")) {
                        courseNumber=Integer.parseInt(formitem.getString("utf-8"));
                        hk.setCourseNumber(courseNumber);                            //得到课程号
                    }
                }
            }
            SQL sql = new SQL();
            boolean done=sql.InsertHomework(hk);                                       //将作业发布信息写入数据库
            request.setAttribute("courseNumber",courseNumber+"");                      //将课程号传回去

            if(done) {
                request.getRequestDispatcher("teaCourseHomework.jsp").forward(request, response); //返回教师课程主页，显示作业页
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
