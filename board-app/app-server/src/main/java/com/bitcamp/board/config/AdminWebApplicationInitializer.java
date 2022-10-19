package com.bitcamp.board.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

// 서블릿 컨테이너
public class AdminWebApplicationInitializer 
/* extends AbstractAnnotationConfigDispatcherServletInitializer */ {


  protected Class<?>[] getRootConfigClasses() {
    return null;
  }  


  protected String getServletName() {
    return "admin";
  }


  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {AdminWebConfig.class};
  }


  protected String[] getServletMappings() {
    return new String[] {"/admin/*"};
  }


  protected Filter[] getServletFilters() {
    return new Filter[] {
        new CharacterEncodingFilter("UTF-8"), 
        new LoginCheckFilter(),
        new AdminCheckFilter()
    };
  }

}
