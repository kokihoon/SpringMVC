package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.model.param.BoardVO;

public interface BoardDao {
	
	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll() throws Exception;

}
