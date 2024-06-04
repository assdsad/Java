package org.example.database.user.dao;

import org.example.database.utils.DbUtil;

import java.sql.*;

public class UserDao {


    public boolean findByEmailAndName(String email, String name) {
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        //1、加载驱动    直接在DbUtil中
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");//mysql8的用法     mysql5直接删掉cj
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        //2、获取数据库链接
        try {                                                            //数据库的ip      //数据库名
            //一个类的静态方法
            con = DbUtil.getCon();

            //使用PreparedStatment
            String sql = "select * from tb_user where email = ? and name = ?";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, email);//设置?部分的参数
            ps.setString(2, name);
            rs = ps.executeQuery();


            //使用Statment
//            String sql = "select * from tb_user where email = '" + email + "' and name = '" + name + "'";
//            System.out.println(sql);
//
//            sm = con.createStatement();
//            rs = sm.executeQuery(sql);

            if(rs != null && rs.next()) {//rs相当于游标  每次查询一行  知道最后一行的下一行没有数据时结束循环
                return true;
            }//结束循环时，游标处于
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DbUtil.close(rs, ps, con);
        }
    }
}
