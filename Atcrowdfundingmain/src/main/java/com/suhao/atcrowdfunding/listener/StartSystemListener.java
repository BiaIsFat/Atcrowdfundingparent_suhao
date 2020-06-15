package com.suhao.atcrowdfunding.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author suhao
 * @create_date 2020-05-15 16:48
 */
public class StartSystemListener implements ServletContextListener {

    //在服务器启动时创建application对象时需要执行的方法
    public void contextInitialized(ServletContextEvent sce) {
      //将项目上下文路径（request.getContextPath（））放置到application域中
        ServletContext application = sce.getServletContext();
        String contextPath= application.getContextPath();
        application.setAttribute("APP_PATH",contextPath);
        System.out.println("APP_PATH..");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
