package com.bitcamp.board.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class AppWebApplicationInitializer extends AbstractDispatcherServletInitializer {


  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null;
  }

  @Override
  protected String getServletName() {
    return "app";
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext iocContainer = 
        new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);
    return iocContainer;
  } 

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  @Override
  protected Filter[] getServletFilters() {
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

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    servletContext.setAttribute("contextPath", servletContext.getContextPath());

    config.setMultipartConfig(new MultipartConfigElement(
        System.getProperty("java.io.tmpdir"), 
        1024 * 1024 * 5,
        1024 * 1024 * 10,
        1024 * 1024 
        ));




  }
}
