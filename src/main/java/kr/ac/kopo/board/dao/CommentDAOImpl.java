package kr.ac.kopo.board.dao;

import kr.ac.kopo.board.vo.CommentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {


    private SqlSessionTemplate sqlSessionTemplate;
    private String namespace = "kr.ac.kopo.board.dao.CommentDAO.";

    public CommentDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<CommentVO> selectComment(int no) {

        List<CommentVO> commentList = sqlSessionTemplate.selectList(namespace + "selectComment", no);

        return commentList;
    }


    public List<CommentVO> writeComment(CommentVO commentVO) {

        System.out.println("in dao commentVO : " + commentVO);
        try {
            sqlSessionTemplate.insert(namespace + "writeComment", commentVO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("insert comment 성공");
        List<CommentVO> commentList = selectComment(commentVO.getNo()); // 비동기 처리를 위해, insert 후 바로 select

        return commentList;
    }


}
