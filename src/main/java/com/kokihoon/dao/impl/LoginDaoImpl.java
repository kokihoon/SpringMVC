package main.java.com.kokihoon.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.dao.LoginDao;
import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SqlSession session;
	
	private static String namespace = "main.java.com.kokihoon.mapper.userMapper";
	
	@Override
	public User login(LoginDto loginDto) throws Exception {
		
		return session.selectOne(namespace + ".login", loginDto);
	}
}