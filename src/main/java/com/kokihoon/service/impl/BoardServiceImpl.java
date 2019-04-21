package main.java.com.kokihoon.service.impl;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
//		title = title.replace("<", "&lt;");
//		title = title.replace("<", "&gt;");
//
//		writer = writer.replace("<", "&lt;");
//		writer = writer.replace("<", "&gt;");
//
//		title = title.replace("  ", "&nbsp;&nbsp;");
//		writer = writer.replace("  ", "&nbsp;&nbsp;");
//
//		content = content.replace("/n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return boardDao.listAll();
	}

	@Override
	public BoardVO read(int articleNo) throws Exception {
		return boardDao.read(articleNo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}
	
}
