package main.java.com.kokihoon.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.dao.BoardDao;
import main.java.com.kokihoon.dao.ReplyDao;
import main.java.com.kokihoon.model.param.ReplyVO;
import main.java.com.kokihoon.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDao replyDAO;
	
	@Autowired
	BoardDao boardDAO;
	
	
	// ¥Ò±€ µÓ∑œ
	@Transactional
	@Override
	public int create(ReplyVO reply) throws Exception {
		
		replyDAO.create(reply);
		return boardDAO.updateReplyCnt(reply.getArticleNo(), 1);
	}
	
	@Override
	public int update(ReplyVO reply) throws Exception {
		return replyDAO.update(reply);	
	}
	
	// ¥Ò±€ ªË¡¶
	@Transactional
	@Override
	public int delete(Integer replyNo) throws Exception {
		int articleNo = replyDAO.getArticleNo(replyNo);
		replyDAO.delete(replyNo);
		return boardDAO.updateReplyCnt(articleNo, -1);
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
