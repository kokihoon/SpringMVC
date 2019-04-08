package main.java.com.kokihoon.dao;

import main.java.com.kokihoon.model.User;

public interface RegisterDao {
	
	// 회원가입 처리
	public void register(User user) throws Exception;
}
