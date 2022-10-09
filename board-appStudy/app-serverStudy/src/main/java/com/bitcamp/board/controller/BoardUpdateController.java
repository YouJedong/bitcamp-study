package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
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

      String dirPath = this.getServletContext().getRealPath("/board/files");

      for (FileItem item : items) {
        if (item.isFormField()) {
          String paramName = item.getFieldName();
          String paramValue = item.getString("UTF-8");

          switch (paramName) {
            case "no" :  

          }
        }
      }

      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      if (boardDao.findByNo(board.getNo()).getWriter().getNo() != loginMember.getNo()) {
        throw new Exception("게시글의 작성자가 아닙니다.");
      }

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글 변경 실패!");
      }

      response.setHeader("Refresh", "1;url=list");
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/board/update.jsp").include(request, response);


    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  } 
}