package kr.ac.kopo;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class BoardTest {


    @Autowired
    private BoardDAO boardDAO;
    //private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private BoardService boardService;

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    //@Ignore
    @Test
    public void 전체게시글조회Test() throws Exception {
//		List<BoardVO> list = boardDAO.searchAll(); // boardDAO가 sqlSessionTemplate 객체를 가지고 있기 때문에 이 방법으로 실행 가능
        List<BoardVO> list = boardService.selectAllBoard();
        for (BoardVO board : list) {
            System.out.println(board);
        }
    }

    @Ignore
    @Test
    public void 상세게시글조회Test() throws Exception {

        BoardVO board = sessionTemplate.selectOne("board.BoardDAO.selectByNo", 121);

    }

}
