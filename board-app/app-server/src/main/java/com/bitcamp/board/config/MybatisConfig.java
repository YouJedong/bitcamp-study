package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// Mybatis가 자동으로 생성할 DAO 인터페이스를 지정한다.
// - Mybatis는 매퍼 파일과 인터페이스를 분석하여 DAO를 구현해야한다.
// Mybatis Sql 매퍼 파일의 경로를 지정하면 
// 해당 매퍼 파일을 분석하여 DAO 구현체를 자동 생성한다.
// 조건:
// 1) namespace의 값은 DAO 인터페이스의 이름(fully-qualified name)이어야한다.
// 2) SQL ID는 인터페이스에 선언된 메서드 이름과 일치해야 한다.
// 3) SQL의 파라미터 타입도 메서드의 파라미터 타입과 일치해야 한다.
@MapperScan("com.bitcamp.board.dao")
public class MybatisConfig {

  public MybatisConfig() {
    System.out.println("MybatisConfigConfig() 생성자 호출됨!");
  }
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource ds,
      ApplicationContext iocContainer
      ) throws Exception {

    System.out.println("sqlSessionFactory() 호출됨!");

    // Mybatis의 Log4j2 기능 활성화 시키기
    LogFactory.useLog4J2Logging();

    // SqlSessionFactory를 만들어줄 객체를 준비한다.
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

    // Mybatis가 사용할 DB 커넥션풀을 설정한다. 
    factoryBean.setDataSource(ds);

    // Mybatis가 실행할 SQL문이 들어 있는 파일의 위치를 설정한다.
    factoryBean.setMapperLocations(
        iocContainer.getResources("classpath:com/bitcamp/board/mapper/*Mapper.xml"));

    // 도메인 클래스의 별명을 자동으로 부여한다.
    // - 
    factoryBean.setTypeAliasesPackage("com.bitcamp.board.domain");

    return factoryBean.getObject();
  }

}
