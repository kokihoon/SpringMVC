package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.model.param.ReplyVO;

public interface ReplyDao {
	public int create(ReplyVO reply) throws Exception;
	public int update(ReplyVO reply) throws Exception;
	public int delete(Integer articleNo) throws Exception;
	public List<ReplyVO> list(Integer articleNo, Criteria criteria) throws Exception;
	public int countReply(Integer articleNo) throws Exception;
	public List<ReplyVO> getReplies(Integer articleNo);
	public int getArticleNo(Integer replyNo) throws Exception;
}
