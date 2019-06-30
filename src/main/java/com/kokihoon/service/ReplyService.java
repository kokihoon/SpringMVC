package main.java.com.kokihoon.service;

import java.util.List;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.model.param.ReplyVO;

public interface ReplyService {
	public int create(ReplyVO reply) throws Exception;
	public int update(ReplyVO reply) throws Exception;
	public int delete(Integer rno) throws Exception;
	public List<ReplyVO> list(Integer articleNo, Criteria criteria) throws Exception;
	public int countReplies(Integer articleNo) throws Exception;
	public List<ReplyVO> getReplies(Integer articleNo) throws Exception;
}
