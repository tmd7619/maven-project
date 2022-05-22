package kr.ac.kopo.board.controller;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
