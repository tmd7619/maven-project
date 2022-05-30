package kr.ac.kopo.board.service;

import kr.ac.kopo.board.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> selectAllBoard();

    String write(BoardVO boardVO);

    BoardVO detail(int no);

    BoardVO modify(BoardVO boardVO);

}
