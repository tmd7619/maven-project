package kr.ac.kopo;

import kr.ac.kopo.member.vo.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class) // 실행할 때 마다 JUnit으로 실행하기 위해 설정
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"}) // spring-mvc.xml 파일 읽어오기 
public class MemberTest {


    @Autowired
    private DataSource dataSource; // spring-mvc.xml에 만든 객체를 MybatisTest 클래스 안에 주입시킴

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Test
    public void 로그인테스트() throws Exception {

        MemberVO member = new MemberVO();
        member.setId("test");
        member.setPassword("1234");

        MemberVO userVO = sessionTemplate.selectOne("member.MemberDAO.login", member);
        assertNotNull(userVO);

    }

}
