package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl  implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = boardDAO.searchAll() ;
		return boardList;
	}

	public void writeForm(BoardVO board) {
		
		boardDAO.writeForm(board);
		
		
	}

}
