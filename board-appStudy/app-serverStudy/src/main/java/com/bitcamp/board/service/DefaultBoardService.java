package com.bitcamp.board.service;

import java.util.List;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.sql.DataSource;

public class DefaultBoardService implements BoardService{
  BoardDao boardDao;
  DataSource ds;

  public DefaultBoardService(BoardDao boardDao, DataSource ds) {
    this.boardDao = boardDao;
    this.ds = ds;
  }

  @Override
  public void add(Board board) throws Exception {
    ds.getConnection().setAutoCommit(false);
    try {
      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      boardDao.insertFiles(board);
      ds.getConnection().commit();

    } catch (Exception e) {
      ds.getConnection().rollback();
      throw e;

    } finally {
      ds.getConnection().setAutoCommit(true);
    }
  }

  @Override
  public Board get(int no) throws Exception {
    return boardDao.findByNo(no);
  }

  @Override
  public boolean delete(int no) throws Exception {
    ds.getConnection().setAutoCommit(false);

    try {
      boardDao.deleteFiles(no);

      boolean result = boardDao.delete(no) > 0;

      ds.getConnection().commit();

      return result;

    } catch (Exception e) {
      ds.getConnection().rollback();
      throw e;

    } finally {
      ds.getConnection().setAutoCommit(true);
    }
  }

  @Override
  public AttachedFile getAttachedFile(int no) throws Exception {
    return boardDao.findFileByNo(no);
  }

  @Override
  public boolean deleteAttachedFile(int no) throws Exception {
    return boardDao.deleteFile(no) > 0;
  }

  @Override
  public List<Board> list() throws Exception {
    return boardDao.findAll();
  }

  @Override
  public boolean update(Board board) throws Exception {
    ds.getConnection().setAutoCommit(false);
    try {
      if (boardDao.update(board) == 0) {
        return false;
      }
      boardDao.insertFiles(board);

      ds.getConnection().commit();

      return true;

    } catch (Exception e) {
      ds.getConnection().rollback();
      throw e;

    } finally {
      ds.getConnection().setAutoCommit(true);
    }
  }



}
