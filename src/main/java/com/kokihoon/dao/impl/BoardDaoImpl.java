package main.java.com.kokihoon.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.dao.BoardDao;
import main.java.com.kokihoon.model.param.BoardVO;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	SqlSession session;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert("board.insert", vo);
	}

	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception {	
		return session.selectList("board.listAll", cri);
	}

	@Override
	public BoardVO read(int articleNo) throws Exception {
		System.out.println(articleNo+"------------------");
		return session.selectOne("board.view", articleNo);
	}

	@Override
	public void update(BoardVO vo) {
		session.update("board.update", vo);
	}

	@Override
	public void delete(int articleNo) {
		session.delete("board.delete", articleNo);
	}

	@Override
	public int countArticle(Criteria cri) throws Exception{
		return session.selectOne("board.countArticle", cri);
	}

	// 댓글 개수 업데이트
	@Override
	public int updateReplyCnt(Integer articleNo, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("articleNo", articleNo);
		paramMap.put("amount", amount);
		
		return session.update("board.updateReplyCnt", paramMap);
	}

	// 조회수 업데이트
	@Override
	public int updateViewCnt(Integer articleNo) throws Exception {
		return session.update("board.updateViewCnt", articleNo);
	}
}
