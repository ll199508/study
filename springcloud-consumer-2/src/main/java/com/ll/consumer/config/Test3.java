package com.ll.consumer.config;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
@Component
public class Test3 implements ServletContextListener {

    /**
     * 在初始化Web应用程序中的任何过滤器或servlet之前，将通知所有servletContextListener上下文初始化。
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ServletContext servletContext = sce.getServletContext();
        System.out.println("执行contextInitialized方法");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
