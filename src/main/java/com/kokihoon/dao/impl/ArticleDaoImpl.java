package main.java.com.kokihoon.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.kokihoon.dao.ArticleDao;
import main.java.com.kokihoon.model.param.Article;

public class ArticleDaoImpl implements ArticleDao{

	private static final String NAMESPACE = "main.java.com.kokihoon.mapper.articleMapper";
	
	@Autowired
	SqlSession session;
	
	@Override
	public void create(Article article) throws Exception {
		session.insert(NAMESPACE + ".create", article);
	}

	@Override
	public Article read(Integer articleNo) throws Exception {
		return session.selectOne(NAMESPACE+".read", articleNo);
	}

	@Override
	public void update(Article article) throws Exception {
		session.update(NAMESPACE+".update", article);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		session.delete(NAMESPACE+".delete", articleNo);
	}

	@Override
	public List<Article> listAll() throws Exception {
		return session.selectList(NAMESPACE+".listAll");
	}
}
