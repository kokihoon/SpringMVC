package main.java.com.kokihoon.dao.impl;

import java.util.List;

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
	public List<BoardVO> listAll() throws Exception {
		return session.selectList("board.listAll");
	}

	@Override
	public BoardVO read(int articleNo) throws Exception {
		return session.selectOne("board.view", articleNo);
	}


}
