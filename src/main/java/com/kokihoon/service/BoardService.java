package main.java.com.kokihoon.service;

import java.util.List;

import main.java.com.kokihoon.model.param.BoardVO;

public interface BoardService {
	
	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	public BoardVO read(int articleNo) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int articleNo) throws Exception;
}
