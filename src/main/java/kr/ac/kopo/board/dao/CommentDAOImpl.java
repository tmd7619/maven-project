package kr.ac.kopo.board.dao;

import kr.ac.kopo.board.vo.CommentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {


    SqlSessionTemplate sqlSessionTemplate;
    private String namespace = "board.CommentDAO.";

    public List<CommentVO> selectComment(int no) {

        List<CommentVO> commentList = sqlSessionTemplate.selectList(namespace + "selectComment", no);

        return commentList;
    }


    public List<CommentVO> writeComment(CommentVO commentVO) {

        System.out.println("in dao commentVO : " + commentVO);
        List<CommentVO> commentList;
        int check = sqlSessionTemplate.insert(namespace + "writeComment", commentVO);

        if (check == 1) {
            System.out.println("insert comment 성공");
            commentList = selectComment(commentVO.getNo()); // 비동기 처리를 위해, insert 후 바로 select
        } else {
            return null;
        }
        return commentList;
    }


}
