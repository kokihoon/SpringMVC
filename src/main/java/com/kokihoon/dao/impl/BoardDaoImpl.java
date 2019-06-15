package main.java.com.kokihoon.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<BoardVO> listAll(String searchOption, String keyword) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return session.selectList("board.listAll", map);
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
	public int countArticle(String searchOption, String keyword) throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return session.selectOne("board.countArticle", map);
	}


}
