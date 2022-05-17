package kr.ac.kopo.member.controller;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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


}
