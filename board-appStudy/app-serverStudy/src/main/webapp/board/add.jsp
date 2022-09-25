<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bitcamp.board.dao.BoardDao"%>
<%@ page import="com.bitcamp.board.domain.Board"%>

<%!
  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
<meta http-equiv='Refresh' content='1; url=list'>
</head>
<body>
<h1>게시글 입력-JSP</h1>

<%
try {
  Board board = new Board();
  board.title = request.getParameter("title");
  board.content = request.getParameter("content");
  board.memberNo = Integer.parseInt(request.getParameter("writerNo"));

  if (boardDao.insert(board) == 0) {
%>
    <p>게시글을 등록할 수 없습니다!</p>
<%
  } else {
%>
    <p>게시글을 등록했습니다.</p>
<%
  }
  } catch (Exception e) {
%>
    <p>실행 중 오류 발생!</p>
<%
}
%>
</body>
</html>




