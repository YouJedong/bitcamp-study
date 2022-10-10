package com.bitcamp.board.service;

import java.util.List;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.transaction.TransactionManager;
import com.bitcamp.transaction.TransactionStatus;

public class DefaultBoardService implements BoardService{
  BoardDao boardDao;
  TransactionManager txManager;

  public DefaultBoardService(BoardDao boardDao, TransactionManager txManager) {
    this.boardDao = boardDao;
    this.txManager = txManager;
  }

  @Override
  public void add(Board board) throws Exception {
    TransactionStatus status = txManager.getTransaction();
    try {
      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      boardDao.insertFiles(board);
      txManager.commit(status);

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }

  }

  @Override
  public Board get(int no) throws Exception {
    return boardDao.findByNo(no);
  }

  @Override
  public boolean delete(int no) throws Exception {
    TransactionStatus status = txManager.getTransaction();

    try {
      boardDao.deleteFiles(no);

      boolean result = boardDao.delete(no) > 0;

      txManager.commit(status);

      return result;

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
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
    TransactionStatus status = txManager.getTransaction();
    try {
      if (boardDao.update(board) == 0) {
        return false;
      }
      boardDao.insertFiles(board);

      txManager.commit(status);

      return true;

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;

    }
  }



}
