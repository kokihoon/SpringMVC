package main.java.com.kokihoon.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.dao.ReplyDao;
import main.java.com.kokihoon.model.param.ReplyVO;
import main.java.com.kokihoon.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDao replyDAO;
	
	@Override
	public int create(ReplyVO reply) throws Exception {
		return replyDAO.create(reply);
		
	}
	@Override
	public int update(ReplyVO reply) throws Exception {
		return replyDAO.update(reply);
		
	}
	@Override
	public int delete(Integer articleNo) throws Exception {
		return replyDAO.delete(articleNo);
	}
	@Override
	public List<ReplyVO> list(Integer articleNo, Criteria criteria) throws Exception {
		return replyDAO.list(articleNo, criteria);
	}
	
	@Override
	public int countReplies(Integer articleNo) throws Exception {
	    return replyDAO.countReply(articleNo);
	}
	@Override
	public List<ReplyVO> getReplies(Integer articleNo) throws Exception {
		return replyDAO.getReplies(articleNo);
	}
}
