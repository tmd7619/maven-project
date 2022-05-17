package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardVO> searchAll() {
		List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		return list;
	}

	public void writeForm(BoardVO board) {
		
		sqlSessionTemplate.insert("board.BoardDAO.writeForm" , board);
		
	}
		
		
}
