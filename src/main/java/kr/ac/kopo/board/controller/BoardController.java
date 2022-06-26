package kr.ac.kopo.board.controller;

import com.google.gson.Gson;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.service.CommentService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.board.vo.CommentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    public BoardController(BoardService service, CommentService commentService) {
        this.boardService = service;
        this.commentService = commentService;
    }

    @GetMapping("/board/list")
    public String selectAllBoard(Model model) {

        List<BoardVO> boardList = boardService.selectAllBoard();

//        for (BoardVO b : boardList) {
//            System.out.println(b);
//        }

        model.addAttribute("boardList", boardList);

        return "board/list";

    }

    @GetMapping("/board/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
    public String writeForm(Model model) { // Spring form 태그를 사용하기 위해서는, 공유 영역에 객체를 등록해야한다. // BoardVO board로도 공유영역 객체 등록 가능
        // form태그의 속성 modelAttribute="객체명" 과 동일하게 설정해야함.
        model.addAttribute("boardVO", new BoardVO());
        return "board/write";
    }

    @PostMapping("/board/write")
    public String write(BoardVO boardVO, Model model) {

        System.out.println("writeForm에서 넘어온 boardVO? :" + boardVO);

        boardVO.setWriter(boardVO.getWriter().replace(",", ""));

        System.out.println(", 없앤 boardVO? : " + boardVO);

        String msg = boardService.write(boardVO);

        model.addAttribute("writeMsg", msg);

        return "redirect:/board/list";
    }


    @GetMapping("/board/detail/{no}")
    public String detail(@PathVariable("no") int no, Model model) {
        System.out.println("방 번호 넘어오는지? : " + no);

        BoardVO boardVO = boardService.detail(no);

        System.out.println("detail boardVo 넘어옴? : " + boardVO);

        model.addAttribute("board", boardVO);


        return "board/detail";
    }

    // GET 방식 중 RESTful하게 이용하는 방식
    @GetMapping("/board/modifyForm/{no}")
    public String modifyForm(@PathVariable("no") int no, Model model) {

        //    System.out.println("in modifyForm no? :" + no);

        BoardVO boardVO = boardService.detail(no);

        model.addAttribute("board", boardVO);
        return "board/modify";
    }

    @PostMapping("/board/modify")
    public String modify(BoardVO boardVO, Model model) {

        // System.out.println("modify form에서 넘어온 board? : " + boardVO);

        BoardVO modifiedVO = boardService.modify(boardVO);

        System.out.println(" 수정완료? modifiedVO ? : " + modifiedVO);

        model.addAttribute("boardVO", modifiedVO);

        return "redirect:/board/detail/" + modifiedVO.getNo();
    }

    // GET 방식 중, 쿼리 스트링을 적용한 방식 ex) '~/delete?no=' + no
    @GetMapping("/board/delete")
    public String delete(BoardVO boardVO) {

        System.out.println("in delete boardVo 넘버 넘어옴 ? : " + boardVO);

        boardService.delete(boardVO);

        return "redirect:/board/list";
    }

    @PostMapping("/board/comment")
    public ModelAndView addComment(@RequestBody String msg) {
        // @RequestBody를 쓸때, 무엇 때문이지 vo로 받아올 수 없다.(Mapping error) -> 이유 찾아보기

        ModelAndView mav = new ModelAndView();
        System.out.println("ajax string으로 받은 내용? : " + msg);

        Gson gson = new Gson();
        CommentVO commentVO = gson.fromJson(msg, CommentVO.class);
        System.out.println("msg to commentVO :" + commentVO);

        List<CommentVO> commentList = commentService.writeComment(commentVO);

        for (CommentVO c : commentList)
            System.out.println("write 후 저장된 commentList 불러오기 : " + c);

        mav.addObject("commentList", commentList);
        return mav;

    }

}
