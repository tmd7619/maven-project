package kr.ac.kopo.board.controller;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        System.out.println("boardList ? :" + boardList);

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


}
