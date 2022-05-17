package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	
	@Autowired
	private MemberDAO memberDAO ; // 인터페이스 기반의 객체들을 주입시켜야함 -> AutoWired는 MemberDAO 형태의 적절한 객체를 찾아 주입시키기 때문에, 
								//유지보수 차원에서 인터페이스형의 객체를 주입시키는 것이 좋다 ( 묵시적 형변환에 의해 타입에 대해 자유로움)
	
	public MemberVO login(MemberVO member) {
		
		MemberVO userVO = memberDAO.login(member);
		
		
		
		return userVO;
	}
	
	

}
