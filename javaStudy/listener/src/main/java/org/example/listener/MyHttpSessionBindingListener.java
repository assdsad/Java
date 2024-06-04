package org.example.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
//    只有在session中存实现HttpSessionBindingListener接口的类的对象时才会执行
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(event.getName());
        System.out.println(event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
