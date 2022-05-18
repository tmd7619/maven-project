package kr.ac.kopo.member.controller;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("userVO")
@Controller
public class MemberController2 {

    @Autowired
    private MemberService service;


    @GetMapping("/login") // 로그인 폼 불러오기
    public String loginForm() {

        return "login/login";
    }

    @PostMapping("login")
    public String login(MemberVO memberVO, HttpSession session) {

        System.out.println("form 정보 잘 넘어 오는지?  :" + memberVO);

        MemberVO userVO = service.login(memberVO);

        System.out.println("컨트롤러에 userVO 값 제대로 가져와졌는지? : " + userVO);

        session.setAttribute("userVO", userVO);


        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        // SessionAttributes 어노테이션 사용 시, session.invalidate() 사용 불가
        System.out.println("sessionStatus.isComplete : " + sessionStatus.isComplete());
        sessionStatus.setComplete(); // isComplte 값을 false -> true 로 바꾸는 메서드
        System.out.println("sessionStatus.isComplete : " + sessionStatus.isComplete());

        return "redirect:/";


    }


}
