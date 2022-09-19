package com.bitcamp.board;

import static org.reflections.scanners.Scanners.TypesAnnotated;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import com.bitcamp.board.handler.ErrorHandler;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.Repository;
import com.bitcamp.servlet.annotation.WebServlet;

public class ApplicationContainer {

  //객체(DAO, 서블릿)를 보관할 맵을 준비
  Map<String,Object> objMap = new HashMap<>();
  Reflections reflections;
  ErrorHandler errorHandler = new ErrorHandler();

  public ApplicationContainer(String packageName) throws Exception {
    reflections = new Reflections(packageName);

    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");

    Set<Class<?>> classes = reflections.get(TypesAnnotated.with(Repository.class).asClass());
    for (Class<?> clazz : classes) {
      String objName = clazz.getAnnotation(Repository.class).value();
      Constructor<?> constructor =clazz.getConstructor(Connection.class);
      objMap.put(objName, constructor.newInstance(con));
    }

    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    for (Class<?> servlet : servlets) {
      String servletPath = servlet.getAnnotation(WebServlet.class).value();

      Constructor<?> constructor = servlet.getConstructors()[0];
      Parameter[] params = constructor.getParameters();

      if (params.length == 0) { // 생성자의 파라미터가 없다면, 즉 기본 생성자라면 
        objMap.put(servletPath, constructor.newInstance());

      } else { // 생성자의 파라미터가 있다면, 
        Object argument = findObject(objMap, params[0].getType());
        if (argument != null) { // 생성자의 파라미터 타입과 일치하는 객체를 찾았다면 
          objMap.put(servletPath, constructor.newInstance(argument));
        }
      }
    }
  }

  public void execute(String path, String query, PrintWriter out) throws Exception {

    // query String을 분석하여 파라미터 값을 맵에 저장한다.
    Map<String,String> paramMap = new HashMap<>();
    if (query != null && query.length() > 0) { // 예) no=1&title=aaaa&content=bbb
      String[] entries = query.split("&");
      for (String entry : entries) { // 예) no=1
        String[] kv = entry.split("=");
        // 웹브라우저가 보낸 파라미터 값은 저장하기 전에 URL 디코딩 한다.
        paramMap.put(kv[0], URLDecoder.decode(kv[1], "UTF-8"));
      }
    }
    //    System.out.println(paramMap);

    //
    Servlet servlet = (Servlet) objMap.get(path);
    if (servlet != null) {
      servlet.service(paramMap, out);
    } else {
      errorHandler.service(paramMap, out);
    }

  }

  private static Object findObject(Map<String, Object> objMap, Class<?> type) {

    Collection<Object> values = objMap.values();

    for (Object value : values) {
      if (type.isInstance(value)) {  
        return value; 
      }
    }

    return null; 
  }

}








