package org.example.avatar.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.avatar.utils.ResultUtils;

import java.io.*;

@WebServlet(name = "upload", value = "/upload")
public class UploadServlet extends HttpServlet {
    private static final String PATH = "G:/user_info/avatar/";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json:charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //怎么区分不同人上传的图片  1、图片名和手机号一致  2、数据库表中主键的id作为图片的名字
        //得到图片流
        InputStream is = request.getInputStream();//先获取流再获取参数
        //得到登录用户的手机号（主键）
        String phone = request.getParameter("phone");

        String path = PATH + phone + ".jpeg";

        //一边读文件，一边写文件
        OutputStream os = new FileOutputStream(path);//输出流写文件
        byte[] bytes = new byte[512];
        int len = -1;
        //将图片写入文件夹
        while((len = is.read(bytes)) != -1){
            os.write(bytes, 0, len);
            os.flush();
        }

        os.close();
        is.close();

        PrintWriter out = response.getWriter();
        out.print(ResultUtils.loginSuccess("上传成功"));

        out.close();
    }
}
