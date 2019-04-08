package main.java.com.kokihoon.dao;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginDao {
	
	// 로그인 처리
	public User login(LoginDto loginDto) throws Exception;
}
