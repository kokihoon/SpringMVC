package main.java.com.kokihoon.dao;

import java.util.Date;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginDao {
	
	// 로그인 처리
	public User login(LoginDto loginDto) throws Exception;
	
	// 로그인 유지 처리
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;
	
	// 세션키 검증
	public User checkUserWithSessionKey(String value) throws Exception;
	
}
