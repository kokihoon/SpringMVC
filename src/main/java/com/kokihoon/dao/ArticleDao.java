package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.model.param.Article;

public interface ArticleDao {
	public void create(Article article) throws Exception;
	
	public Article read(Integer articleNo) throws Exception;
	
	public void update(Article article) throws Exception;
	
	public void delete(Integer articleNo) throws Exception;
	
	List<Article> listAll() throws Exception;
}
