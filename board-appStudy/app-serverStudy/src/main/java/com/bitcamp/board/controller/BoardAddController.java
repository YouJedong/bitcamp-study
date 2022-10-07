package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      List<FileItem> items = upload.parseRequest(request);

      Board board = new Board();
      List<AttachedFile> attachedFiles = new ArrayList<>();

      for (FileItem item : items) {
        if (item.isFormField()) {
          String paramName = item.getFieldName();
          String paramValue = item.getString("UTF-8");

          switch (paramName) {
            case "title": board.setTitle(paramValue);
            case "content": board.setContent(paramValue);
          }
        } else {
          String filename = UUID.randomUUID().toString();

          attachedFiles.add(new AttachedFile(filename));

          String dirPath = this.getServletContext().getRealPath("/board/files");


        }
      }


      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));



      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      board.setWriter(loginMember);

      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      //      // 1. JSP의 해더 설정 + 작업처리 위임 
      //      response.setHeader("Refresh", "1;url=list");
      //      response.setContentType("text/html; charset=UTF-8");
      //      request.getRequestDispatcher("/board/add.jsp").include(request, response);

      // 2. 작업처리 위임 (Refresh)
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/board/add.jsp").include(request, response);

      //      // 3.
      //      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}




