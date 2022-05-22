package kr.ac.kopo.board.dao;

import kr.ac.kopo.board.vo.BoardVO;

import java.util.List;

public interface BoardDAO {

    List<BoardVO> selectAllBoard();
}
