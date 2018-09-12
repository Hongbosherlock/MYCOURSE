package FileManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import Bean.file;
import SQLVisit.SQL;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.filefilter.SuffixFileFilter;
/**
 * author:LvFan
 * function:用于上传课件，并且将文件信息写入数据库
 *          需提供 介绍 时间 课程号，课件保存路径
 *          通过request返回成功与否
 */
@WebServlet("/uploadFileServlet")
public class uploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String adjunctname;                                                //存储文件名
        String fileDir=this.getServletContext().getRealPath("FILE/");   //获得写入地址的绝对路径
        boolean done=true;                                                 //消息
        String address="";                                                  //最终文件的保存地址及文件名
        int courseNumber=0;

        file fil=new file();

        if(ServletFileUpload.isMultipartContent(request)) {                 //判断是否为上传文件
            DiskFileItemFactory factory = new DiskFileItemFactory();        //创建文件工厂对象
            ServletFileUpload upload = new ServletFileUpload(factory);      //创建一个新的文件上传对象

            String[] suffixs=new String[]{".exe",".bat",".jsp"};
            SuffixFileFilter filter=new SuffixFileFilter(suffixs);          //限制上传文件类型


            List formlists=null;                                            //保存上传文件的集合对象
            try {
                formlists=upload.parseRequest(request);                     //获得上传文件的集合对象
            }catch(FileUploadException e){
                e.printStackTrace();
            }
            Iterator iter=formlists.iterator();                             //获得上传文件的迭代器
            while(iter.hasNext()){
                FileItem formitem=(FileItem)iter.next();                    //获取每个上传文件
                if(!formitem.isFormField()){                                //若是文件域，则进行上传
                    String name=formitem.getName();                         //获取文件全路径名

                    String adjunctsize=new Long(formitem.getSize()).toString();  //获取文件大小
                    if((name==null)||(name.equals(""))&&(adjunctsize.equals("0")))
                        continue;
                    adjunctname=name.substring(name.lastIndexOf("\\")+1,name.length());
                    address=fileDir+"\\"+adjunctname;                       //创建上传文件的保存地址
                    File saveFile=new File(address);                        //创建文件

                    boolean res=filter.accept(saveFile);
                    if(res){
                        done=false;
                    }
                    else {
                        try {
                            formitem.write(saveFile);                           //往文件写入数据

                            fil.setFile_path(address);                          //保存文件路径
                        } catch (Exception e) {
                            e.printStackTrace();
                            done=false;
                        }
                    }
                }
                else{
                    if(formitem.getFieldName().equals("introduction")){
                        fil.setIntroduction(formitem.getString("utf-8"));    //得到课件介绍
                    }
                    else if(formitem.getFieldName().equals("courseNumber")){
                        courseNumber=Integer.parseInt(formitem.getString("utf-8"));
                        fil.setCourseNumber(courseNumber);                      //得到课程号
                    }
                }
            }


            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String s_date=sdf.format(date);                                             //获得相应时间
            fil.setDate(s_date);                                                        //将file对象补充完整

            SQL sql=new SQL();
            done=sql.InsertFile(fil);

            if(done) {
                request.getSession().setAttribute("courseNumber",courseNumber);
                request.setAttribute("courseNumber", courseNumber+"");                    //将课程号传回去
                request.getRequestDispatcher("teaCourseFile.jsp").forward(request, response); //返回教师课程主页，显示课件页
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
