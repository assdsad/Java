package org.example.avatartest;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
                //1、加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql8的用法     mysql5直接删掉cj
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2、获取数据库链接
        try {                                                            //数据库的ip      //数据库名
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avatartest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root", "wsh20040501");//一个类的静态方法
            //3、执行sql语句
                //插入数据
//            String sql = "insert into tb_user values('zhangsan@163.com', '张三', '2024-03-12 08:00:00')";
//            String sql = "insert into tb_user values('lisi@163.com', '李四', '2024-06-13 08:00:00')";
//            String sql = "insert into tb_user values('zhaowu@163.com', '赵五', '2024-08-22 08:00:00')";
//
//            Statement sm = con.createStatement();
//            int count = sm.executeUpdate(sql);//更新表
//            System.out.println(count);

            String sql = "insert into userinfo (phone,password,avatar) values(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1111);
            ps.setString(2, "wdafw");
            ps.setString(3, "");

            int count = ps.executeUpdate();
//            String sql = "select * from userinfo";
//            Statement sm = con.createStatement();
//            ResultSet rs = sm.executeQuery(sql);
//
//            while(rs.next()) {//rs相当于游标  每次查询一行  知道最后一行的下一行没有数据时结束循环
//                int email = rs.getInt(1);//一行中第一列的值
//                String name = rs.getString(2);//查询一行中某一列的值可以用index也可以用列名
////                String registerTime = String.valueOf(rs.getDate(3));
//                System.out.print(email + "  " + name + "  "+  email + "\n");

//                if(rs.getString(1).equals("11111")) {
//                    System.out.println(rs.getString(2));
//                }
//            }//结束循环时，游标处于

        //4、关闭连接
//            rs.close();
//            sm.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
