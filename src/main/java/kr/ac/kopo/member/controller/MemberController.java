//package kr.ac.kopo.member.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import kr.ac.kopo.member.service.MemberService;
//import kr.ac.kopo.member.vo.MemberVO;
//
//							 // 원래는 {} 배열 형태로, 여러개 등록 가능
//@SessionAttributes("userVO") // request 공유 영역에 올린 객체 중, userVO 이름을 가진 객체는 Sesession 영역에 올려주는 어노테이션
//@Controller
//public class MemberController {
//
//	@Autowired
//	private MemberService service;
//
//
//	@GetMapping("/login")
//	public String loginForm() {
//
//		return "login/login";
//	}
//
//	@PostMapping("/login")
//	public String login(MemberVO member , Model model, HttpSession session) {
//
//		MemberVO userVO = service.login(member);
//		System.out.println(userVO);
//
//		if(userVO == null) {
//			String msg = "아이디 또는 패스워드가 잘못되었습니다.";
//			model.addAttribute("msg", msg);
//			return "login/login";
//		}
//
//		// 로그인 성공
//		model.addAttribute("userVO", userVO);
//
//
//		session.setAttribute("userVO", userVO); // redirect로 인해, session에 미리 등록해준다.
//		String dest = (String)session.getAttribute("dest");
//		if(dest != null) { // 로그인 페이지 전에 다른
//			session.removeAttribute("dest"); // dest session은 이제 필요 없기 때문에, 세션 제거
//			return "redirect:" + dest;  // 로그인 전 페이지로 redirect
//		}
//
//		return "redirect:/"; // 스프링에서는 redirect 시 , 포워드 처럼 루트패스 다음으로 경로를 잡아줌
//	}
//
//	@GetMapping("/logout")
//	public String logout(SessionStatus sessionStatus) { // @SessionAttributes 어노테이션을 쓰면 SessionStatus로 사용해야함
//
////		session.invalidate(); // @SessionAttributes 시 ,사용 불가
//		System.out.println(sessionStatus.isComplete());
//		sessionStatus.setComplete(); // isCOmplete를 false -> true로 바꿔주는 방식
//		System.out.println(sessionStatus.isComplete());
//
//		return "redirect:/";
//
//	}
//
//}
