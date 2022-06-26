package kr.ac.kopo.board.service;


import kr.ac.kopo.board.dao.CommentDAO;
import kr.ac.kopo.board.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public List<CommentVO> writeComment(CommentVO commentVO) {

        System.out.println("in CommentServiceImpl : " + commentVO);
        List<CommentVO> commentList = commentDAO.writeComment(commentVO);

        return commentList;
    }

}
