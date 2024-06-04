package org.example.databasetest;

import org.example.databasetest.user.service.UserService;

import java.sql.*;

public class Test {
    public static void main(String[] args) {

        boolean result = new UserService().login("Kobe@163.com", "KobeBryant");
        System.out.println(result);

        new UserService().findAllInDb();

//        //1、加载驱动
//        try {
//           Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        //2、获取数据库链接
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeonline_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
//                    "root", "wsh20040501");
//
//            //3、执行sql语句
//            //插入数据
////            String sql = "insert into tb_user values('Kobe@163.com', 'KobeBryant','2020-08-13 12:12:12')";
////            PreparedStatement ps = con.prepareStatement(sql);
////            int count = ps.executeUpdate();
//
//            //查询数据
//            String sql = "select * from tb_user";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()) {
//                String email = rs.getNString(1);
//                String name = rs.getString(2);
//                Date date = rs.getDate(3);
//                System.out.println(email + "  " + name + "  " + date.toLocaleString());
//            }
//
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
