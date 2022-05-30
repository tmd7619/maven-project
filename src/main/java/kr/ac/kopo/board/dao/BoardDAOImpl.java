package kr.ac.kopo.board.dao;

import kr.ac.kopo.board.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    private String namespace = "board.BoardDAO.";

    public BoardDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<BoardVO> selectAllBoard() {

        List<BoardVO> boardList = sqlSessionTemplate.selectList(namespace + "selectAllBoard");

        return boardList;
    }

    public int write(BoardVO boardVO) {

        System.out.println("in dao writeBoard : " + boardVO);

        int check = sqlSessionTemplate.insert(namespace + "writeForm", boardVO);

        return check;
    }

    public BoardVO detail(int no) {

        BoardVO boardVO = sqlSessionTemplate.selectOne(namespace + "detailBoard", no);

        return boardVO;
    }

    public int modfiy(BoardVO boardVO) {

        int check = sqlSessionTemplate.update(namespace + "modify", boardVO);

        return check;
    }
}
