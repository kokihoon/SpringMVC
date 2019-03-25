package main.java.com.kokihoon.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.dao.LoginDao;
import main.java.com.kokihoon.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SqlSession session;
	
	private static String namespace = "main.resources.mapper.sql.userMapper";
	
	@Override
	public User login(User user) throws Exception {
		return session.selectOne(namespace + ".login1", user);
	}
}