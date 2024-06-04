package org.example.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    //监听对象的创建和销毁
    //上下文的创建和销毁
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //程序一启动就执行的代码
//        sce.getSource();//得到事件源
        System.out.println("context init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //结束时释放资源等可以在此写

        System.out.println("context destory");
    }
}
