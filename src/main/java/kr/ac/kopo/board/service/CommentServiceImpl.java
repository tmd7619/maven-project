package kr.ac.kopo.board.service;


import kr.ac.kopo.board.dao.CommentDAO;
import kr.ac.kopo.board.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentDAO commentDAO;

    public List<CommentVO> writeComment(CommentVO commentVO) {

        List<CommentVO> commentList = commentDAO.writeComment(commentVO);

        return commentList;
    }

}
