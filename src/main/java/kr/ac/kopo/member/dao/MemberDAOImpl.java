package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl  implements MemberDAO{

    // 네임스페이스 변수로 지정 // 패키지명 명시
    private String namespace = "member.MemberDAO.";

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public MemberVO login(MemberVO memberVO) {


        MemberVO userVO = sqlSessionTemplate.selectOne(namespace + "login" , memberVO);


        return userVO;

    }
}
