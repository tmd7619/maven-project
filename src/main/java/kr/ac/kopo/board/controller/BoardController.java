package kr.ac.kopo.board.controller;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/board")
@Controller
public class BoardController {

    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String selectAllBoard(Model model) {

        List<BoardVO> boardList = service.selectAllBoard();

//        for (BoardVO b : boardList) {
//            System.out.println(b);
//        }

        model.addAttribute("boardList", boardList);

        return "board/list";

    }

    @GetMapping("/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
    public String writeForm(Model model) { // Spring form 태그를 사용하기 위해서는, 공유 영역에 객체를 등록해야한다. // BoardVO board로도 공유영역 객체 등록 가능
        // form태그의 속성 modelAttribute="객체명" 과 동일하게 설정해야함.
        model.addAttribute("boardVO", new BoardVO());
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardVO boardVO, Model model) {

        System.out.println("writeForm에서 넘어온 boardVO? :" + boardVO);
        String msg = service.write(boardVO);

        model.addAttribute("writeMsg", msg);

        return "redirect:/board/list";
    }


    @GetMapping("/detail/{no}")
    public String detail(@PathVariable("no") int no, Model model) {
        System.out.println("방 번호 넘어오는지? : " + no);

        BoardVO boardVO = service.detail(no);

        System.out.println("detail boardVo 넘어옴? : " + boardVO);

        model.addAttribute("board", boardVO);


        return "board/detail";
    }

    @GetMapping("/modifyForm/{no}")
    public String modifyForm(@PathVariable("no") int no, Model model) {

        System.out.println("in modifyForm no? :" + no);

        BoardVO boardVO = service.detail(no);

        model.addAttribute("board", boardVO);
        return "board/modify";
    }

    @PostMapping("board/modify")
    public String modify(BoardVO boardVO) {

        System.out.println("modify form에서 넘어온 board? : " + boardVO);

        return null;
    }

}
