package org.example.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    //监听 增，删，改 数据
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        //添加数据时执行
        System.out.println(event.getName());
        System.out.println(event.getValue());
//        event.getServletContext().removeAttribute(event.getName());//一存就删
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        //删除数据时执行
        System.out.println("remove:" + event.getName());
        System.out.println("remove:" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        //更改数据时执行
        System.out.println("replace:" + event.getName());
        System.out.println("replace:" + event.getValue());//得到修改之前的值
        System.out.println(event.getServletContext().getAttribute(event.getName()));//得到修改后的值
    }
}
