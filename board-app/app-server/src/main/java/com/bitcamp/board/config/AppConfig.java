package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@ComponentScan(value="com.bitcamp.board")
public class AppConfig {

  public AppConfig() {
    System.out.println("AppConfig() 생성자 호출됨!");
  }

  @Bean
  public DataSource dataSource() {
    System.out.println("createDataSource() 호출됨!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");
    return ds;
  }

  // @Bean 애노테이션을 붙일 때 객체 이름을 지정하면
  // 그 이름으로 리턴 값을 컨테이너에 보관한다.
  // 이름을 지정하지 않으면 매서드 이름으로 보관한다.
  //  @Bean("transactionManager")
  @Bean
  public PlatformTransactionManager transactionManager(DataSource ds) {
    // Spring IoC 컨테이너는 이 메서드를 호출하기 전에
    // 이 메서드가 원하는 파라미터 값인 DataSource를 먼저 생성한다.
    // => createDataSource() 메서드를 먼저 호출한다.
    System.out.println("createTransactionManager 호출됨!");

    return new DataSourceTransactionManager(ds);
  }

  // multipart/fom-data 형식으로 들어온 요청 데이터를 도메인 객체로 받아주는
  // 도메인 객체를 등록한다.
  // 이 객체가 등록된 경우 multipart/form-data를 도메인 객체로 받을 수 있다.
  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  // Spring  WebMVC 의 기본 ViewResolver를 교체한다.
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class); // 주어진 URL을 처리할 객체 => JSP 실행시킨다.
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

}
