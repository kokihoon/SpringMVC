package main.java.com.kokihoon.mapper;

import java.util.List;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.model.param.BoardVO;

public interface articleMapper {
	
	public void create(BoardVO vo) throws Exception;

	public List<BoardVO> listAll(Criteria cri) throws Exception;
}
