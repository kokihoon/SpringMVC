package main.java.com.kokihoon.dao.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.dao.LoginDao;
import main.java.com.kokihoon.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SqlSession session;
	
	private static String namespace = "main.java.com.kokihoon.mapper.userMapper";
	
	@Override
	public List<User> login(User user) throws Exception {
		
		return session.selectList(namespace + ".login");
	}
}