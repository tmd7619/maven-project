package kr.ac.kopo.board.service;

import kr.ac.kopo.board.vo.CommentVO;

import java.util.List;

public interface CommentService {

    List<CommentVO> writeComment(CommentVO commentVO);


}
