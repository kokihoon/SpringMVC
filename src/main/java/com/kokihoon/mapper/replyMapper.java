package main.java.com.kokihoon.mapper;

import java.util.List;

import main.java.com.kokihoon.model.param.ReplyVO;

public interface replyMapper {
	public int register(ReplyVO reply) throws Exception;
	public int modify(ReplyVO reply) throws Exception;
	public int remove(Integer rno) throws Exception;
	public List<ReplyVO> listReplyPage(Integer articleNo) throws Exception;
	public int getTotalCount(Integer articleNo) throws Exception;
	public List<ReplyVO> getReplies(Integer articleNo) throws Exception;
}
