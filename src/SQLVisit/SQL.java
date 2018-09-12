/*
 * Copyright (c) 2018 All rights reserved
 * Author: LvFan
 * Project：MYCOURSE
 * File:SQL.java
 * Date:18-6-9 下午8:38
 */

package SQLVisit;

import Bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQL {
    /**
     * SQL类负责所有对数据库的使用操作
     * 包括对每个表单的插入操作
     * 包括对每个表单的删除操作
     * 包括对每个表单的修改操作
     * 包括对一些表单的搜索操作*/

    private Connection conn = null;
    private String sql=null;
    private static final String url = "jdbc:mysql://localhost:3306/mycourse?useUnicode=true&characterEncoding=utf-8";
    private static final String user="root";
    private static final String password="221512";

    public SQL(){
        /**
         * 初始化SQL对象*/
        conn=getConnection();
    }
    private Connection getConnection(){
        /**
         * 取得数据库池的连接*/
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //Insert Information

    public boolean InsertStuInfo(stuinfo stu){
        /**
         * 将学生信息插入学生信息表单*/
        try{
            sql="insert into t_stuinfo values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getStuNumber());
            ps.setString(3,stu.getSex());
            ps.setString(4, stu.getPassword());
            ps.setString(5,stu.getEmail());
            ps.setString(6,stu.getSchool());
            ps.setString(7, stu.getCollege());
            ps.setString(8, stu.getGrade());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertTeaInfo(teainfo tea){
        /**
         * 将教师信息插入教师信息表单*/
        try{
            sql="insert into t_teainfo values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tea.getName());
            ps.setString(2, tea.getTeaNumber());
            ps.setString(3,tea.getSex());
            ps.setString(4, tea.getPassword());
            ps.setString(5, tea.getEmail());
            ps.setString(6,tea.getSchool());
            ps.setString(7, tea.getCollege());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean InsertCourseInfo(courseinfo cour){
        /**
         * 将课程信息插入课程信息表单*/
        try{
            sql="insert into t_courseinfo(courseName,teaNumber,introduction) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, cour.getCourseName());
            ps.setString(2,cour.getTeaNumber());
            ps.setString(3, cour.getIntroduction());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertAnnouncement(announcement ant){
        /**
         * 将公告信息插入公告信息表单*/
        try{
            sql="insert into t_announcement(a_date,content,courseNumber) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ant.getDate());
            ps.setString(2,ant.getContent());
            ps.setInt(3, ant.getCourseNumber());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertComment(comment com){
        /**
         * 将评论信息插入评论信息表单*/
        try{
            sql="insert into t_comment(stuNumber,c_date,content,courseNumber) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, com.getStuNumber());
            ps.setString(2,com.getDate());
            ps.setString(3, com.getContent());
            ps.setInt(4, com.getCourseNumber());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertFile(file fil){
        /**
         * 将文件信息插入文件信息表单*/
        try{
            sql="insert into t_file(f_date,introduction,courseNumber,file_path) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, fil.getDate());
            ps.setString(2,fil.getIntroduction());
            ps.setInt(3, fil.getCourseNumber());
            ps.setString(4, fil.getFile_path());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertHomework(homework hk){
        /**
         * 将文件信息插入文件信息表单*/
        try{
            sql="insert into t_homework(end_date,introduction,courseNumber,homework_path) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, hk.getEnd_date());
            ps.setString(2,hk.getIntroduction());
            ps.setInt(3, hk.getCourseNumber());
            ps.setString(4, hk.getHomework_path());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertSelect_course(int courseNumber,String stuNumber){
        /**
         * 将选课信息插入选课信息表单*/
        try{
            sql="insert into t_select_course(courseNumber,stuNumber) values(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, courseNumber);
            ps.setString(2,stuNumber);
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertSubmit_homework(submit_homework sh){
        /**
         * 将文件信息插入文件信息表单*/
        try{
            sql="insert into t_submit_homework(homework_id,stuNumber,submit_path) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, sh.getHomework_id());
            ps.setString(2,sh.getStuNmuber());
            ps.setString(3,sh.getPath());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertVote(vote vo){
        /**
         * 将投票信息插入投票信息表单*/
        try{
            sql="insert into t_vote(content,result,end_date,courseNumber) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, vo.getContent());
            ps.setString(2,vo.getResult());
            ps.setString(3, vo.getEnd_date());
            ps.setInt(4, vo.getCourseNumber());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Delete Information
    public boolean DeleteStuInfo(String stuNumber){
        /**
         * 将学生信息从学生信息表单中删除*/
        try{
            sql="delete from t_stuinfo where stuNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, stuNumber);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteTeaInfo(String teaNumber){
        /**
         * 将教师信息从教师信息表单中删除*/
        try{
            sql="delete from t_teainfo where teaNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, teaNumber);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteCourseInfo(int courseNumber){
        /**
         * 将课程信息从课程数据库中删除*/
        try{
            int row=0;
            sql="delete from t_courseinfo where courseNumber=?";         //从t_courseinfo表单中删除
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);
            row=ps.executeUpdate();

            sql="delete from t_announcement where courseNumber=?"; //从t_announcement表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_comment where courseNumber=?";      //从t_comment表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_submit_homework where homework_id in" +    //从t_submit_homework表中删除
                    " (select id from t_homework where courseNumber=?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_file where courseNumber=?";         //从t_file表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_homework where courseNumber=?";    //从t_homework表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_select_course where courseNumber=?";//从t_select_course表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            sql="delete from t_vote where courseNumber=?";         //从t_vote表单中删除
            ps=conn.prepareStatement(sql);
            ps.setInt(1,courseNumber);
            ps.executeUpdate();

            if(row>0)
                return true;
            else
                return false;


        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteAnnouncement(int id){
        /**
         * 将公告信息从公告信息表单中删除*/
        try{
            sql="delete from t_announcement where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteComment(int id){
        /**
         * 将评论信息从评论信息表单中删除*/
        try{
            sql="delete from t_comment where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, id);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteFile(int id){
        /**
         * 将文件信息从文件信息表单中删除*/
        try{
            sql="delete from t_file where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, id);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteHomework(int id) {
        /**
         * 将文件信息从文件信息表单中删除*/
        try {
            sql = "delete from t_homework where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();
            if (row > 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteSelect_course(int courseNumber,String stuNumber){
        /**
         * 将选课信息从选课信息表单中删除*/
        try{
            sql="delete from t_select_course where courseNumber=? and stuNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, courseNumber);
            ps.setString(2,stuNumber);
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteSubmit_homework(int homework_id,String stuNumber,String state){
        /**
         * 将文件信息从文件信息表单中删除*/
        try{
            sql="delete from t_submit_homework where homework_id=? and stuNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, homework_id);
            ps.setString(2,stuNumber);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteVote(int id){
        /**
         * 将投票信息从投票信息表单中删除*/
        try{
            sql="delete from t_vote where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1, id);

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Update Information
    public boolean UpdateStuInfo(stuinfo stu){
        try{
            sql="update s_stuinfo set stuName=?,sex=?,password=?,email=?,school=?,college=?,grade=? where stuNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stu.getName());
            ps.setString(2,stu.getSex());
            ps.setString(3, stu.getPassword());
            ps.setString(4,stu.getEmail());
            ps.setString(5,stu.getSchool());
            ps.setString(6, stu.getCollege());
            ps.setString(7, stu.getGrade());
            ps.setString(8, stu.getStuNumber());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateTeaInfo(teainfo tea){
        try{
            sql="update t_teainfo set teaName=?,sex=?,password=?,email=?,school=?,college=? where teaNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tea.getName());
            ps.setString(2,tea.getSex());
            ps.setString(3, tea.getPassword());
            ps.setString(4,tea.getEmail());
            ps.setString(5,tea.getSchool());
            ps.setString(6, tea.getCollege());
            ps.setString(7, tea.getTeaNumber());
            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateCourseInfo(courseinfo cour){
        try{
            sql="update t_courseinfo set courseName=?,introduction=? where courseNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, cour.getCourseName());
            ps.setString(2, cour.getIntroduction());
            ps.setInt(3,cour.getCourseNumber());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateAnnouncement(announcement ant){
        try{
            sql="update t_announcement set a_date=?,content=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ant.getDate());
            ps.setString(2,ant.getContent());
            ps.setInt(3,ant.getId());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateComment(comment com){
        try{
            sql="update t_comment set stuNumber=?,c_date=?,content=?,courseNumber=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, com.getStuNumber());
            ps.setString(2,com.getDate());
            ps.setString(3, com.getContent());
            ps.setInt(4,com.getCourseNumber());
            ps.setInt(5, com.getId());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateFile(file fil){
        try{
            sql="update t_file set introduction=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,fil.getIntroduction());
            ps.setInt(2, fil.getId());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateHomework(homework hk){
        try{
            sql="update t_homework set end_date=?,introduction=?,courseNumber=?,homework_path=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hk.getEnd_date());
            ps.setString(2,hk.getIntroduction());
            ps.setInt(3, hk.getCourseNumber());
            ps.setString(4,hk.getHomework_path());
            ps.setInt(5, hk.getId());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateVote(vote vo){
        try{
            sql="update t_vote set content=?,result=?,end_date=?where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, vo.getContent());
            ps.setString(2,vo.getResult());
            ps.setString(3, vo.getEnd_date());
            ps.setInt(4, vo.getId());

            int row =ps.executeUpdate();
            if(row>0)
                return true;
            else
                return false;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Select Information

    /**
     * 按学生查询课程
     * 按教师查询课程
     * 按课程名查询课程
     * 查看是否有学号重复
     * 查看是否有教师号重复
     * 按课程搜索投票信息
     * 按课程搜索课件信息
     * 按课程搜索作业信息
     * 按课程搜索公告信息
     * 按课程搜索评论信息
     * 按学生搜索评论信息
     * 按学号和密码查询学生信息
     * 按教师号和密码查询教师信息
     * */
    public List<courseinfo> SelectCoursesByStuNumber(String stuNumber){
        /**
         *按学生查询课程 */
        List<courseinfo> courseList=new ArrayList<>();
        try{
            sql="select * from t_courseinfo where courseNumber in ("
                    + "select courseNumber from t_select_course where stuNumber=? )";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stuNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                courseinfo course=new courseinfo();
                course.setCourseNumber(rs.getInt("courseNumber"));
                course.setCourseName(rs.getString("courseName"));
                course.setIntroduction(rs.getString("introduction"));
                course.setTeaNumber(rs.getString("teaNumber"));
                courseList.add(course);
            }
            return courseList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }

    public List<courseinfo> SelectCoursesByTeaNumber(String teaNumber){
        /**
         *按教师查询课程 */
        List<courseinfo> courseList=new ArrayList<>();
        try{
            sql="select * from t_courseinfo where teaNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, teaNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                courseinfo course=new courseinfo();
                course.setCourseNumber(rs.getInt("courseNumber"));
                course.setCourseName(rs.getString("courseName"));
                course.setIntroduction(rs.getString("introduction"));
                course.setTeaNumber(rs.getString("teaNumber"));
                courseList.add(course);
            }
            return courseList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }

    public List<courseinfo> SelectCoursesByCourseName(String courseName){
        /**
         *按课程名查询课程 */
        List<courseinfo> courseList=new ArrayList<>();
        try{
            sql="select * from t_courseinfo where courseName=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, courseName);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                courseinfo course=new courseinfo();
                course.setCourseNumber(rs.getInt("courseNumber"));
                course.setCourseName(rs.getString("courseName"));
                course.setIntroduction(rs.getString("introduction"));
                course.setTeaNumber(rs.getString("teaNumber"));
                courseList.add(course);
            }
            return courseList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }

    public String SelectCourseNameByCourseNumber(int courseNumber){
        /**
         *按课程号查询课程名称 */
        String courseName="";
        try{
            sql="select courseName from t_courseinfo where courseNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                courseName = rs.getString("courseName");
            }
            return courseName;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseName;
    }

    public String SelectTeaNameByCourseNumber(int courseNumber){
        /**
         *按课程号查询教师姓名 */
        String teaName="";
        try{
            sql="select * from t_teainfo where teaNumber=(select teaNumber from t_courseinfo where courseNumber=?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();

            while(rs.next()) {
                teaName = rs.getString("teaName");
            }
            return teaName;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return teaName;
    }

    public boolean stuNumberExist(String stuNumber){
        /**
         *查看是否有学号重复 */
        try{
            sql="select * from t_stuinfo where stuNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stuNumber);

            boolean exist=false;
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                exist=true;
                break;
            }
            return exist;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean teaNumberExist(String teaNumber){
        /**
         * 查看是否有教师号重复*/
        try{
            sql="select * from t_teainfo where teaNumber=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, teaNumber);

            boolean exist=false;
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                exist=true;
                break;
            }
            return exist;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<vote> SelectVoteByCourse(int courseNumber){
        /**
         * 按课程搜索投票信息*/
        List<vote> voteList=new ArrayList<>();
        try{
            sql="select * from t_vote where courseNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vote vo=new vote();
                vo.setId(rs.getInt("id"));
                vo.setContent(rs.getString("content"));
                vo.setResult(rs.getString("result"));
                vo.setEnd_date(rs.getString("end_date"));
                vo.setCourseNumber(rs.getInt("courseNumber"));
                voteList.add(vo);
            }
            return voteList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return voteList;
    }

    public List<file> SelectFileByCourse(int courseNumber){
        /**
         * 按课程搜索课件信息*/
        List<file> fileList=new ArrayList<>();
        try{
            sql="select * from t_file where courseNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                file fil=new file();
                fil.setId(rs.getInt("id"));
                fil.setDate(rs.getString("f_date"));
                fil.setIntroduction(rs.getString("introduction"));
                fil.setCourseNumber(rs.getInt("courseNumber"));
                fil.setFile_path(rs.getString("file_path"));
                fileList.add(fil);
            }
            return fileList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return fileList;
    }

    public List<homework> SelectHomeworkByCourse(int courseNumber){
        /**
         * 按课程搜索作业信息*/
        List<homework> homeworkList=new ArrayList<>();
        try{
            sql="select * from t_homework where courseNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                homework hk=new homework();
                hk.setId(rs.getInt("id"));
                hk.setEnd_date(rs.getString("end_date"));
                hk.setIntroduction(rs.getString("introduction"));
                hk.setCourseNumber(rs.getInt("courseNumber"));
                hk.setHomework_path(rs.getString("homework_path"));
                homeworkList.add(hk);
            }
            return homeworkList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return homeworkList;
    }

    public List<announcement> SelectAnnouncementByCourse(int courseNumber){
        /**
         * 按课程搜索公告信息*/
        List<announcement> announcementList=new ArrayList<>();
        try{
            sql="select * from t_announcement where courseNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                announcement ant=new announcement();
                ant.setId(rs.getInt("id"));
                ant.setDate(rs.getString("a_date"));
                ant.setContent(rs.getString("content"));
                ant.setCourseNumber(rs.getInt("courseNumber"));
                announcementList.add(ant);
            }
            return announcementList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return announcementList;
    }

    public List<comment> SelectCommentByCourse(int courseNumber){
        /**
         * 按课程搜索评论信息*/
        List<comment> commentList=new ArrayList<>();
        try{
            sql="select * from t_comment where courseNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, courseNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                comment com=new comment();
                com.setId(rs.getInt("id"));
                com.setStuNumber(rs.getString("stuNumber"));
                com.setDate(rs.getString("c_date"));
                com.setContent(rs.getString("content"));
                com.setCourseNumber(rs.getInt("courseNumber"));
                commentList.add(com);
            }
            return commentList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return commentList;
    }

    public List<comment> SelectCommentByStudent(String stuNumber){
        /**
         * 按学生搜索评论信息*/
        List<comment> commentList=new ArrayList<>();
        try{
            sql="select * from t_comment where stuNumber =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stuNumber);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                comment com=new comment();
                com.setId(rs.getInt("id"));
                com.setStuNumber(rs.getString("stuNumber"));
                com.setDate(rs.getString("date"));
                com.setContent(rs.getString("content"));
                com.setCourseNumber(rs.getInt("courseNumber"));
                commentList.add(com);
            }
            return commentList;

        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return commentList;
    }

    public stuinfo getStuInfo(String stuNumber, String password){
        /**
         * 按照学号和密码搜索学生信息*/
        try{
            sql="select * from t_stuinfo where stuNumber =? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, stuNumber);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();

            if (rs.next()){
                stuinfo stu=new stuinfo();
                stu.setName(rs.getString("stuName"));
                stu.setStuNumber(rs.getString("stuNumber"));
                stu.setPassword(rs.getString("password"));
                stu.setSex(rs.getString("sex"));
                stu.setEmail(rs.getString("email"));
                stu.setSchool(rs.getString("school"));
                stu.setCollege(rs.getString("college"));
                stu.setGrade(rs.getString("grade"));
                return stu;
            }
            else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public teainfo getTeaInfo(String teaNumber, String password) {
        /**
         * 按照教师号和密码搜索教师信息*/
        try {
            sql = "select * from t_teainfo where teaNumber =? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teaNumber);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teainfo tea = new teainfo();
                tea.setName(rs.getString("teaName"));
                tea.setTeaNumber(rs.getString("teaNumber"));
                tea.setPassword(rs.getString("password"));
                tea.setSex(rs.getString("sex"));
                tea.setEmail(rs.getString("email"));
                tea.setSchool(rs.getString("school"));
                tea.setCollege(rs.getString("college"));
                return tea;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<submit_homework> SelectSubmitByHomeworkId(int id) {
        /**
         * 按照作业id返回提交的学生号*/
        List<submit_homework> submit_homeworkList=new ArrayList<>();
        try {
            sql = "select * from t_submit_homework where homework_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                submit_homework sh=new submit_homework();
                sh.setHomework_id(rs.getInt("homework_id"));
                sh.setStuNmuber(rs.getString("stuNumber"));
                sh.setPath(rs.getString("submit_path"));
                submit_homeworkList.add(sh);
            }
            return submit_homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return submit_homeworkList;
    }
}
