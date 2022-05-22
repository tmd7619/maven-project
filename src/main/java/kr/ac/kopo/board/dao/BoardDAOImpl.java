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
}
