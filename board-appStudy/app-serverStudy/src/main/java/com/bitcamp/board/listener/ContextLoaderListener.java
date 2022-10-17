package com.bitcamp.board.listener;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.bitcamp.board.config.AppConfig;
import com.bitcamp.servlet.DispatcherServlet;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class ContextLoaderListener implements ServletContextListener{
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유자원 준비 중!!");
    try {
      // 스프링 IoC 컨테이너
      AnnotationConfigApplicationContext iocContainer =
          new AnnotationConfigApplicationContext(AppConfig.class); 

      ServletContext ctx = sce.getServletContext();

      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      Dynamic config =  ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(new MultipartConfigElement(
          this.getClass().getAnnotation(MultipartConfig.class)));



    } catch (Exception e) {
      e.printStackTrace();
    }
  }  
}
