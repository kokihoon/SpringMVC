package main.java.com.kokihoon.service;

import java.util.Date;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginService {
	
	public User login(LoginDto loginDto) throws Exception;
	
	public void keepLogin(String userId, String sessionId, Date next) throws Exception;
	
	public User checkLoginBefore(String value) throws Exception;
	
}
