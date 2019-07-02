package main.java.com.kokihoon.service.impl;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.dao.BoardDao;
import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;

	@Override
	public void create(BoardVO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}

	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception {		
		return boardDao.listAll(cri);
	}
	
	// 조회수 증가 트랜잭션 적용
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(int articleNo) throws Exception {
		boardDao.updateViewCnt(articleNo);
		return boardDao.read(articleNo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}

	@Override
	public void delete(int articleNo) throws Exception {
		boardDao.delete(articleNo);
	}

	@Override
	public int countArticle(Criteria cri) throws Exception {
		return boardDao.countArticle(cri);
	}
	
}
