package org.example.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session create");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destoryed");
    }
}
