package org.example.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("sessionAdd:" + event.getName());
        System.out.println("sessionAdd:" + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("sessionRemove:" + event.getName());
        System.out.println("sessionRemove:" + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("sessionReplace:" + event.getName());
        System.out.println("sessionReplace:" + event.getValue());
    }
}
