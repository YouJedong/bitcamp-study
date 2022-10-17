package com.bitcamp.board.listener;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.bitcamp.board.config.AppConfig;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class ContextLoaderListener implements ServletContextListener{
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유자원 준비 중!!");
    try {
      AnnotationConfigWebApplicationContext iocContainer =
          new AnnotationConfigWebApplicationContext(); 
      iocContainer.register(AppConfig.class);
      iocContainer.refresh();

      ServletContext ctx = sce.getServletContext();

      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      Dynamic config =  ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(new MultipartConfigElement(
          this.getClass().getAnnotation(MultipartConfig.class)));
      config.setLoadOnStartup(1);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }  
}
