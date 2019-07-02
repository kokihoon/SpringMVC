package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.model.param.BoardVO;

public interface BoardDao {
	
	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll(Criteria cri) throws Exception;
	
	public BoardVO read(int articleNo) throws Exception;

	public void update(BoardVO vo);

	public void delete(int articleNo);

	public int countArticle(Criteria cri) throws Exception;
	
	//댓글 개수 업데이트
	public int updateReplyCnt(Integer articleNo, int amount) throws Exception;
	
	//조회수 업데이트
	public int updateViewCnt(Integer articleNo) throws Exception;

}
