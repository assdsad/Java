package org.example.avatartest.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.avatartest.utils.ReadWriteUserInfoUtil;
import org.example.avatartest.utils.ResultUtils;

import java.io.*;

@WebServlet(name = "upload", value = "/upload")
public class UploadServlet extends HttpServlet {
    private static final String PATH = "G:/user_info/avatar_test/";//头像存入的地址
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json:charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //让图片名和用户名相同，可以区分不同人上传的照片
        //获取到图片流
        InputStream is = request.getInputStream();
        //得到用户手机号
        String phone = request.getParameter("phone");

        String path = PATH + phone + ".jpeg";//头像最后存储的位置

        //一边读，一边写
        OutputStream os = new FileOutputStream(path);
        byte[] bytes = new byte[512];
        int len = -1;
        while((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
            os.flush();
        }

        os.close();
        is.close();

        //更新文本文件中的内容
        ReadWriteUserInfoUtil.updateUserinfo(phone, path);
        PrintWriter out = response.getWriter();
        out.write(ResultUtils.success("上传成功"));

        out.close();
    }
}
