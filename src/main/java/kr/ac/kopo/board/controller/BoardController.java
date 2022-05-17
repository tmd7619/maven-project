package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@RequestMapping("/board")
	public ModelAndView selectAll() {
		List<BoardVO> boardList = service.selectAllBoard();
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list" , boardList);
		
		return mav;
	}
	
	// http://localhost:9999/Mission-Spring/board/detail?no=
	@RequestMapping("/board/detail")
	public void selectByNo(HttpServletRequest request) {
//		public void selectByNo(@RequestParam("no") int no , Model model) { // 어노테이션으로 int no에 request 받아온 정보값 주입
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
	}
	
	// Rest 방식 사용
	// http://localhost:9999/Mission-Spring/board/번호
	@RequestMapping("/board/{no}") //requestMapping 안에 변수를 넣고 싶으면 {변수명} 으로 넣어주면 된다.	
	public ModelAndView selectByNo2(@PathVariable("no") int no) { // 경로 내에 있는 변수 no를 int no에 주입하겠다.
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board" , new BoardVO());
		
		return mav;
	}
//---------------------------------------------------------------------------------------------------------	
	
	@GetMapping("/board/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
	public String writeForm(Model model) { // Spring form 태그를 사용하기 위해서는, 공유 영역에 객체를 등록해야한다. // BoardVO board로도 공유영역 객체 등록 가능 
											// form태그의 속성 modelAttribute="객체명" 과 동일하게 설정해야함.
		model.addAttribute("boardVO", new BoardVO()); 
		return "board/write" ;
		
	}
	
	@PostMapping("/board/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
	public String write( @Valid BoardVO board , Errors error ) { // BoardVO의 앞글자 소문자로 된 boardVO로 객체 등록됨
		System.out.println("post/board/write");
		System.out.println(board);
//		System.out.println(error.hasErrors()); // empty가 있으면 true값이 나옴
		
		if(error.hasErrors()) { // true인경우, ( empty가 존재 )
			System.out.println("오류 발생 !!!");
			return "board/write"; // 다시 등록폼으로 포워든
		}
		
		service.writeForm(board);
		
		return "redirect:/board";
	}
	
	
/*	
	// get 방식일 때는, form 페이지를 불러오는 역할
//	@RequestMapping(value="/board/write" , method=RequestMethod.GET) // 똑같은 url이가 들어와도, method 방식에 따라 각각의 컨트롤러가 작동한다.
	@GetMapping("/board/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
	public String writeForm() {
		
		return "board/write" ;
		
	}
	
//	@RequestMapping(value="board/write" , method=RequestMethod.POST)
	@PostMapping("/board/write") // spring 4.3 버전 이상 부터 사용 가능 // rest 방식
	public String write(BoardVO board , Model model) { // void 메서드일때, value의 url로 자동 forward 된다.  => return "board/write" 
		System.out.println("post/board/write");
		System.out.println(board);
		return "redirect:/board";
	}
	
*/
	
	
	
	
}
