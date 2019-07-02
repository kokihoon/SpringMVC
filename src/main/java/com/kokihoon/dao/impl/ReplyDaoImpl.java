package main.java.com.kokihoon.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.common.Criteria;
import main.java.com.kokihoon.dao.ReplyDao;
import main.java.com.kokihoon.model.param.ReplyVO;


@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	@Autowired
	SqlSession session;
	
	private static String namespace = "main.java.com.kokihoon.mapper.replyMapper";
	
	@Override
	public int create(ReplyVO reply) throws Exception {
		return session.insert(namespace+".create", reply);
	}
	
	@Override
	public int update(ReplyVO reply) throws Exception {
		return session.update(namespace+".update", reply);
	}
	
	@Override
	public int delete(Integer replyNo) throws Exception {
		return session.delete(namespace+".delete", replyNo);
	}
	
	@Override
	public List<ReplyVO> list(Integer articleNo, Criteria criteria) throws Exception {

	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("articleNo", articleNo);
	    paramMap.put("criteria", criteria);

		return session.selectList(namespace+".list", paramMap);
	}

	@Override
	public int countReply(Integer articleNo) throws Exception {
		return session.selectOne(namespace + ".countReplies", articleNo);
	}

	@Override
	public List<ReplyVO> getReplies(Integer articleNo) {
		System.out.println(articleNo+"---------------------------123");
		return session.selectList(namespace+".getReplies", articleNo);
	}

	@Override
	public int getArticleNo(Integer replyNo) throws Exception {
		return session.selectOne(namespace+".getArticleNo", replyNo);
	}

}
