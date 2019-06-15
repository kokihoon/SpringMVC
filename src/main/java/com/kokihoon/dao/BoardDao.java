package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.model.param.BoardVO;

public interface BoardDao {
	
	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll(String searchOption, String keyword) throws Exception;
	
	public BoardVO read(int articleNo) throws Exception;

	public void update(BoardVO vo);

	public void delete(int articleNo);

	public int countArticle(String searchOption, String keyword) throws Exception;

}
