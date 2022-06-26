package kr.ac.kopo.board.dao;

import kr.ac.kopo.board.vo.CommentVO;

import java.util.List;

public interface CommentDAO {

    List<CommentVO> selectComment(int no);

    List<CommentVO> writeComment(CommentVO commentVO);
}
