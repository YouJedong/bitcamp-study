package com.bitcamp.board.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.filter.CharacterEncodingFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

// 서블릿 컨테이너
public class AppWebApplicationInitializer 
/* extends AbstractAnnotationConfigDispatcherServletInitializer */{


  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] {RootConfig.class, DatabaseConfig.class, MybatisConfig.class};
  }  


  protected String getServletName() {
    return "app";
  }


  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {AppWebConfig.class};
  }


  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }


  protected Filter[] getServletFilters() {
    return new Filter[] {
        new CharacterEncodingFilter("UTF-8"), 
        new LoginCheckFilter()
    };
  }

  // 수퍼클래스에서 DispatcherServlet을 준비할 때 추가적으로 설정할 것이 있으면 설정한다.

  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement(
        System.getProperty("java.io.tmpdir"), // 클라이언트가 보낸 파일을 임시 저장할 디렉토리
        1024 * 1024 * 5, // 한 파일의 최대 크기
        1024 * 1024 * 10, // 첨부 파일을 포함한 전체 요청 데이터의 최대 크기
        1024 * 1024 // 첨부 파일 데이터를 일시적으로 보관할 버퍼 크기 
        ));
  }

}
