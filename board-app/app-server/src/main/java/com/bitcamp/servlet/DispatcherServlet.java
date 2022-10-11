package com.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
//@WebServlet(value = "/service/*")
@Component
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // 인터페이스로 받기 (Annotatio~~ 으로 하지말고 왜냐면 다양한COntext가들어오게
  ApplicationContext iocContainer;

  public DispatcherServlet(ApplicationContext iocContainer) {
    // s
    this.iocContainer = iocContainer; 
  }

  // doPost, doGet을 다 받아야 하기 때문에 service로 오버라이드 받는게 맞다.
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      // 프론트 컨트롤러를 경유해서 실행하 페이지 컨트롤러의 경로를 알아낸다.
      // - "/service" 다음에 오는 경로, 즉 * 에 해당하는 경로를 리턴한다.
      String pathInfo = req.getPathInfo();

      // 페이지 컨트롤러를 찾는다.
      // - Spring IoC 컨테이너는 객체를 찾지 못하면 예외를 발생시킨다.
      Controller controller = (Controller) iocContainer.getBean(pathInfo);

      // 페이지 컨트롤러 실행한다.
      resp.setContentType("text/html;charset=UTF-8"); // 인클루드하려면 여기서 설정해줘야 한다.
      String viewName = controller.execute(req, resp);

      if (viewName.startsWith("redirect:")) { // 페이지 컨트롤러를 정상적으로 실행했다면
        resp.sendRedirect(viewName.substring(9)); // 예) "list" <-- 리다이렉트할 URL을 잘라낸다.
        return;

      } else {
        req.getRequestDispatcher(viewName).include(req, resp); // JSP 실행한 후 리턴된다.
      }
    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, resp);      
    }
  }
}
