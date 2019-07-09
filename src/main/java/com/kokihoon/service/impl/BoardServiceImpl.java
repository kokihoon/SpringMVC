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
import main.java.com.kokihoon.dao.BoardFileDao;
import main.java.com.kokihoon.model.param.BoardVO;
import main.java.com.kokihoon.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;
	
	@Autowired
	BoardFileDao boardFileDao;

	@Override
	public void create(BoardVO vo) throws Exception {

		boardDao.create(vo);
	    String[] files = vo.getFiles();

	    if (files == null)
	        return;

	    // 게시글 첨부파일 입력처리
	    for (String fileName : files)
	        boardFileDao.addFile(fileName);
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
