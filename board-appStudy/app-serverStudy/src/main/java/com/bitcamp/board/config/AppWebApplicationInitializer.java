package com.bitcamp.board.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class AppWebApplicationInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("AppWebApplicationInitializer.onStartup()!!");

    AnnotationConfigWebApplicationContext iocContainer = 
        new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);

    servletContext.setAttribute("contextPath", servletContext.getContextPath());

    // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
    DispatcherServlet servlet = new DispatcherServlet(iocContainer);
    Dynamic config = servletContext.addServlet("app", servlet);
    config.setLoadOnStartup(1); // 웹 애플리케이션을 시작할 때 프론트 컨트롤러를 자동 생성.
    config.addMapping("/app/*");

    config.setMultipartConfig(new MultipartConfigElement(
        System.getProperty("java.io.tmpdir"), 
        1024 * 1024 * 5,
        1024 * 1024 * 10,
        1024 * 1024 
        ));

    // 필터 등록
    CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8");
    FilterRegistration.Dynamic filterConfig = servletContext.addFilter("CharacterEncodingFilter", filter);
    filterConfig.addMappingForServletNames(
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
        false, 
        "app");

    AdminCheckFilter adminFilter = new AdminCheckFilter();
    FilterRegistration.Dynamic adminFilterConfig = servletContext.addFilter("AdminCheckFilter", adminFilter);
    adminFilterConfig.addMappingForUrlPatterns(
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
        false, 
        "/app/member/*");

    LoginCheckFilter loginFilter = new LoginCheckFilter();
    FilterRegistration.Dynamic loginFilterConfig = servletContext.addFilter("LoginCheckFilter", loginFilter);
    loginFilterConfig.addMappingForUrlPatterns(
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
        false, 
        "/app/*");

  }
}
