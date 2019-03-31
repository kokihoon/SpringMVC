package main.java.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import main.java.dao.UserDAO;
import main.java.model.User;



@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static String namespace = "main.resources.mapper.sql.userMapper";

	@Override
	public User login(User user) throws Exception {
		
		return sqlSession.selectOne(namespace+".login", user);
	}
	


}
