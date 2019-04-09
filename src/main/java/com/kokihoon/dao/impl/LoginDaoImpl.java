package main.java.com.kokihoon.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	// 로그인 유지 처리
	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);
		
		session.update(namespace + ".keepLogin", paramMap);
		
	}
	
	// 세션키 검증
	@Override
	public User checkUserWithSessionKey(String value) throws Exception {
		return session.selectOne(namespace+".checkUserWithSessionKey", value);
	}
}