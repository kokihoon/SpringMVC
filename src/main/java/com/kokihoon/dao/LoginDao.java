package main.java.com.kokihoon.dao;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginDao {
	
	// �α��� ó��
	public User login(LoginDto loginDto) throws Exception;
}
