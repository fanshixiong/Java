package com.frans.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements HttpSessionListener {
    //创建session监听，一旦session创建就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onLineCount = (Integer) servletContext.getAttribute("OnLineCount");
        if(onLineCount == null){
            onLineCount = 1;
        }else {
            int count = onLineCount.intValue();

            onLineCount = count + 1;

        }
        servletContext.setAttribute("OnLineCount", onLineCount);
    }

    //销毁session监听

    /**
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        httpSessionEvent.getSession().invalidate();
        Integer onLineCount = (Integer) servletContext.getAttribute("OnLineCount");
        if(onLineCount == null){
            onLineCount = 0;
        }else {
            int count = onLineCount.intValue();

            onLineCount = new Integer(count - 1);

        }
        servletContext.setAttribute("OnLineCount", onLineCount);
    }
}

/**
 * Session销毁的方法：
 * 手动：httpSessionEvent.getSession().invalidate();
 * 自动：web.xml中配置
 */