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

    public String write(BoardVO boardVO) {

        int check = boardDAO.write(boardVO);

        if (check == 0) {
            String msg = "등록에 실패하였습니다";
            return msg;
        } else {
            String msg = "게시글 등록 성공";
            return msg;
        }

    }

    public BoardVO detail(int no) {

        BoardVO boardVO = boardDAO.detail(no);

        return boardVO;
    }
}
