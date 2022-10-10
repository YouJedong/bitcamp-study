package com.bitcamp.board.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.service.DefaultBoardService;
import com.bitcamp.board.service.DefaultMemberService;
import com.bitcamp.sql.DataSource;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유자원 준비 중!!");
    try {
      ServletContext ctx = sce.getServletContext();

      DataSource ds = new DataSource(
          "org.mariadb.jdbc.Driver", 
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", 
          "1111");

      BoardDao boardDao = new MariaDBBoardDao(ds);
      MemberDao memberDao = new MariaDBMemberDao(ds);

      ctx.setAttribute("boardService", new DefaultBoardService(boardDao, ds));
      ctx.setAttribute("memberService", new DefaultMemberService(memberDao));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }  
}
