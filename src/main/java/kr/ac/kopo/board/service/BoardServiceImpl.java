package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardDAO boardDAO;

    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public List<BoardVO> selectAllBoard() {

        List<BoardVO> boardList = boardDAO.selectAllBoard();

        return boardList;
    }
}
